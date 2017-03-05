package tradeforce.starwars.r2d2.controller;

import android.app.IntentService;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import org.androidannotations.annotations.EIntentService;
import org.androidannotations.annotations.SystemService;

import retrofit2.Call;
import retrofit2.Response;
import tradeforce.starwars.domain.model.Film;
import tradeforce.starwars.domain.model.Person;
import tradeforce.starwars.domain.model.Planet;
import tradeforce.starwars.r2d2.R;
import tradeforce.starwars.r2d2.location.LocationAdapter;
import tradeforce.starwars.r2d2.repository.sqlite.SQLiteHelper;
import tradeforce.starwars.r2d2.util.ReceiverHelper;
import tradeforce.starwars.r2d2.util.RetrofitHelper;
import tradeforce.starwars.r2d2.ws.CharacterEndpoint;
import tradeforce.starwars.r2d2.ws.FilmEndpoint;
import tradeforce.starwars.r2d2.ws.PlanetEndpoint;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.content.pm.PackageManager.PERMISSION_GRANTED;

import static tradeforce.starwars.r2d2.controller.Controllers.Character;

/**
 * Classe de serviço para salvar personagens da Web em base de dados.
 *
 * @author Prestes, E. M.
 * @since Março de 2017
 *
 * @see IntentService
 * @see EIntentService
 * @see SystemService
 */
@EIntentService
public class SaveCharacterService extends IntentService {

    private static final int MIN_TIME = 1000;
    private static final int MIN_DISTANCE = 0;

    private SQLiteHelper.WritableDAO<Person> personDAO;
    private SQLiteHelper.WritableDAO<Film> filmDAO;

    /**
     * Construtor padrão
     */
    public SaveCharacterService() {
        super(SaveCharacterService.class.getSimpleName());
    }

    @SystemService
    LocationManager locationManager;
    private Location location;
    private LocationListener locationListener = new LocationAdapter() {
        @Override
        public void onLocationChanged(Location l) {
            location = l;
        }
    };
    private String provider;

    /** {@inheritDoc} */
    @Override
    public void onCreate() {
        super.onCreate();

        personDAO = SQLiteHelper.getDAOWritable(this, Person.class);
        filmDAO = SQLiteHelper.getDAOWritable(this, Film.class);
        provider = locationManager.getBestProvider(new Criteria(), Boolean.FALSE);

        boolean isNotFine;
        boolean isNotCoarse;

        isNotFine = ActivityCompat.checkSelfPermission(this, ACCESS_FINE_LOCATION) != PERMISSION_GRANTED;
        isNotCoarse = ActivityCompat.checkSelfPermission(this, ACCESS_COARSE_LOCATION) != PERMISSION_GRANTED;

        if (isNotFine && isNotCoarse)
            return;

        locationManager.requestLocationUpdates(provider, MIN_TIME, MIN_DISTANCE, locationListener);
    }

    /** {@inheritDoc} */
    @Override
    public void onDestroy() {
        if (locationManager != null)
            locationManager.removeUpdates(locationListener);

        filmDAO.close();
        personDAO.close();
        super.onDestroy();
    }

    /** {@inheritDoc} */
    @Override
    protected void onHandleIntent(Intent intent) {
        CharacterEndpoint endpoint;
        Call<Person> c;
        Response<Person> r;
        ReceiverHelper receiver;
        Location l;
        String url;
        Person p;
        Long id;

        endpoint = RetrofitHelper.getServiceStarWars(CharacterEndpoint.class);
        receiver = ReceiverHelper.prepare(this, Character.ACTION);

        try {
            if (ActivityCompat.checkSelfPermission(this, ACCESS_FINE_LOCATION) != PERMISSION_GRANTED &&
                    ActivityCompat.checkSelfPermission(this, ACCESS_COARSE_LOCATION) != PERMISSION_GRANTED) {
                return;
            }
            url = intent.getStringExtra(Character.KEY_URL);
            id = SQLiteHelper.recoveryId(url);
            c = endpoint.get(id);
            r = c.execute();
            if (r.isSuccessful()) {
                PlanetEndpoint planetEndpoint;
                Call<Planet> cp;
                Response<Planet> rp;

                p = r.body();
                p.setId(id);
                location = location == null ? locationManager.getLastKnownLocation(provider) : location;
                p.setLatitude(location.getLatitude());
                p.setLongitude(location.getLongitude());
                p.setCapturedInMillis(System.currentTimeMillis());

                planetEndpoint = RetrofitHelper.getServiceStarWars(PlanetEndpoint.class);
                id = SQLiteHelper.recoveryId(p.getHomeworld());
                cp = planetEndpoint.get(id);
                rp = cp.execute();

                if (rp.isSuccessful()) {
                    p.setHomeworld(rp.body().getName());
                }

                personDAO.save(p);
                Log.i("swapi", getString(R.string.saved, p));

                {
                    FilmEndpoint filmEndpoint;
                    Call<Film> cf;
                    Response<Film> rf;
                    Film f;

                    filmDAO.delete(Film._ID_PERSON, p.getId());
                    filmEndpoint = RetrofitHelper.getServiceStarWars(FilmEndpoint.class);
                    for (String i : p.getFilms()) {
                        id = SQLiteHelper.recoveryId(i);
                        cf = filmEndpoint.get(id);
                        rf = cf.execute();

                        if (rf.isSuccessful()) {
                            f = rf.body();
                            f.setIdFilm(id);
                            f.setIdPerson(p.getId());
                            filmDAO.save(f);
                            Log.d("swapi", getString(R.string.saved, f));
                        }
                    }
                }

                receiver.putExtra(Character.FOUND, Boolean.TRUE);
                receiver.putExtra(Character.KEY_MODEL, p);
            } else switch (r.code()) {
                case 404:
                    receiver.putExtra(Character.FOUND, Boolean.FALSE);
                    break;
                default:
                    Log.d("swapi", "Problemas com cod: " + r.code());
                    break;
            }
        } catch (Exception cause) {
            Log.e("swapi", cause.getMessage(), cause);
            receiver.putExtra(Controllers.EXCEPTION, cause);
        } finally {
            receiver.sendBroadcast();
        }
    }
}

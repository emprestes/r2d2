package tradeforce.starwars.r2d2.controller;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import org.androidannotations.annotations.EIntentService;

import retrofit2.Call;
import retrofit2.Response;
import tradeforce.starwars.domain.model.Film;
import tradeforce.starwars.domain.model.Person;
import tradeforce.starwars.domain.model.Planet;
import tradeforce.starwars.r2d2.R;
import tradeforce.starwars.r2d2.repository.sqlite.SQLiteHelper;
import tradeforce.starwars.r2d2.util.ReceiverHelper;
import tradeforce.starwars.r2d2.util.RetrofitHelper;
import tradeforce.starwars.r2d2.ws.CharacterEndpoint;
import tradeforce.starwars.r2d2.ws.FilmEndpoint;
import tradeforce.starwars.r2d2.ws.PlanetEndpoint;

import static tradeforce.starwars.r2d2.controller.Controllers.Character;

@EIntentService
public class SaveCharacterService extends IntentService {

    private SQLiteHelper.WritableDAO<Person> personDAO;
    private SQLiteHelper.WritableDAO<Film> filmDAO;

    public SaveCharacterService() {
        super(SaveCharacterService.class.getSimpleName());
    }

    @Override
    public void onCreate() {
        super.onCreate();

        personDAO = SQLiteHelper.getDAOWritable(this, Person.class);
        filmDAO = SQLiteHelper.getDAOWritable(this, Film.class);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        CharacterEndpoint endpoint;
        Call<Person> c;
        Response<Person> r;
        ReceiverHelper receiver;
        String url;
        Person p;
        Long id;

        receiver = ReceiverHelper.prepare(this, Character.ACTION);

        try {
            endpoint = RetrofitHelper.getServiceStarWars(CharacterEndpoint.class);
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

                    filmEndpoint = RetrofitHelper.getServiceStarWars(FilmEndpoint.class);
                    for (String i : p.getFilms()) {
                        id = SQLiteHelper.recoveryId(i);
                        cf = filmEndpoint.get(id);
                        rf = cf.execute();

                        if (rf.isSuccessful()) {
                            f = rf.body();
                            f.setId(id);
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

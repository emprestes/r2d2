package tradeforce.starwars.r2d2.controller;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.samples.vision.barcodereader.BarcodeCaptureActivity;
import com.google.android.gms.vision.barcode.Barcode;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.Receiver;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.Collections;

import tradeforce.starwars.domain.model.Film;
import tradeforce.starwars.domain.model.Person;
import tradeforce.starwars.r2d2.R;
import tradeforce.starwars.r2d2.app.AppCompatActivity;
import tradeforce.starwars.r2d2.repository.sqlite.SQLiteHelper;
import tradeforce.starwars.r2d2.view.FilmAdapter;

import static tradeforce.starwars.r2d2.controller.Controllers.BarcodeCapture;
import static tradeforce.starwars.r2d2.controller.Controllers.Character;

@EActivity(R.layout.activity_character)
@OptionsMenu(R.menu.character)
public class CharacterActivity extends AppCompatActivity {

    @ViewById
    View characterView;

    @ViewById
    ImageView characterImage;

    @ViewById
    TextView height, mass, hair, skin, eyes, planet, birthYear, gender, url;

    @ViewById
    View filmsView;

    @ViewById
    ListView list;

    private ProgressDialog loading;

    @AfterViews
    void init() {
        Intent i = getIntent();
        int code = i.getIntExtra(Character.KEY_CODE, 0);

        switch (code) {
            case BarcodeCapture.REQUEST_CODE:
                qrcode();
                break;
            case Character.REQUEST_CODE:
                set(i);
                break;
        }
    }

    @OptionsItem
    void qrcode() {
        MediaPlayer.create(this, R.raw.r2d2_yeah).start();
        startActivityForResult(BarcodeCapture.ACTION, Character.REQUEST_CODE);
    }

    @OptionsItem
    void list() {
        MediaPlayer.create(this, R.raw.r2d2_do).start();
        startActivity(Character.List.ACTION);
        finish();
    }

    @Receiver(actions = Character.ACTION, registerAt = Receiver.RegisterAt.OnResumeOnPause)
    void onReceive(Intent i) {
        try {
            checkException(i);
            set(i);
        } catch (Exception cause) {
            Log.e("character", cause.getMessage(), cause);
        } finally {
            loading.cancel();
        }
    }

    private void set(Intent i) {
        SQLiteHelper.ReadableDAO<Film> filmDAO;
        final Person p;

        Boolean found = i.getBooleanExtra(Character.FOUND, Boolean.FALSE);
        if (found) {
            p = (Person) i.getSerializableExtra(Character.KEY_MODEL);
            if (p != null) {
                filmDAO = SQLiteHelper.getDAOReadable(this, Film.class);
                try {
                    setTitle(p.getName());
                    height.setText(p.getHeight());
                    mass.setText(p.getMass());
                    hair.setText(p.getHair_color());
                    skin.setText(p.getSkin_color());
                    eyes.setText(p.getEye_color());
                    planet.setText(p.getHomeworld());
                    birthYear.setText(p.getBirth_year());
                    gender.setText(p.getGender());
                    url.setText(p.getUrl());
                    characterView.setVisibility(View.VISIBLE);

                    ArrayList<Film> films = new ArrayList<>();
                    films.addAll(filmDAO.findById(Film._ID_PERSON, p.getId()));
                    Collections.sort(films);

                    list.setAdapter(new FilmAdapter(this, R.layout.film, films));
                    filmsView.setVisibility(View.VISIBLE);
                } finally {
                    filmDAO.close();
                }
            }
        } else {
            characterView.setVisibility(View.INVISIBLE);
            filmsView.setVisibility(View.INVISIBLE);
            showMessageShort(R.string.character_not_found);
            qrcode();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case Character.REQUEST_CODE:
                if (resultCode == CommonStatusCodes.SUCCESS) {
                    if (data != null) {
                        loading = ProgressDialog.show(this,
                                getString(R.string.app_name),
                                getString(R.string.loading),
                                Boolean.TRUE);
                        Barcode barcode = data.getParcelableExtra(BarcodeCaptureActivity.BarcodeObject);
                        Log.i("barcode", barcode.displayValue);

                        Bundle extras = new Bundle();
                        extras.putString(Character.KEY_URL, barcode.displayValue);
                        startService(Character.Save.ACTION, extras);
                    } else finish();
                } else {
                    showMessageShort(R.string.ops);
                    finish();
                    Log.e("barcode", CommonStatusCodes.getStatusCodeString(resultCode));
                }
                break;
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}

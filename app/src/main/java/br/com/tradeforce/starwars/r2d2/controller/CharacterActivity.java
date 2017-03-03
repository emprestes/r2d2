package br.com.tradeforce.starwars.r2d2.controller;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.samples.vision.barcodereader.BarcodeCaptureActivity;
import com.google.android.gms.vision.barcode.Barcode;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.Receiver;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

import br.com.tradeforce.starwars.r2d2.R;
import br.com.tradeforce.starwars.r2d2.repository.sqlite.SQLiteHelper;
import br.com.tradeforce.starwars.r2d2.support.v7.app.AppCompatActivity;
import tradeforce.starwars.domain.model.Film;
import tradeforce.starwars.domain.model.Person;

import static br.com.tradeforce.starwars.r2d2.controller.Controllers.BarcodeCapture;
import static br.com.tradeforce.starwars.r2d2.controller.Controllers.Character;
import static br.com.tradeforce.starwars.r2d2.controller.Controllers.R2D2;

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

    private SQLiteHelper.ReadableDAO<Film> filmDAO;

    @AfterInject
    void init() {
        filmDAO = SQLiteHelper.getDAOReadable(this, Film.class);
        Intent i = getIntent();
        int code = i.getIntExtra(Character.KEY_CODE, 0);

        switch (code) {
            case R2D2.REQUEST_CODE:
                qrcode();
                break;
        }
    }

    @OptionsItem
    void qrcode() {
        startActivityForResult(BarcodeCapture.ACTION, Character.REQUEST_CODE);
    }

    @Receiver(actions = Character.ACTION, registerAt = Receiver.RegisterAt.OnResumeOnPause)
    void onReceive(Intent i) {
        try {
            checkException(i);

            final Person p = (Person) i.getSerializableExtra(Character.KEY_MODEL);
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

            list.setAdapter(new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_activated_1,
                    films));
            filmsView.setVisibility(View.VISIBLE);
        } catch (Exception cause) {
            Log.e("character", cause.getMessage(), cause);
        } finally {
            loading.cancel();
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
                    Toast.makeText(this, R.string.ops, Toast.LENGTH_SHORT).show();
                    finish();
                    Log.e("barcode", CommonStatusCodes.getStatusCodeString(resultCode));
                }
                break;
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}

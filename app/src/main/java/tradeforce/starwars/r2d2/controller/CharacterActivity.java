package tradeforce.starwars.r2d2.controller;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.Receiver;
import org.androidannotations.annotations.ViewById;

import java.text.SimpleDateFormat;
import java.util.Date;

import tradeforce.starwars.domain.model.Person;
import tradeforce.starwars.r2d2.R;
import tradeforce.starwars.r2d2.app.AppCompatActivity;

import static tradeforce.starwars.r2d2.controller.Controllers.BarcodeCapture;
import static tradeforce.starwars.r2d2.controller.Controllers.Character;

/**
 * Classe de controller para a tela de personagem.
 *
 * @author Prestes, E. M.
 * @since Março de 2017
 *
 * @see AppCompatActivity
 * @see EActivity
 * @see OptionsMenu
 */
@EActivity(R.layout.activity_character)
@OptionsMenu(R.menu.character)
public class CharacterActivity extends AppCompatActivity {

    @ViewById
    View characterView;

    @ViewById
    ImageView characterImage;

    @ViewById
    TextView height, mass, hair, skin, eyes, planet, birthYear, gender, captured, url;

    @ViewById(android.R.id.tabhost)
    FragmentTabHost tabhost;

    @ViewById(android.R.id.list)
    ListView list;

    private ProgressDialog loading;

    private String origin;

    private SimpleDateFormat sdf;

    /**
     * Inicializa componentes visuais da tela.
     */
    @AfterViews
    void init() {
         sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", getResources().getConfiguration().locale);
        Intent i = getIntent();
        int requestCode = i.getIntExtra(Character.KEY_CODE, 0);

        switch (requestCode) {
            case BarcodeCapture.REQUEST_CODE:
                qrcode();
                break;
            case Character.REQUEST_CODE:
                set(i);
                break;
        }

        origin = i.getStringExtra(Controllers.ORIGIN);
        origin = origin == null ? "" : origin;
    }

    /**
     * Acessa captura de QRCode.
     */
    @OptionsItem
    void qrcode() {
        MediaPlayer.create(this, R.raw.r2d2_yeah).start();
        Bundle options = new Bundle();
        options.putBoolean(BarcodeCapture.AUTO_FOCUS, Boolean.TRUE);
        options.putBoolean(BarcodeCapture.USE_FLASH, Boolean.TRUE);
        startActivityForResult(BarcodeCapture.ACTION, Character.REQUEST_CODE, options);
    }

    /**
     * Acessa lista de personagens.
     */
    @OptionsItem
    void list() {
        MediaPlayer.create(this, R.raw.r2d2_do).start();

        switch (origin) {
            case Character.List.ACTION:
                break;
            default:
                startActivity(Character.List.ACTION);
                break;
        }

        finish();
    }

    /**
     * Recebe dados salvos no serviço de gravação de personagem.
     *
     * @param i Intent informado.
     */
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

    /**
     * Configura os dados do personagem na tela.
     *
     * @param i Intent informado.
     */
    private void set(Intent i) {
        final Person p;

        Boolean found = i.getBooleanExtra(Character.FOUND, Boolean.FALSE);
        if (found) {
            p = (Person) i.getSerializableExtra(Character.KEY_MODEL);
            if (p != null) {
                setTitle(p.getName());
                height.setText(p.getHeight());
                mass.setText(p.getMass());
                hair.setText(p.getHair_color());
                skin.setText(p.getSkin_color());
                eyes.setText(p.getEye_color());
                planet.setText(p.getHomeworld());
                birthYear.setText(p.getBirth_year());
                gender.setText(p.getGender());
                captured.setText(sdf.format(new Date(p.getCapturedInMillis())));
                url.setText(p.getUrl());
                characterView.setVisibility(View.VISIBLE);

                configTabs(i);
            }
        } else {
            characterView.setVisibility(View.INVISIBLE);
            tabhost.setVisibility(View.INVISIBLE);
            showMessageShort(R.string.character_not_found);
            qrcode();
        }
    }

    /**
     * Configura o tabhost.
     *
     * @param i Intent informado.
     */
    private void configTabs(Intent i) {
        Bundle options = i.getExtras();
        tabhost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
        tabhost.clearAllTabs();
        tabhost.addTab(tabhost.newTabSpec("films")
                .setIndicator(getString(R.string.films)), FilmsListFragment_.class, options);
        tabhost.addTab(tabhost.newTabSpec("location")
                .setIndicator(getString(R.string.my_location)), LocationMapFragment.class, options);
        tabhost.setVisibility(View.VISIBLE);
    }

    /** {@inheritDoc} */
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
                        Barcode barcode = data.getParcelableExtra(BarcodeCapture.OBJECT);
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
    }
}

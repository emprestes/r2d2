package tradeforce.starwars.r2d2.controller;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ListView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import tradeforce.starwars.domain.model.Person;
import tradeforce.starwars.r2d2.R;
import tradeforce.starwars.r2d2.app.AppCompatActivity;
import tradeforce.starwars.r2d2.controller.Controllers.BarcodeCapture;
import tradeforce.starwars.r2d2.controller.Controllers.Character;
import tradeforce.starwars.r2d2.repository.sqlite.SQLiteHelper;
import tradeforce.starwars.r2d2.view.PersonAdapter;

/**
 * Classe de controller para a tela de lista de personagens.
 *
 * @author Prestes, E. M.
 * @since Março de 2017
 *
 * @see AppCompatActivity
 * @see EActivity
 * @see OptionsMenu
 */
@EActivity(android.R.layout.list_content)
@OptionsMenu(R.menu.qrcode)
public class CharacterListActivity extends AppCompatActivity {

    @ViewById(android.R.id.list)
    ListView list;

    private MediaPlayer mp;

    private int requestCode;

    /**
     * Inicializa componentes visuais da tela.
     */
    @AfterViews
    void init() {
        list.setOnItemClickListener((parent, view, position, id) -> {
            MediaPlayer.create(CharacterListActivity.this, R.raw.r2d2_yeah).start();
            Bundle options = new Bundle();

            requestCode = Character.REQUEST_CODE;
            options.putInt(Character.KEY_CODE, requestCode);
            options.putBoolean(Character.FOUND, Boolean.TRUE);
            options.putString(Controllers.ORIGIN, Character.List.ACTION);
            options.putSerializable(Character.KEY_MODEL, (Serializable) view.getTag());

            startActivity(Character.ACTION, options);
        });
    }

    /**
     * Carrega lista de personagens.
     */
    void load() {
        SQLiteHelper.ReadableDAO<Person> personDAO;

        if (mp == null) {
            mp = MediaPlayer.create(this, R.raw.sw_cantina);
            mp.setLooping(Boolean.TRUE);
        }
        if (!mp.isPlaying()) {
            mp.start();
        }

        personDAO = SQLiteHelper.getDAOReadable(this, Person.class);
        try {
            List<Person> people = new ArrayList<>();
            people.addAll(personDAO.findAll());
            if (people.isEmpty()) {
                qrcode();
            } else {
                Collections.sort(people);
                list.setAdapter(new PersonAdapter(this, R.layout.person, people));
            }
        } finally {
            personDAO.close();
        }
    }

    /**
     * Acesso a captura de QRCode.
     */
    @OptionsItem
    void qrcode() {
        Bundle options = new Bundle();

        requestCode = BarcodeCapture.REQUEST_CODE;
        options.putInt(Character.KEY_CODE, requestCode);
        options.putString(Controllers.ORIGIN, Character.List.ACTION);
        startActivity(Character.ACTION, options);
    }

    /** {@inheritDoc} */
    @Override
    protected void onResume() {
        super.onResume();

        load();
    }

    /** {@inheritDoc} */
    @Override
    protected void onPause() {
        switch (requestCode) {
            case BarcodeCapture.REQUEST_CODE:
            case Character.REQUEST_CODE:
                break;
            default:
                mp.stop();
                mp = null;
                break;
        }

        requestCode = 0;
        super.onPause();
    }
}

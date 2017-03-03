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

@EActivity(android.R.layout.list_content)
@OptionsMenu(R.menu.qrcode)
public class CharacterListActivity extends AppCompatActivity {

    @ViewById(android.R.id.list)
    ListView list;

    private MediaPlayer mp;

    @AfterViews
    void init() {
        list.setOnItemClickListener((parent, view, position, id) -> {
            MediaPlayer.create(CharacterListActivity.this, R.raw.r2d2_yeah).start();
            Bundle options = new Bundle();

            options.putInt(Character.KEY_CODE, Character.REQUEST_CODE);
            options.putBoolean(Character.FOUND, Boolean.TRUE);
            options.putSerializable(Character.KEY_MODEL, (Serializable) view.getTag());

            startActivity(Character.ACTION, options);
        });
    }

    void load() {
        SQLiteHelper.ReadableDAO<Person> personDAO;

        mp = MediaPlayer.create(this, R.raw.sw_cantina);
        mp.setLooping(Boolean.TRUE);
        mp.start();

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

    @Override
    protected void onResume() {
        super.onResume();

        load();
    }

    @OptionsItem
    void qrcode() {
        MediaPlayer.create(this, R.raw.r2d2_yeah).start();
        Bundle options = new Bundle();

        options.putInt(Character.KEY_CODE, BarcodeCapture.REQUEST_CODE);
        startActivity(Character.ACTION, options);
    }

    @Override
    protected void onPause() {
        mp.stop();
        mp = null;
        super.onPause();
    }
}

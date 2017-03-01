package br.com.tradeforce.starwars.r2d2.controller;

import android.media.MediaPlayer;
import android.net.Uri;
import android.widget.Toast;
import android.widget.VideoView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Touch;
import org.androidannotations.annotations.ViewById;

import br.com.tradeforce.starwars.r2d2.R;
import br.com.tradeforce.starwars.r2d2.support.v7.app.AppCompatActivity;

@EActivity(R.layout.activity_credit)
public class CreditActivity extends AppCompatActivity {

    @ViewById
    VideoView ending;

    @AfterViews
    void init() {
        int id;

        Toast.makeText(this, R.string.thanks, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, R.string.enjoy, Toast.LENGTH_SHORT).show();

        id = (int) (1 + Math.random() * 8);
        id = id == 1 ? R.raw.sw_ending_1 : id;
        id = id == 2 ? R.raw.sw_ending_2 : id;
        id = id == 3 ? R.raw.sw_ending_3 : id;
        id = id == 4 ? R.raw.sw_ending_4 : id;
        id = id == 5 ? R.raw.sw_ending_5 : id;
        id = id == 6 ? R.raw.sw_ending_6 : id;
        id = id == 7 || id == 8 ? R.raw.sw_ending_7 : id;

        ending.setOnCompletionListener(mp -> {
            if (!mp.isPlaying()) {
                finish();
            }
        });
        ending.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + id));
        ending.start();
    }

    @Touch
    void ending() {
        Toast.makeText(this, R.string.exit_press_back, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public void finish() {
        int id;
        MediaPlayer mp;

        super.finish();

        id = (int) (1 + Math.random() * 11);
        id = id == 1 ? R.raw.ending_01 : id;
        id = id == 2 ? R.raw.ending_02 : id;
        id = id == 3 ? R.raw.ending_03 : id;
        id = id == 4 ? R.raw.ending_04 : id;
        id = id == 5 ? R.raw.ending_05 : id;
        id = id == 6 ? R.raw.ending_06 : id;
        id = id == 7 ? R.raw.ending_07 : id;
        id = id == 8 ? R.raw.ending_08 : id;
        id = id == 9 ? R.raw.ending_09 : id;
        id = id == 10 ? R.raw.ending_10 : id;
        id = id == 11 ? R.raw.ending_11 : id;

        mp = MediaPlayer.create(this, id);
        mp.setOnCompletionListener(mpr -> {
            if (!mpr.isPlaying()) {
                Toast.makeText(this, R.string.byebye, Toast.LENGTH_SHORT).show();
            }
        });
        mp.start();

        setVisible(Boolean.TRUE);
    }
}
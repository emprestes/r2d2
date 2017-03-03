package tradeforce.starwars.r2d2.controller;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.VideoView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Touch;
import org.androidannotations.annotations.ViewById;

import tradeforce.starwars.r2d2.R;
import tradeforce.starwars.r2d2.app.AppCompatActivity;

@EActivity(R.layout.activity_credit)
public class CreditActivity extends AppCompatActivity {

    @ViewById
    ImageView image;

    @ViewById
    VideoView video;

    @AfterViews
    void init() {
        MediaPlayer.create(this, R.raw.bb8_001).start();
        showMessageShort(R.string.thanks);
        showMessageShort(R.string.enjoy);

        Handler h = new Handler();

        h.postDelayed(() -> {
            image.setVisibility(View.INVISIBLE);
            video.setVisibility(View.VISIBLE);
            int id = (int) (1 + Math.random() * 8);
            id = id == 1 ? R.raw.sw_ending_1 : id;
            id = id == 2 ? R.raw.sw_ending_2 : id;
            id = id == 3 ? R.raw.sw_ending_3 : id;
            id = id == 4 ? R.raw.sw_ending_4 : id;
            id = id == 5 ? R.raw.sw_ending_5 : id;
            id = id == 6 ? R.raw.sw_ending_6 : id;
            id = id == 7 || id == 8 ? R.raw.sw_ending_7 : id;
            video.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + id));
            video.setOnCompletionListener(mp -> {
                if (!mp.isPlaying()) {
                    finish();
                }
            });
            video.start();
        }, 5000L);
    }

    @Touch
    void video() {
        MediaPlayer.create(this, R.raw.bb8_002).start();
        showMessageShort(R.string.exit_press_back);
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
                showMessageShort(R.string.byebye);
            }
        });
        mp.start();

        setVisible(Boolean.TRUE);
    }
}

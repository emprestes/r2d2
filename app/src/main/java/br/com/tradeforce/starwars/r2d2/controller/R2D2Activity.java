package br.com.tradeforce.starwars.r2d2.controller;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import br.com.tradeforce.starwars.r2d2.R;
import br.com.tradeforce.starwars.r2d2.view.animation.AnimationAdapter;

@EActivity(R.layout.activity_r2d2)
public class R2D2Activity extends AppCompatActivity {

    @ViewById
    ImageView r2d2;

    @ViewById
    FloatingActionButton qrcode;

    @ViewById
    FloatingActionButton list;

    @AfterViews
    void init() {
        click();
    }

    @Click(R.id.r2d2)
    void click() {
        r2d2.setVisibility(View.INVISIBLE);
        Handler h = new Handler();
        MediaPlayer mp = MediaPlayer.create(this, R.raw.r2d2_screams);
        mp.start();

        h.postDelayed(() -> {
            r2d2.setVisibility(View.VISIBLE);
            int x1 = 600, x2 = -600, y1 = 0, y2 = -50;
            AnimationSet as = new AnimationSet(false);
            TranslateAnimation a = new TranslateAnimation(x1, x2, y1, y2);
            a.setDuration(700L);
            as.addAnimation(a);
            a = new TranslateAnimation(x2, 360, y2, 550);
            a.setDuration(3000L);
            as.addAnimation(a);
            as.setAnimationListener(new AnimationAdapter() {
                @Override
                public void onAnimationEnd(Animation animation) {
                    qrcode.setVisibility(View.VISIBLE);
                    list.setVisibility(View.VISIBLE);
                }
            });
            as.setFillAfter(true);

            r2d2.startAnimation(as);
        }, 2750);
    }
}

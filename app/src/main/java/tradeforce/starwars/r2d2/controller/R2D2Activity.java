package tradeforce.starwars.r2d2.controller;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.view.Display;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.SystemService;
import org.androidannotations.annotations.ViewById;

import tradeforce.starwars.r2d2.R;
import tradeforce.starwars.r2d2.app.AppCompatActivity;
import tradeforce.starwars.r2d2.view.animation.AnimationAdapter;

import static tradeforce.starwars.r2d2.controller.Controllers.BarcodeCapture;
import static tradeforce.starwars.r2d2.controller.Controllers.Character;

/**
 * Classe de controller para a tela do R2D2.
 *
 * @author Prestes, E. M.
 * @since Março de 2017
 *
 * @see AppCompatActivity
 * @see EActivity
 * @see OptionsMenu
 */
@EActivity(R.layout.activity_r2d2)
@OptionsMenu(R.menu.r2d2)
public class R2D2Activity extends AppCompatActivity {

    static MediaPlayer mp;
    @ViewById
    ImageView r2d2;
    @ViewById
    FloatingActionButton qrcode;
    @ViewById
    FloatingActionButton list;
    @SystemService
    WindowManager wm;

    /**
     * Inicializa componentes visuais.
     */
    @AfterViews
    void init() {
        Display d = wm.getDefaultDisplay();

        switch (d.getRotation()) {
            case Surface.ROTATION_90:
            case Surface.ROTATION_270:
                if (mp == null) {
                    mp = MediaPlayer.create(this, R.raw.star_wars_jedi);
                    mp.setLooping(true);
                }
                mp.start();
                break;
            case Surface.ROTATION_0:
            case Surface.ROTATION_180:
                stopSound();
                click();
                break;
        }
    }

    /**
     * Animação de R2D2 entrando em cena.
     */
    @Click(R.id.r2d2)
    void click() {
        r2d2.clearAnimation();
        qrcode.setVisibility(View.INVISIBLE);
        list.setVisibility(View.INVISIBLE);

        Handler h = new Handler();

        MediaPlayer.create(this, R.raw.r2d2_screams).start();

        h.postDelayed(() -> {
            int x1 = 600, x2 = -600, y1 = 0, y2 = -50;
            AnimationSet as = new AnimationSet(false);
            TranslateAnimation a = new TranslateAnimation(x1, x2, y1, y2);
            a.setDuration(450L);
            as.addAnimation(a);
            a = new TranslateAnimation(x2, 360, y2, 550);
            a.setDuration(1000L);
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
        }, 2950);
    }

    /**
     * Acessa captura por QRCode.
     */
    @Click
    @OptionsItem
    void qrcode() {
        MediaPlayer.create(this, R.raw.r2d2_yeah).start();
        Bundle options = new Bundle();

        options.putInt(Character.KEY_CODE, BarcodeCapture.REQUEST_CODE);
        startActivity(Character.ACTION, options);
    }

    /**
     * Acessa lista de personagens
     */
    @Click
    @OptionsItem
    void list() {
        MediaPlayer.create(this, R.raw.r2d2_do).start();
        startActivity(Character.List.ACTION);
    }

    /**
     * Reproduz voz de R2D2 quando toque na tela em retrato.
     */
    @Click(R.id.r2d2_hey)
    void sayR2D2() {
        MediaPlayer.create(this, R.raw.r2d2_hey_you).start();
    }

    /**
     * Reproduz voz de personagem quando toque na tela em paisagem.
     */
    @Click(R.id.poster)
    void say() {
        int id = (int) (1 + Math.random() * 4);
        id = id == 1 ? R.raw.ending_08 : id;
        id = id == 2 ? R.raw.ending_07 : id;
        id = id == 3 ? R.raw.ending_11 : id;
        id = id == 4 ? R.raw.ending_02 : id;
        MediaPlayer.create(this, id).start();
    }

    /** {@inheritDoc} */
    @Override
    public void onBackPressed() {
        stopSound();
        startActivity(Controllers.Credit.ACTION);
        finish();
    }

    /** {@inheritDoc} */
    @Override
    protected void onPause() {
        stopSound();
        super.onPause();
    }

    /**
     * Para o som quando tocando.
     */
    private void stopSound() {
        if (mp != null && mp.isPlaying()) {
            mp.stop();
            mp = null;
        }
    }
}

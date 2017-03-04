package tradeforce.starwars.r2d2.controller;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.VideoView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Touch;
import org.androidannotations.annotations.ViewById;

import tradeforce.starwars.r2d2.R;
import tradeforce.starwars.r2d2.app.AppCompatActivity;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
@EActivity(R.layout.activity_splash)
public class SplashActivity extends AppCompatActivity {
    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
    private static final boolean AUTO_HIDE = true;

    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    /**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
    private static final int UI_ANIMATION_DELAY = 400;
    private final Handler mHideHandler = new Handler();
    @ViewById(R.id.fullscreen_content)
    VideoView mContentView;
    private final Runnable mHidePart2Runnable = () -> {
        // Delayed removal of status and navigation bar

        // Note that some of these constants are new as of API 16 (Jelly Bean)
        // and API 19 (KitKat). It is safe to use them, as they are inlined
        // at compile-time and do nothing on earlier devices.
        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    };
    @ViewById(R.id.fullscreen_content_controls)
    View mControlsView;
    private final Runnable mShowPart2Runnable = () -> {
        // Delayed display of UI elements
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.show();
        }
        mControlsView.setVisibility(View.VISIBLE);
    };
    private boolean mVisible, isClicked;
    private final Runnable mHideRunnable = this::hide;

    @AfterViews
    void init() {
        mVisible = true;

        setTitle(R.string.r2d2_label);

        mContentView.setOnCompletionListener(mp -> {
            if (!isClicked && !mp.isPlaying()) {
                startActivity(Controllers.R2D2.ACTION);
            }
        });

        initIntro();
    }

    @Click(R.id.enter)
    void button() {
        if (AUTO_HIDE) {
            delayedHide(AUTO_HIDE_DELAY_MILLIS);
        }

        isClicked = true;
        startActivity(Controllers.R2D2.ACTION);
    }

    @Touch(R.id.fullscreen_content)
    void toggle() {
        if (mVisible) {
            hide();
        } else {
            show();
        }
    }

    private void initIntro() {
        int id;

        id = (int) (1 + Math.random() * 8);
        id = id == 1 ? R.raw.sw_intro_1 : id;
        id = id == 2 ? R.raw.sw_intro_2 : id;
        id = id == 3 ? R.raw.sw_intro_3 : id;
        id = id == 4 ? R.raw.sw_intro_4 : id;
        id = id == 5 ? R.raw.sw_intro_5 : id;
        id = id == 6 ? R.raw.sw_intro_6 : id;
        id = id == 7 ? R.raw.sw_intro_71 : id;
        id = id == 8 ? R.raw.sw_intro_72 : id;

        mContentView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + id));
        mContentView.start();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
        delayedHide(300);
    }

    private void hide() {
        // Hide UI first
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        mControlsView.setVisibility(View.GONE);
        mVisible = false;

        // Schedule a runnable to remove the status and navigation bar after a delay
        mHideHandler.removeCallbacks(mShowPart2Runnable);
        mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);
    }

    @SuppressLint("InlinedApi")
    private void show() {
        // Show the system bar
        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        mVisible = true;

        // Schedule a runnable to display UI elements after a delay
        mHideHandler.removeCallbacks(mHidePart2Runnable);
        mHideHandler.postDelayed(mShowPart2Runnable, UI_ANIMATION_DELAY);
    }

    /**
     * Schedules a call to hide() in [delay] milliseconds, canceling any
     * previously scheduled calls.
     */
    private void delayedHide(int delayMillis) {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, delayMillis);
    }

    @Override
    public void onBackPressed() {
        mContentView.pause();
        MediaPlayer mp = MediaPlayer.create(this, R.raw.fail);
        mp.setOnCompletionListener(p -> {
            mContentView.stopPlayback();
            startActivity(Controllers.R2D2.ACTION);
            finish();
        });
        mp.start();
    }
}

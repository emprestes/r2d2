package br.com.tradeforce.starwars.r2d2.support.v7.app;

import android.content.Intent;

public abstract class AppCompatActivity extends android.support.v7.app.AppCompatActivity {

    protected void startActivity(String action) {
        startActivity(new Intent(action));
    }

    protected void startActivityForResult(String action, int requestCode) {
        Intent intent = new Intent(action);
        startActivityForResult(intent, requestCode);
    }
}

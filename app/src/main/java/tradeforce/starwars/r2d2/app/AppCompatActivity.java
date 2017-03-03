package tradeforce.starwars.r2d2.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import tradeforce.starwars.r2d2.controller.Controllers;

public abstract class AppCompatActivity extends android.support.v7.app.AppCompatActivity {

    protected void startActivity(String action) {
        startActivity(new Intent(action));
    }

    protected void startActivity(String action, Bundle options) {
        Intent i = new Intent(action);
        i.putExtras(options);
        startActivity(i);
    }

    protected void startActivityForResult(String action, int requestCode) {
        Intent intent = new Intent(action);
        startActivityForResult(intent, requestCode);
    }

    protected void startService(String action, Bundle options) {
        Intent i = new Intent(action);
        i.setPackage(getPackageName());
        i.putExtras(options);
        startService(i);
    }

    protected void checkException(Intent i) throws Exception {
        Exception cause = (Exception) i.getSerializableExtra(Controllers.EXCEPTION);
        if (cause != null) {
            throw cause;
        }
    }

    protected void showMessageShort(int id) {
        Toast.makeText(this, id, Toast.LENGTH_SHORT).show();
    }
}

package br.com.tradeforce.starwars.r2d2.controller;

import android.content.Intent;
import android.util.Log;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.samples.vision.barcodereader.BarcodeCaptureActivity;
import com.google.android.gms.vision.barcode.Barcode;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EActivity;

import br.com.tradeforce.starwars.r2d2.R;
import br.com.tradeforce.starwars.r2d2.support.v7.app.AppCompatActivity;

import static br.com.tradeforce.starwars.r2d2.controller.Controllers.BarcodeCapture;
import static br.com.tradeforce.starwars.r2d2.controller.Controllers.QRCode;
import static br.com.tradeforce.starwars.r2d2.controller.Controllers.R2D2;

@EActivity(R.layout.activity_character)
public class CharacterActivity extends AppCompatActivity {

    @AfterInject
    void init() {
        Intent i = getIntent();
        int code = i.getIntExtra(QRCode.KEY_CODE, 0);

        switch (code) {
            case R2D2.REQUEST_CODE:
                startActivityForResult(BarcodeCapture.ACTION, QRCode.REQUEST_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case QRCode.REQUEST_CODE:
                if (resultCode == CommonStatusCodes.SUCCESS) {
                    if (data != null) {
                        Barcode barcode = data.getParcelableExtra(BarcodeCaptureActivity.BarcodeObject);
                        Log.i("barcode", barcode.displayValue);
                    } else finish();
                } else Log.e("barcode", CommonStatusCodes.getStatusCodeString(resultCode));
                break;
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}

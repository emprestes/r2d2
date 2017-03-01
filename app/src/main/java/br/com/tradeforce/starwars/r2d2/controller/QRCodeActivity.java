package br.com.tradeforce.starwars.r2d2.controller;

import android.content.Intent;
import android.util.Log;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EActivity;

import br.com.tradeforce.starwars.r2d2.support.v7.app.AppCompatActivity;
import br.com.tradeforce.starwars.r2d2.vision.barcodereader.BarcodeCaptureActivity;

@EActivity
public class QRCodeActivity extends AppCompatActivity {

    private static final int BARCODE_READER_REQUEST_CODE = 100;

    @AfterInject
    void init() {
        startActivityForResult(Controllers.BarcodeCapture.ACTION, BARCODE_READER_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == BARCODE_READER_REQUEST_CODE) {
            if (resultCode == CommonStatusCodes.SUCCESS) {
                if (data != null) {
                    Barcode barcode = data.getParcelableExtra(BarcodeCaptureActivity.BarcodeObject);
                    Log.i("barcode", barcode.displayValue);
                } else Log.i("barcode", "falha");
            } else Log.e("barcode", CommonStatusCodes.getStatusCodeString(resultCode));
        } else super.onActivityResult(requestCode, resultCode, data);
    }
}

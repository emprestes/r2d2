package br.com.tradeforce.starwars.r2d2.controller;

interface Controllers {

    interface R2D2 {
        String ACTION = "starwars.intent.action.R2D2";
        String KEY_CODE = "key.request.code.R2D2";
        int REQUEST_CODE = 200;
    }

    interface Credit {
        String ACTION = "starwars.intent.action.CREDIT";
    }

    interface QRCode {
        String ACTION = "starwars.intent.action.QRCODE";
        String KEY_CODE = "key.request.code.QRCODE";
        int REQUEST_CODE = 300;
    }

    interface BarcodeCapture {
        String ACTION = "vision.intent.action.BARCODE";
    }
}

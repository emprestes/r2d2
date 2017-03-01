package br.com.tradeforce.starwars.r2d2.controller;

interface Controllers {

    interface R2D2 {
        String ACTION = "starwars.intent.action.R2D2";
    }

    interface Credit {
        String ACTION = "starwars.intent.action.CREDIT";
    }

    interface QRCode {
        String ACTION = "starwars.intent.action.QRCODE";
    }

    interface BarcodeCapture {
        String ACTION = "vision.intent.action.BARCODE";
    }
}

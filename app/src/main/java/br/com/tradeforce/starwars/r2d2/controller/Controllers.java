package br.com.tradeforce.starwars.r2d2.controller;

public interface Controllers {
    String EXCEPTION = "exception.CONTROLLERS";

    interface Character {
        String ACTION = "starwars.intent.action.CHARACTER";
        String KEY_CODE = "key.request.code.CHARACTER";
        String KEY_MODEL = "key.model.CHARACTER";
        String KEY_URL = "key.url.CHARACTER";
        int REQUEST_CODE = 300;

        interface Save {
            String ACTION = "starwars.intent.action.SAVE_CHARACTER";
        }
    }

    interface R2D2 {
        String ACTION = "starwars.intent.action.R2D2";
        String KEY_CODE = "key.request.code.R2D2";
        int REQUEST_CODE = 200;
    }

    interface Credit {
        String ACTION = "starwars.intent.action.CREDIT";
    }

    interface BarcodeCapture {
        String ACTION = "vision.intent.action.BARCODE";
    }
}

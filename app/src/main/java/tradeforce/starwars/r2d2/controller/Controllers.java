package tradeforce.starwars.r2d2.controller;

public interface Controllers {
    String EXCEPTION = "exception.CONTROLLERS";
    String ORIGIN = "origin.CONTROLLERS";

    interface Character {
        String ACTION = "starwars.intent.action.CHARACTER";
        String KEY_CODE = "key.request.code.CHARACTER";
        String KEY_MODEL = "key.model.CHARACTER";
        String KEY_URL = "key.url.CHARACTER";
        String FOUND = "found.CHARACTER";
        int REQUEST_CODE = 300;

        interface List {
            String ACTION = "starwars.intent.action.LIST_CHARACTER";
            int REQUEST_CODE = 400;
        }

        interface Save {
            String ACTION = "starwars.intent.action.SAVE_CHARACTER";
        }
    }

    interface R2D2 {
        String ACTION = "starwars.intent.action.R2D2";
        String KEY_CODE = "key.request.code.R2D2";
    }

    interface Credit {
        String ACTION = "starwars.intent.action.CREDIT";
    }

    interface BarcodeCapture {
        String ACTION = "vision.intent.action.BARCODE";
        int REQUEST_CODE = 200;
        String AUTO_FOCUS = "AutoFocus";
        String USE_FLASH = "UseFlash";
        String OBJECT = "Barcode";
    }

    interface Films {
        String ACTION = "starwars.intent.action.FILMS";
        int REQUEST_CODE = 500;
    }

    interface Maps {
        String ACTION = "starwars.intent.action.MAPS";
        int REQUEST_CODE = 500;
    }
}

package tradeforce.starwars.r2d2.controller;

/**
 * Interface com todas as contantes usadas em controllers.
 *
 * @author Prestes, E. M.
 * @since Março de 2017
 */
public interface Controllers {
    String EXCEPTION = "exception.CONTROLLERS";
    String ORIGIN = "origin.CONTROLLERS";

    /**
     * Constantes usadas na tela de personagens
     */
    interface Character {
        String ACTION = "starwars.intent.action.CHARACTER";
        String KEY_CODE = "key.request.code.CHARACTER";
        String KEY_MODEL = "key.model.CHARACTER";
        String KEY_URL = "key.url.CHARACTER";
        String FOUND = "found.CHARACTER";
        int REQUEST_CODE = 300;

        /**
         * Constantes usadas para lista de personagens
         */
        interface List {
            String ACTION = "starwars.intent.action.LIST_CHARACTER";
            int REQUEST_CODE = 400;
        }

        /**
         * Constantes usadas para salvar personagens
         */
        interface Save {
            String ACTION = "starwars.intent.action.SAVE_CHARACTER";
        }
    }

    /**
     * Constantes usadas na tela de R2D2
     */
    interface R2D2 {
        String ACTION = "starwars.intent.action.R2D2";
        String KEY_CODE = "key.request.code.R2D2";
    }

    /**
     * Constantes usadas na tela de créditos.
     */
    interface Credit {
        String ACTION = "starwars.intent.action.CREDIT";
    }

    /**
     * Constantes usadas na tela de Barecode
     */
    interface BarcodeCapture {
        String ACTION = "vision.intent.action.BARCODE";
        int REQUEST_CODE = 200;
        String AUTO_FOCUS = "AutoFocus";
        String USE_FLASH = "UseFlash";
        String OBJECT = "Barcode";
    }
}

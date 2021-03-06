package tradeforce.starwars.r2d2.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import tradeforce.starwars.r2d2.util.function.Consumer;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;

/**
 * Helper para verificar o uso de permissão de recursos do Android.
 *
 * @author Prestes, E. M.
 * @since Março de 2017
 *
 */
public final class PermissionHelper {

    /**
     * Verifica um conjunto de permissões. Caso de permissões ok, dispara uma ação pré-definida.
     *
     * @param a Atividade informada.
     * @param requestCode Código da requisição informado.
     * @param action Ação pré-definida informada.
     * @param permissions Permissões informadas.
     */
    public static void check(Activity a, int requestCode, Consumer<Context> action, String... permissions) {
        boolean isGranted = true;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int count = 0;
            for (String p : permissions) {
                if (isGranted = ContextCompat.checkSelfPermission(a, p) != PERMISSION_GRANTED) {
                    count++;
                }
            }

            if (count > 0) {
                ActivityCompat.requestPermissions(a, permissions, requestCode);
            }

            isGranted = !isGranted;
        }

        if (isGranted) {
            action.accept(a);
        }
    }
}

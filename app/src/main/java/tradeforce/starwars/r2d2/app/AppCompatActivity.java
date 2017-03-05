package tradeforce.starwars.r2d2.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsMenu;

import tradeforce.starwars.r2d2.controller.Controllers;

/**
 * Classe abstrata para otimizar uso por controllers.
 *
 * @author Prestes, E. M.
 * @since Março de 2017
 *
 * @see android.support.v7.app.AppCompatActivity
 */
public abstract class AppCompatActivity extends android.support.v7.app.AppCompatActivity {

    /**
     * Inicia uma atividade por ação informada.
     *
     * @param action Ação informada.
     */
    protected void startActivity(String action) {
        startActivity(new Intent(action));
    }

    /**
     * Inicia uma atividade por ação e opções informadas.
     *
     * @param action Ação informada.
     * @param options Opções informadas.
     */
    protected void startActivity(String action, Bundle options) {
        Intent i = new Intent(action);
        i.putExtras(options);
        startActivity(i);
    }

    /**
     * Inicia uma atividade com aguardo por resultados.
     *
     * @param action Ação informada.
     * @param requestCode Código de requisição informado.
     * @param options Opções informados.
     */
    protected void startActivityForResult(String action, int requestCode, Bundle options) {
        Intent intent = new Intent(action);
        startActivityForResult(intent, requestCode, options);
    }

    /**
     * Inicia um serviço por ação e opções informadas.
     *
     * @param action Ação informada.
     * @param options Opções informadas.
     */
    protected void startService(String action, Bundle options) {
        Intent i = new Intent(action);
        i.setPackage(getPackageName());
        i.putExtras(options);
        startService(i);
    }

    /**
     * Verifica a ocorrência de problemas na Intent informada.
     *
     * @param i Intent informada.
     * @throws Exception Problema lançado em caso de existir algum.
     */
    protected void checkException(Intent i) throws Exception {
        Exception cause = (Exception) i.getSerializableExtra(Controllers.EXCEPTION);
        if (cause != null) {
            throw cause;
        }
    }

    /**
     * Exibe um Toast curto com mensagem personalizada por id informado.
     *
     * @param id ID informado.
     */
    protected void showMessageShort(int id) {
        Toast.makeText(this, id, Toast.LENGTH_SHORT).show();
    }

    /**
     * Exibe um Toast curto com mensagem personalizada por id e argumentos informados.
     *
     * @param id ID informado.
     * @param args Argumentos informados.
     */
    protected void showMessageShort(int id, Object... args) {
        Toast.makeText(this, getString(id, args), Toast.LENGTH_SHORT).show();
    }
}

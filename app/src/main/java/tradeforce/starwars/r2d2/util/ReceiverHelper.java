package tradeforce.starwars.r2d2.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.io.Serializable;

/**
 * Helper para manipular receivers.
 *
 * @author Prestes, E. M.
 * @since Março de 2017
 *
 */
public final class ReceiverHelper {

    private Intent i;

    private Context c;

    private ReceiverHelper(Context c) {
        super();

        this.c = c;
    }

    private ReceiverHelper(Context c, String action) {
        this(c);

        this.i = new Intent(action);
    }

    /**
     * Prepara o helper para um novo receiver.
     *
     * @param context Contexto Android informado.
     * @param action Ação a ser chamada.
     * @return Helper
     */
    public static ReceiverHelper prepare(Context context, String action) {
        return new ReceiverHelper(context, action);
    }

    /**
     * Coloca a informação a ser enviada pelo receiver.
     *
     * @param key Chave informada.
     * @param value Valor informado.
     * @return Helper
     */
    public ReceiverHelper putExtra(String key, Serializable value) {
        i.putExtra(key, value);
        return this;
    }

    /**
     * Envia um broadcastReceiver.
     */
    public void sendBroadcast() {
        c.sendBroadcast(i);
    }
}

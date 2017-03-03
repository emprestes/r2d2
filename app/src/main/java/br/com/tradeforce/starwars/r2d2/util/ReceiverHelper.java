package br.com.tradeforce.starwars.r2d2.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.io.Serializable;

public final class ReceiverHelper {

    private Intent i;

    private Context c;

    private ReceiverHelper(Context c) {
        super();

        this.c = c;
    }

    private ReceiverHelper(Context c, Class<? extends BroadcastReceiver> _class) {
        this(c);

        this.i = new Intent(this.c, _class);
    }

    private ReceiverHelper(Context c, String action) {
        this(c);

        this.i = new Intent(action);
    }

    public static ReceiverHelper prepare(Context context, String action) {
        return new ReceiverHelper(context, action);
    }

    public static ReceiverHelper prepare(Context context, Class<? extends BroadcastReceiver> _class) {
        return new ReceiverHelper(context, _class);
    }

    public ReceiverHelper putExtra(String key, Object tag) {
        putExtra(key, (Serializable) tag);
        return this;
    }

    public ReceiverHelper putExtra(String key, boolean value) {
        i.putExtra(key, value);
        return this;
    }

    public ReceiverHelper putExtra(String key, Bundle value) {
        i.putExtra(key, value);
        return this;
    }

    public ReceiverHelper putExtra(String key, String value) {
        i.putExtra(key, value);
        return this;
    }

    public ReceiverHelper putExtra(String key, Serializable value) {
        i.putExtra(key, value);
        return this;
    }

    public void sendBroadcast() {
        c.sendBroadcast(i);
    }
}

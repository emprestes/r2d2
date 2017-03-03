package br.com.tradeforce.starwars.r2d2.util;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class RetrofitHelper {

    private static Retrofit SW;

    private RetrofitHelper() {
        super();
    }

    public static <T> T getServiceStarWars(Class<T> service) {
        if (SW == null) {
            SW = new Retrofit.Builder()
                    .baseUrl("http://swapi.co/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return SW.create(service);
    }
}

package tradeforce.starwars.r2d2.util;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Helper para uso do Retrofit em comunicação com serviços web.
 */
public final class RetrofitHelper {

    /** Singleton */
    private static Retrofit SW;

    private RetrofitHelper() {
        super();
    }

    /**
     * Recupera o serviço web de Star Wars.
     *
     * @param service Interface do serviço web.
     * @param <T> Tipo da interface.
     * @return Serviço Web criado pelo Retrofit.
     */
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

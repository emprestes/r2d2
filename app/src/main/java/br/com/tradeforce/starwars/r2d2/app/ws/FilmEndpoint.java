package br.com.tradeforce.starwars.r2d2.app.ws;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import tradeforce.starwars.domain.model.Film;

public interface FilmEndpoint {

    @GET("/films/{id}/")
    Call<Film> get(@Path("id") Integer id);
}

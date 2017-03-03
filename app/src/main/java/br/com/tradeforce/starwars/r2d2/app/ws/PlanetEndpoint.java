package br.com.tradeforce.starwars.r2d2.app.ws;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import tradeforce.starwars.domain.model.Planet;

public interface PlanetEndpoint {

    @GET("planets/{id}/?format=json")
    Call<Planet> get(@Path("id") Long id);
}

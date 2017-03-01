package br.com.tradeforce.starwars.r2d2.app.ws;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import tradeforce.starwars.domain.model.Vehicle;

public interface VehicleEndpoint {

    @GET("/vehicles/{id}/")
    Call<Vehicle> get(@Path("id") Integer id);
}

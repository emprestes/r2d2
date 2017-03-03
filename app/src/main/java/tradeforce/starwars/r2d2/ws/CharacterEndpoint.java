package tradeforce.starwars.r2d2.ws;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import tradeforce.starwars.domain.model.Person;

public interface CharacterEndpoint {

    @GET("people/{id}/?format=json")
    Call<Person> get(@Path("id") Long id);
}

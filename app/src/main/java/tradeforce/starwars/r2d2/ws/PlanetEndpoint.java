package tradeforce.starwars.r2d2.ws;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import tradeforce.starwars.domain.model.Planet;

/**
 * Interface endpoint para comunicação com serviço web de planetas do Star Wars.
 *
 * @author Prestes, E. M.
 * @since Março de 2017
 *
 * @see Call
 * @see GET
 * @see Path
 */
public interface PlanetEndpoint {

    /**
     * Recupera um planeta pelo ID informado.
     *
     * @param id ID informado
     * @return Call de planeta
     */
    @GET("planets/{id}/?format=json")
    Call<Planet> get(@Path("id") Long id);
}

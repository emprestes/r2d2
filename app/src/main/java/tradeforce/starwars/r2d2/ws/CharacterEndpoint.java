package tradeforce.starwars.r2d2.ws;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import tradeforce.starwars.domain.model.Person;

/**
 * Interface endpoint para comunicação com serviço web de personagens do Star Wars.
 *
 * @author Prestes, E. M.
 * @since Março de 2017
 *
 * @see Call
 * @see GET
 * @see Path
 */
public interface CharacterEndpoint {

    /**
     * Recupera um personagem pelo ID informado.
     *
     * @param id ID informado
     * @return Call de personagem
     */
    @GET("people/{id}/?format=json")
    Call<Person> get(@Path("id") Long id);
}

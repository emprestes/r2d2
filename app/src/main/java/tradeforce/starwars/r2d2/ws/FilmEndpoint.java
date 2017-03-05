package tradeforce.starwars.r2d2.ws;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import tradeforce.starwars.domain.model.Film;

/**
 * Interface endpoint para comunicação com serviço web de filmes do Star Wars.
 *
 * @author Prestes, E. M.
 * @since Março de 2017
 *
 * @see Call
 * @see GET
 * @see Path
 */
public interface FilmEndpoint {

    /**
     * Recupera um filme pelo ID informado.
     *
     * @param id ID informado
     * @return Call de filme
     */
    @GET("films/{id}/?format=json")
    Call<Film> get(@Path("id") Long id);
}

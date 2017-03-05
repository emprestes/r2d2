package tradeforce.starwars.domain.model;

import java.io.Serializable;

import junitx.extensions.SerializabilityTestCase;

/**
 * Classe para teste unitário de serialização de filme.
 *
 * @author Prestes, E. M.
 * @since Março de 2017
 *
 * @see SerializabilityTestCase
 * @see Serializable
 * @see Exception
 * @see Film
 */
public class FilmSerializabilityTest extends SerializabilityTestCase {

    /**
     * Construtor informando um nome.
     *
     * @param name Nome informado.
     */
    public FilmSerializabilityTest(String name) {
        super(name);
    }

    /** {@inheritDoc} */
    @Override
    protected Serializable createInstance() throws Exception {
        return new Film()
                .setTitle("film01")
                .setCreated("film01")
                .setDirector("film01")
                .setEdited("film01")
                .setEpisode_id("1")
                .setOpening_crawl("film01")
                .setProducer("film01")
                .setRelease_date("film01")
                .setUrl("film01");
    }
}

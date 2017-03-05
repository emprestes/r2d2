package tradeforce.starwars.domain.model;

import junitx.extensions.EqualsHashCodeTestCase;

/**
 * Classe para teste unitário de igualdade e identidade de filmes.
 *
 * @author Prestes, E. M.
 * @since Março de 2017
 *
 * @see EqualsHashCodeTestCase
 * @see Exception
 * @see Film
 */
public class FilmEqualsHashCodeTest extends EqualsHashCodeTestCase {

    /**
     * Construtor informando um nome.
     *
     * @param name Nome informado.
     */
    public FilmEqualsHashCodeTest(String name) {
        super(name);
    }

    /** {@inheritDoc} */
    @Override
    protected Object createInstance() throws Exception {
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

    /** {@inheritDoc} */
    @Override
    protected Object createNotEqualInstance() throws Exception {
        return new Film()
                .setTitle("film02")
                .setCreated("film02")
                .setDirector("film02")
                .setEdited("film02")
                .setEpisode_id("2")
                .setOpening_crawl("film02")
                .setProducer("film02")
                .setRelease_date("film02")
                .setUrl("film02");
    }
}

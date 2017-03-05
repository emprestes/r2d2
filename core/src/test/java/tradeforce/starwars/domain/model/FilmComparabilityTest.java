package tradeforce.starwars.domain.model;

import junitx.extensions.ComparabilityTestCase;

/**
 * Classe para teste unitário de comparação de filmes.
 *
 * @author Prestes, E. M.
 * @since Março de 2017
 *
 * @see ComparabilityTestCase
 * @see Comparable
 * @see Exception
 * @see Film
 */
public class FilmComparabilityTest extends ComparabilityTestCase {

    /**
     * Construtor informando um nome.
     *
     * @param name Nome informado.
     */
    public FilmComparabilityTest(String name) {
        super(name);
    }

    /** {@inheritDoc} */
    @Override
    protected Comparable createLessInstance() throws Exception {
        return new Film()
                .setEpisode_id("1");
    }

    /** {@inheritDoc} */
    @Override
    protected Comparable createEqualInstance() throws Exception {
        return new Film()
                .setEpisode_id("2");
    }

    /** {@inheritDoc} */
    @Override
    protected Comparable createGreaterInstance() throws Exception {
        return new Film()
                .setEpisode_id("3");
    }
}

package tradeforce.starwars.domain.model;

import junitx.extensions.EqualsHashCodeTestCase;

/**
 * Classe para teste unitário de igualdade e identidade de planetas.
 *
 * @author Prestes, E. M.
 * @since Março de 2017
 *
 * @see EqualsHashCodeTestCase
 * @see Exception
 * @see Planet
 */
public class PlanetEqualsHashCodeTest extends EqualsHashCodeTestCase {

    /**
     * Construtor informando um nome.
     *
     * @param name Nome informado.
     */
    public PlanetEqualsHashCodeTest(String name) {
        super(name);
    }

    /** {@inheritDoc} */
    @Override
    protected Object createInstance() throws Exception {
        return new Planet()
                .setName("planet1");
    }

    /** {@inheritDoc} */
    @Override
    protected Object createNotEqualInstance() throws Exception {
        return new Planet()
                .setName("planet2");
    }
}

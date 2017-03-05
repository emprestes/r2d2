package tradeforce.starwars.domain.model;

import java.io.Serializable;

import junitx.extensions.SerializabilityTestCase;

/**
 * Classe para teste unitário de serialização de planeta.
 *
 * @author Prestes, E. M.
 * @since Março de 2017
 *
 * @see SerializabilityTestCase
 * @see Serializable
 * @see Exception
 * @see Planet
 */
public class PlanetSerializabilityTest extends SerializabilityTestCase {

    /**
     * Construtor informando um nome.
     *
     * @param name Nome informado.
     */
    public PlanetSerializabilityTest(String name) {
        super(name);
    }

    /** {@inheritDoc} */
    @Override
    protected Serializable createInstance() throws Exception {
        return new Planet()
                .setName("planet1");
    }
}

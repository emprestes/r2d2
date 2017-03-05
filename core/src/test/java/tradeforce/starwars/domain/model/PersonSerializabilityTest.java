package tradeforce.starwars.domain.model;

import java.io.Serializable;

import junitx.extensions.SerializabilityTestCase;

/**
 * Classe para teste unitário de serialização de personagem.
 *
 * @author Prestes, E. M.
 * @since Março de 2017
 *
 * @see SerializabilityTestCase
 * @see Serializable
 * @see Exception
 * @see Person
 */
public class PersonSerializabilityTest extends SerializabilityTestCase {

    /**
     * Construtor informando um nome.
     *
     * @param name Nome informado.
     */
    public PersonSerializabilityTest(String name) {
        super(name);
    }

    /** {@inheritDoc} */
    @Override
    protected Serializable createInstance() throws Exception {
        return new Person()
                .setName("person1")
                .setEdited("person1")
                .setBirth_year("person1")
                .setCreated("person1")
                .setEye_color("person1")
                .setGender("person1")
                .setHair_color("person1")
                .setHeight("1")
                .setHomeworld("person1")
                .setMass("1")
                .setSkin_color("person1")
                .setUrl("person1");
    }
}

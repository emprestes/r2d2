package tradeforce.starwars.domain.model;

import junitx.extensions.EqualsHashCodeTestCase;

/**
 * Classe para teste unitário de igualdade e identidade de personagens.
 *
 * @author Prestes, E. M.
 * @since Março de 2017
 *
 * @see EqualsHashCodeTestCase
 * @see Exception
 * @see Person
 */
public class PersonEqualsHashCodeTest extends EqualsHashCodeTestCase {

    /**
     * Construtor informando um nome.
     *
     * @param name Nome informado.
     */
    public PersonEqualsHashCodeTest(String name) {
        super(name);
    }

    /** {@inheritDoc} */
    @Override
    protected Object createInstance() throws Exception {
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

    /** {@inheritDoc} */
    @Override
    protected Object createNotEqualInstance() throws Exception {
        return new Person()
                .setName("person2")
                .setEdited("person2")
                .setBirth_year("person2")
                .setCreated("person2")
                .setEye_color("person2")
                .setGender("person2")
                .setHair_color("person2")
                .setHeight("2")
                .setHomeworld("person2")
                .setMass("2")
                .setSkin_color("person2")
                .setUrl("person2");
    }
}

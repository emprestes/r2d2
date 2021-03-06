package tradeforce.starwars.domain.model;

import junitx.extensions.ComparabilityTestCase;

/**
 * Classe para teste unitário de comparação de personagens.
 *
 * @author Prestes, E. M.
 * @since Março de 2017
 *
 * @see ComparabilityTestCase
 * @see Comparable
 * @see Exception
 * @see Person
 */
public class PersonComparabilityTest extends ComparabilityTestCase {

    /**
     * Construtor informando um nome.
     *
     * @param name Nome informado.
     */
    public PersonComparabilityTest(String name) {
        super(name);
    }

    /** {@inheritDoc} */
    @Override
    protected Comparable createLessInstance() throws Exception {
        return new Person()
                .setName("person1");
    }

    /** {@inheritDoc} */
    @Override
    protected Comparable createEqualInstance() throws Exception {
        return new Person()
                .setName("person2");
    }

    /** {@inheritDoc} */
    @Override
    protected Comparable createGreaterInstance() throws Exception {
        return new Person()
                .setName("person3");
    }
}

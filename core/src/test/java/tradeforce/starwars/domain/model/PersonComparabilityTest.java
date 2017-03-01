package tradeforce.starwars.domain.model;

import junitx.extensions.ComparabilityTestCase;

public class PersonComparabilityTest extends ComparabilityTestCase {

    public PersonComparabilityTest(String name) {
        super(name);
    }

    @Override
    protected Comparable createLessInstance() throws Exception {
        return new Person()
                .setUrl("person1");
    }

    @Override
    protected Comparable createEqualInstance() throws Exception {
        return new Person()
                .setUrl("person2");
    }

    @Override
    protected Comparable createGreaterInstance() throws Exception {
        return new Person()
                .setUrl("person3");
    }
}
package tradeforce.starwars.domain.model;

import junitx.extensions.ComparabilityTestCase;

public class PlanetComparabilityTest extends ComparabilityTestCase {

    public PlanetComparabilityTest(String name) {
        super(name);
    }

    @Override
    protected Comparable createLessInstance() throws Exception {
        return new Planet()
                .setUrl("planet1");
    }

    @Override
    protected Comparable createEqualInstance() throws Exception {
        return new Planet()
                .setUrl("planet2");
    }

    @Override
    protected Comparable createGreaterInstance() throws Exception {
        return new Planet()
                .setUrl("planet3");
    }
}

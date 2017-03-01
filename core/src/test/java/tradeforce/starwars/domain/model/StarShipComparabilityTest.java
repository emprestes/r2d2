package tradeforce.starwars.domain.model;

import junitx.extensions.ComparabilityTestCase;

public class StarShipComparabilityTest extends ComparabilityTestCase {

    public StarShipComparabilityTest(String name) {
        super(name);
    }

    @Override
    protected Comparable createLessInstance() throws Exception {
        return new StarShip()
                .setUrl("starShip1");
    }

    @Override
    protected Comparable createEqualInstance() throws Exception {
        return new StarShip()
                .setUrl("starShip2");
    }

    @Override
    protected Comparable createGreaterInstance() throws Exception {
        return new StarShip()
                .setUrl("starShip3");
    }
}

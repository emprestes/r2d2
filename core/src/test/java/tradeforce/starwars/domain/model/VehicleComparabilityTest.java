package tradeforce.starwars.domain.model;

import junitx.extensions.ComparabilityTestCase;

public class VehicleComparabilityTest extends ComparabilityTestCase {

    public VehicleComparabilityTest(String name) {
        super(name);
    }

    @Override
    protected Comparable createLessInstance() throws Exception {
        return new Vehicle()
                .setUrl("vehicle1");
    }

    @Override
    protected Comparable createEqualInstance() throws Exception {
        return new Vehicle()
                .setUrl("vehicle2");
    }

    @Override
    protected Comparable createGreaterInstance() throws Exception {
        return new Vehicle()
                .setUrl("vehicle3");
    }
}

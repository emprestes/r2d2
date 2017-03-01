package tradeforce.starwars.domain.model;

import junitx.extensions.ComparabilityTestCase;

public class SpeciesComparabilityTest extends ComparabilityTestCase {

    public SpeciesComparabilityTest(String name) {
        super(name);
    }

    @Override
    protected Comparable createLessInstance() throws Exception {
        return new Species()
                .setUrl("Species1");
    }

    @Override
    protected Comparable createEqualInstance() throws Exception {
        return new Species()
                .setUrl("Species2");
    }

    @Override
    protected Comparable createGreaterInstance() throws Exception {
        return new Species()
                .setUrl("Species3");
    }

}

package tradeforce.starwars.domain.model;

import junitx.extensions.EqualsHashCodeTestCase;

public class PlanetEqualsHashCodeTest extends EqualsHashCodeTestCase {

    public PlanetEqualsHashCodeTest(String name) {
        super(name);
    }

    @Override
    protected Object createInstance() throws Exception {
        return new Planet()
                .setName("planet1");
    }

    @Override
    protected Object createNotEqualInstance() throws Exception {
        return new Planet()
                .setName("planet2");
    }
}

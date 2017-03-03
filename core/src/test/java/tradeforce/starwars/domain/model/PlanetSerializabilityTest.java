package tradeforce.starwars.domain.model;

import java.io.Serializable;

import junitx.extensions.SerializabilityTestCase;

public class PlanetSerializabilityTest extends SerializabilityTestCase {

    public PlanetSerializabilityTest(String name) {
        super(name);
    }

    @Override
    protected Serializable createInstance() throws Exception {
        return new Planet()
                .setName("planet1");
    }
}

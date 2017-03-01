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
                .setClimate("planet1")
                .setCreated("planet1")
                .setDiameter("planet1")
                .setEdited("planet1")
                .setGravity("planet1")
                .setName("planet1")
                .setOrbital_period("planet1")
                .setPopulation("planet1")
                .setRotation_period("planet1")
                .setSurface_water("planet1")
                .setTerrain("planet1")
                .setUrl("planet1");
    }
}

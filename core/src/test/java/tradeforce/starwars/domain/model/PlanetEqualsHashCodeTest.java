package tradeforce.starwars.domain.model;

import junitx.extensions.EqualsHashCodeTestCase;

public class PlanetEqualsHashCodeTest extends EqualsHashCodeTestCase {

    public PlanetEqualsHashCodeTest(String name) {
        super(name);
    }

    @Override
    protected Object createInstance() throws Exception {
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

    @Override
    protected Object createNotEqualInstance() throws Exception {
        return new Planet()
                .setClimate("planet2")
                .setCreated("planet2")
                .setDiameter("planet2")
                .setEdited("planet2")
                .setGravity("planet2")
                .setName("planet2")
                .setOrbital_period("planet2")
                .setPopulation("planet2")
                .setRotation_period("planet2")
                .setSurface_water("planet2")
                .setTerrain("planet2")
                .setUrl("planet2");
    }
}

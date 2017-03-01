package tradeforce.starwars.domain.model;

import java.io.Serializable;

import junitx.extensions.SerializabilityTestCase;

public class SpeciesSerializabilityTest extends SerializabilityTestCase {

    public SpeciesSerializabilityTest(String name) {
        super(name);
    }

    @Override
    protected Serializable createInstance() throws Exception {
        return new Species()
                .setName("species1")
                .setAverage_height(1)
                .setAverage_lifespan(1)
                .setClassification("species1")
                .setCreated("species1")
                .setDesignation("species1")
                .setEdited("species1")
                .setEye_colors("species1")
                .setHair_colors("species1")
                .setHomeworld("species1")
                .setLanguage("species1")
                .setSkin_colors("species1")
                .setUrl("species1");
    }
}

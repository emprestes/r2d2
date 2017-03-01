package tradeforce.starwars.domain.model;

import junitx.extensions.EqualsHashCodeTestCase;

public class SpeciesEqualsHashCodeTest extends EqualsHashCodeTestCase {

    public SpeciesEqualsHashCodeTest(String name) {
        super(name);
    }

    @Override
    protected Object createInstance() throws Exception {
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

    @Override
    protected Object createNotEqualInstance() throws Exception {
        return new Species()
                .setName("species2")
                .setAverage_height(2)
                .setAverage_lifespan(2)
                .setClassification("species2")
                .setCreated("species2")
                .setDesignation("species2")
                .setEdited("species2")
                .setEye_colors("species2")
                .setHair_colors("species2")
                .setHomeworld("species2")
                .setLanguage("species2")
                .setSkin_colors("species2")
                .setUrl("species2");
    }
}

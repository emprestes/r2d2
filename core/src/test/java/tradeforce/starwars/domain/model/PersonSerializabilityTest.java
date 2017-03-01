package tradeforce.starwars.domain.model;

import java.io.Serializable;

import junitx.extensions.SerializabilityTestCase;

public class PersonSerializabilityTest extends SerializabilityTestCase {

    public PersonSerializabilityTest(String name) {
        super(name);
    }

    @Override
    protected Serializable createInstance() throws Exception {
        return new Person()
                .setName("person1")
                .setEdited("person1")
                .setBirth_year("person1")
                .setCreated("person1")
                .setEye_color("person1")
                .setGender("person1")
                .setHair_color("person1")
                .setHeight(1)
                .setHomeworld("person1")
                .setMass(1)
                .setSkin_color("person1")
                .setUrl("person1");
    }
}

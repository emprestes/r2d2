package tradeforce.starwars.domain.model;

import java.io.Serializable;

import junitx.extensions.SerializabilityTestCase;

public class StarShipSerializabilityTest extends SerializabilityTestCase {

    public StarShipSerializabilityTest(String name) {
        super(name);
    }

    @Override
    protected Serializable createInstance() throws Exception {
        return new StarShip()
                .setName("starShip01")
                .setEdited("starShip01")
                .setCargo_capacity("starShip01")
                .setConsumables("starShip01")
                .setCost_in_credits("starShip01")
                .setCreated("starShip01")
                .setCrew(1)
                .setHyperdrive_rating("starShip01")
                .setLength("starShip01")
                .setManufacturer("starShip01")
                .setMax_atmosphering_speed("starShip01")
                .setMGLT("starShip01")
                .setModel("starShip01")
                .setPassengers("starShip01")
                .setStarship_class("starShip01")
                .setUrl("starShip01");
    }
}

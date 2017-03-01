package tradeforce.starwars.domain.model;

import junitx.extensions.EqualsHashCodeTestCase;

public class StarShipEqualsHashCodeTest extends EqualsHashCodeTestCase {

    public StarShipEqualsHashCodeTest(String name) {
        super(name);
    }

    @Override
    protected Object createInstance() throws Exception {
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

    @Override
    protected Object createNotEqualInstance() throws Exception {
        return new StarShip()
                .setName("starShip02")
                .setEdited("starShip02")
                .setCargo_capacity("starShip02")
                .setConsumables("starShip02")
                .setCost_in_credits("starShip02")
                .setCreated("starShip02")
                .setCrew(2)
                .setHyperdrive_rating("starShip02")
                .setLength("starShip02")
                .setManufacturer("starShip02")
                .setMax_atmosphering_speed("starShip02")
                .setMGLT("starShip02")
                .setModel("starShip02")
                .setPassengers("starShip02")
                .setStarship_class("starShip02")
                .setUrl("starShip02");
    }
}

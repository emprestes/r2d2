package tradeforce.starwars.domain.model;

import junitx.extensions.EqualsHashCodeTestCase;

public class VehicleEqualsHashCodeTest extends EqualsHashCodeTestCase {

    public VehicleEqualsHashCodeTest(String name) {
        super(name);
    }

    @Override
    protected Object createInstance() throws Exception {
        return new Vehicle()
                .setModel("vehicle1")
                .setManufacturer("vehicle1")
                .setCargo_capacity(1)
                .setConsumables("vehicle1")
                .setCost_in_credits("vehicle1")
                .setCreated("vehicle1")
                .setCrew(1)
                .setEdited("vehicle1")
                .setLength(1.0)
                .setMax_atmosphering_speed(1)
                .setName("vehicle1")
                .setPassengers(1)
                .setVehicle_class("vehicle1")
                .setUrl("vehicle1");
    }

    @Override
    protected Object createNotEqualInstance() throws Exception {
        return new Vehicle()
                .setModel("vehicle2")
                .setManufacturer("vehicle2")
                .setCargo_capacity(2)
                .setConsumables("vehicle2")
                .setCost_in_credits("vehicle2")
                .setCreated("vehicle2")
                .setCrew(2)
                .setEdited("vehicle2")
                .setLength(2.0)
                .setMax_atmosphering_speed(2)
                .setName("vehicle2")
                .setPassengers(2)
                .setVehicle_class("vehicle2")
                .setUrl("vehicle2");
    }
}

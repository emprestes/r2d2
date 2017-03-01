package tradeforce.starwars.domain.model;

import java.io.Serializable;

import junitx.extensions.SerializabilityTestCase;

public class VehicleSerializabilityTest extends SerializabilityTestCase {

    public VehicleSerializabilityTest(String name) {
        super(name);
    }

    @Override
    protected Serializable createInstance() throws Exception {
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
}

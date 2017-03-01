package tradeforce.domain.model;

import java.io.Serializable;
import java.util.List;

public class Vehicle implements Serializable {

    private String name;

    private String model;

    private String manufacturer;

    private String cost_in_credits;

    private Double length;

    private Integer max_atmosphering_speed;

    private Integer crew;

    private Integer passengers;

    private Integer cargo_capacity;

    private String consumables;

    private String vehicle_class;

    private List<Person> pilots;

    private List<Film> films;

    private String created;

    private String edited;

    private String url;
}

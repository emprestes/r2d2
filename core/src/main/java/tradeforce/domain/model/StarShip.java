package tradeforce.domain.model;

import java.io.Serializable;
import java.util.List;

public class StarShip implements Serializable {

    private String name;

    private String model;

    private String manufacturer;

    private String cost_in_credits;

    private String length;

    private String max_atmosphering_speed;

    private Integer crew;

    private String passengers;

    private String cargo_capacity;

    private String consumables;

    private String hyperdrive_rating;

    private String MGLT;

    private String starship_class;

    private List<Person> pilots;

    private List<Film> films;

    private String created;

    private String edited;

    private String url;
}

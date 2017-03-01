package tradeforce.domain.model;

import java.io.Serializable;
import java.util.List;

public class Film implements Serializable {

    private String title;

    private Integer episode_id;

    private String opening_crawl;

    private String director;

    private String producer;

    private String release_date;

    private List<Person> characters;

    private List<Planet> planets;

    private List<StarShip> starships;

    private List<Vehicle> vehicles;

    private List<Species> species;

    private String created;

    private String edited;

    private String url;
}

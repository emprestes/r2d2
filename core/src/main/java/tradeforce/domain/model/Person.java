package tradeforce.domain.model;

import java.io.Serializable;
import java.util.List;

public class Person implements Serializable {

    private String name;

    private Integer height;

    private Integer mass;

    private String hair_color;

    private String skin_color;

    private String eye_color;

    private String birth_year;

    private String gender;

    private String homeworld;

    private List<Film> films;

    private List<Species> species;

    private List<Vehicle> vehicles;

    private List<StarShip> starships;

    private String created;

    private String edited;

    private String url;
}

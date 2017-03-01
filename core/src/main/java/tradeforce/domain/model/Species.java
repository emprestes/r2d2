package tradeforce.domain.model;

import java.io.Serializable;
import java.util.List;

public class Species implements Serializable {

    private String name;

    private String classification;

    private String designation;

    private Integer average_height;

    private String skin_colors;

    private String hair_colors;

    private String eye_colors;

    private Integer average_lifespan;

    private String homeworld;

    private String language;

    private List<Person> people;

    private List<Film> films;

    private String created;

    private String edited;

    private String url;
}

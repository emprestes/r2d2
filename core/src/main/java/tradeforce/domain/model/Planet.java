package tradeforce.domain.model;

import java.io.Serializable;
import java.util.List;

public class Planet implements Serializable {

    private String name;

    private String rotation_period;

    private String orbital_period;

    private String diameter;

    private String climate;

    private String gravity;

    private String terrain;

    private String surface_water;

    private String population;

    private List<Person> residents;

    private List<Film> films;

    private String created;

    private String edited;

    private String url;
}

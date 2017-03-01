package tradeforce.starwars.domain.model;

import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.List;

import tradeforce.starwars.domain.Domain;

public class Person implements Domain<Person>, Serializable {

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

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getHeight() {
        return height;
    }

    public Person setHeight(Integer height) {
        this.height = height;
        return this;
    }

    public Integer getMass() {
        return mass;
    }

    public Person setMass(Integer mass) {
        this.mass = mass;
        return this;
    }

    public String getHair_color() {
        return hair_color;
    }

    public Person setHair_color(String hair_color) {
        this.hair_color = hair_color;
        return this;
    }

    public String getSkin_color() {
        return skin_color;
    }

    public Person setSkin_color(String skin_color) {
        this.skin_color = skin_color;
        return this;
    }

    public String getEye_color() {
        return eye_color;
    }

    public Person setEye_color(String eye_color) {
        this.eye_color = eye_color;
        return this;
    }

    public String getBirth_year() {
        return birth_year;
    }

    public Person setBirth_year(String birth_year) {
        this.birth_year = birth_year;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public Person setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public Person setHomeworld(String homeworld) {
        this.homeworld = homeworld;
        return this;
    }

    public List<Film> getFilms() {
        return films;
    }

    public Person setFilms(List<Film> films) {
        this.films = films;
        return this;
    }

    public List<Species> getSpecies() {
        return species;
    }

    public Person setSpecies(List<Species> species) {
        this.species = species;
        return this;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public Person setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
        return this;
    }

    public List<StarShip> getStarships() {
        return starships;
    }

    public Person setStarships(List<StarShip> starships) {
        this.starships = starships;
        return this;
    }

    public String getCreated() {
        return created;
    }

    public Person setCreated(String created) {
        this.created = created;
        return this;
    }

    public String getEdited() {
        return edited;
    }

    public Person setEdited(String edited) {
        this.edited = edited;
        return this;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public Person setUrl(String url) {
        this.url = url;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (getName() != null ? !getName().equals(person.getName()) : person.getName() != null)
            return false;
        if (getHeight() != null ? !getHeight().equals(person.getHeight()) : person.getHeight() != null)
            return false;
        if (getMass() != null ? !getMass().equals(person.getMass()) : person.getMass() != null)
            return false;
        if (getHair_color() != null ? !getHair_color().equals(person.getHair_color()) : person.getHair_color() != null)
            return false;
        if (getSkin_color() != null ? !getSkin_color().equals(person.getSkin_color()) : person.getSkin_color() != null)
            return false;
        if (getEye_color() != null ? !getEye_color().equals(person.getEye_color()) : person.getEye_color() != null)
            return false;
        if (getBirth_year() != null ? !getBirth_year().equals(person.getBirth_year()) : person.getBirth_year() != null)
            return false;
        if (getGender() != null ? !getGender().equals(person.getGender()) : person.getGender() != null)
            return false;
        if (getHomeworld() != null ? !getHomeworld().equals(person.getHomeworld()) : person.getHomeworld() != null)
            return false;
        if (getFilms() != null ? !getFilms().equals(person.getFilms()) : person.getFilms() != null)
            return false;
        if (getSpecies() != null ? !getSpecies().equals(person.getSpecies()) : person.getSpecies() != null)
            return false;
        if (getVehicles() != null ? !getVehicles().equals(person.getVehicles()) : person.getVehicles() != null)
            return false;
        if (getStarships() != null ? !getStarships().equals(person.getStarships()) : person.getStarships() != null)
            return false;
        if (getCreated() != null ? !getCreated().equals(person.getCreated()) : person.getCreated() != null)
            return false;
        if (getEdited() != null ? !getEdited().equals(person.getEdited()) : person.getEdited() != null)
            return false;
        return getUrl() != null ? getUrl().equals(person.getUrl()) : person.getUrl() == null;

    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getHeight() != null ? getHeight().hashCode() : 0);
        result = 31 * result + (getMass() != null ? getMass().hashCode() : 0);
        result = 31 * result + (getHair_color() != null ? getHair_color().hashCode() : 0);
        result = 31 * result + (getSkin_color() != null ? getSkin_color().hashCode() : 0);
        result = 31 * result + (getEye_color() != null ? getEye_color().hashCode() : 0);
        result = 31 * result + (getBirth_year() != null ? getBirth_year().hashCode() : 0);
        result = 31 * result + (getGender() != null ? getGender().hashCode() : 0);
        result = 31 * result + (getHomeworld() != null ? getHomeworld().hashCode() : 0);
        result = 31 * result + (getFilms() != null ? getFilms().hashCode() : 0);
        result = 31 * result + (getSpecies() != null ? getSpecies().hashCode() : 0);
        result = 31 * result + (getVehicles() != null ? getVehicles().hashCode() : 0);
        result = 31 * result + (getStarships() != null ? getStarships().hashCode() : 0);
        result = 31 * result + (getCreated() != null ? getCreated().hashCode() : 0);
        result = 31 * result + (getEdited() != null ? getEdited().hashCode() : 0);
        result = 31 * result + (getUrl() != null ? getUrl().hashCode() : 0);
        return result;
    }

    @Override
    protected void finalize() throws Throwable {
        name = null;
        height = null;
        mass = null;
        hair_color = null;
        skin_color = null;
        eye_color = null;
        birth_year = null;
        gender = null;
        homeworld = null;
        films = null;
        species = null;
        vehicles = null;
        starships = null;
        created = null;
        edited = null;
        url = null;

        super.finalize();
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("height", height)
                .add("mass", mass)
                .add("hair_color", hair_color)
                .add("skin_color", skin_color)
                .add("eye_color", eye_color)
                .add("birth_year", birth_year)
                .add("gender", gender)
                .add("homeworld", homeworld)
                .add("films", films)
                .add("species", species)
                .add("vehicles", vehicles)
                .add("starships", starships)
                .add("created", created)
                .add("edited", edited)
                .add("url", url)
                .toString();
    }
}

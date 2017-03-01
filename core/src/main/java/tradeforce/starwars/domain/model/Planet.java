package tradeforce.starwars.domain.model;

import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.List;

import tradeforce.starwars.domain.Domain;

public class Planet implements Domain<Planet>, Serializable {

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

    public String getName() {
        return name;
    }

    public Planet setName(String name) {
        this.name = name;
        return this;
    }

    public String getRotation_period() {
        return rotation_period;
    }

    public Planet setRotation_period(String rotation_period) {
        this.rotation_period = rotation_period;
        return this;
    }

    public String getOrbital_period() {
        return orbital_period;
    }

    public Planet setOrbital_period(String orbital_period) {
        this.orbital_period = orbital_period;
        return this;
    }

    public String getDiameter() {
        return diameter;
    }

    public Planet setDiameter(String diameter) {
        this.diameter = diameter;
        return this;
    }

    public String getClimate() {
        return climate;
    }

    public Planet setClimate(String climate) {
        this.climate = climate;
        return this;
    }

    public String getGravity() {
        return gravity;
    }

    public Planet setGravity(String gravity) {
        this.gravity = gravity;
        return this;
    }

    public String getTerrain() {
        return terrain;
    }

    public Planet setTerrain(String terrain) {
        this.terrain = terrain;
        return this;
    }

    public String getSurface_water() {
        return surface_water;
    }

    public Planet setSurface_water(String surface_water) {
        this.surface_water = surface_water;
        return this;
    }

    public String getPopulation() {
        return population;
    }

    public Planet setPopulation(String population) {
        this.population = population;
        return this;
    }

    public List<Person> getResidents() {
        return residents;
    }

    public Planet setResidents(List<Person> residents) {
        this.residents = residents;
        return this;
    }

    public List<Film> getFilms() {
        return films;
    }

    public Planet setFilms(List<Film> films) {
        this.films = films;
        return this;
    }

    public String getCreated() {
        return created;
    }

    public Planet setCreated(String created) {
        this.created = created;
        return this;
    }

    public String getEdited() {
        return edited;
    }

    public Planet setEdited(String edited) {
        this.edited = edited;
        return this;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public Planet setUrl(String url) {
        this.url = url;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Planet)) return false;

        Planet planet = (Planet) o;

        if (getName() != null ? !getName().equals(planet.getName()) : planet.getName() != null)
            return false;
        if (getRotation_period() != null ? !getRotation_period().equals(planet.getRotation_period()) : planet.getRotation_period() != null)
            return false;
        if (getOrbital_period() != null ? !getOrbital_period().equals(planet.getOrbital_period()) : planet.getOrbital_period() != null)
            return false;
        if (getDiameter() != null ? !getDiameter().equals(planet.getDiameter()) : planet.getDiameter() != null)
            return false;
        if (getClimate() != null ? !getClimate().equals(planet.getClimate()) : planet.getClimate() != null)
            return false;
        if (getGravity() != null ? !getGravity().equals(planet.getGravity()) : planet.getGravity() != null)
            return false;
        if (getTerrain() != null ? !getTerrain().equals(planet.getTerrain()) : planet.getTerrain() != null)
            return false;
        if (getSurface_water() != null ? !getSurface_water().equals(planet.getSurface_water()) : planet.getSurface_water() != null)
            return false;
        if (getPopulation() != null ? !getPopulation().equals(planet.getPopulation()) : planet.getPopulation() != null)
            return false;
        if (getResidents() != null ? !getResidents().equals(planet.getResidents()) : planet.getResidents() != null)
            return false;
        if (getFilms() != null ? !getFilms().equals(planet.getFilms()) : planet.getFilms() != null)
            return false;
        if (getCreated() != null ? !getCreated().equals(planet.getCreated()) : planet.getCreated() != null)
            return false;
        if (getEdited() != null ? !getEdited().equals(planet.getEdited()) : planet.getEdited() != null)
            return false;
        return getUrl() != null ? getUrl().equals(planet.getUrl()) : planet.getUrl() == null;

    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getRotation_period() != null ? getRotation_period().hashCode() : 0);
        result = 31 * result + (getOrbital_period() != null ? getOrbital_period().hashCode() : 0);
        result = 31 * result + (getDiameter() != null ? getDiameter().hashCode() : 0);
        result = 31 * result + (getClimate() != null ? getClimate().hashCode() : 0);
        result = 31 * result + (getGravity() != null ? getGravity().hashCode() : 0);
        result = 31 * result + (getTerrain() != null ? getTerrain().hashCode() : 0);
        result = 31 * result + (getSurface_water() != null ? getSurface_water().hashCode() : 0);
        result = 31 * result + (getPopulation() != null ? getPopulation().hashCode() : 0);
        result = 31 * result + (getResidents() != null ? getResidents().hashCode() : 0);
        result = 31 * result + (getFilms() != null ? getFilms().hashCode() : 0);
        result = 31 * result + (getCreated() != null ? getCreated().hashCode() : 0);
        result = 31 * result + (getEdited() != null ? getEdited().hashCode() : 0);
        result = 31 * result + (getUrl() != null ? getUrl().hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Planet o) {
        return getUrl().compareTo(o.getUrl());
    }

    @Override
    protected void finalize() throws Throwable {
        name = null;
        rotation_period = null;
        orbital_period = null;
        diameter = null;
        climate = null;
        gravity = null;
        terrain = null;
        surface_water = null;
        population = null;
        residents = null;
        films = null;
        created = null;
        edited = null;
        url = null;

        super.finalize();
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("rotation_period", rotation_period)
                .add("orbital_period", orbital_period)
                .add("diameter", diameter)
                .add("climate", climate)
                .add("gravity", gravity)
                .add("terrain", terrain)
                .add("surface_water", surface_water)
                .add("population", population)
                .add("residents", residents)
                .add("films", films)
                .add("created", created)
                .add("edited", edited)
                .add("url", url)
                .toString();
    }
}

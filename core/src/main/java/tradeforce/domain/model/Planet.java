package tradeforce.domain.model;

import com.google.common.base.MoreObjects;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRotation_period() {
        return rotation_period;
    }

    public void setRotation_period(String rotation_period) {
        this.rotation_period = rotation_period;
    }

    public String getOrbital_period() {
        return orbital_period;
    }

    public void setOrbital_period(String orbital_period) {
        this.orbital_period = orbital_period;
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getGravity() {
        return gravity;
    }

    public void setGravity(String gravity) {
        this.gravity = gravity;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public String getSurface_water() {
        return surface_water;
    }

    public void setSurface_water(String surface_water) {
        this.surface_water = surface_water;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public List<Person> getResidents() {
        return residents;
    }

    public void setResidents(List<Person> residents) {
        this.residents = residents;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getEdited() {
        return edited;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

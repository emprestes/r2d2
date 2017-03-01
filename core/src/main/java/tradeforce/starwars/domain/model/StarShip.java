package tradeforce.starwars.domain.model;

import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.List;

import tradeforce.starwars.domain.Domain;

public class StarShip implements Domain<StarShip>, Serializable {

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

    public String getName() {
        return name;
    }

    public StarShip setName(String name) {
        this.name = name;
        return this;
    }

    public String getModel() {
        return model;
    }

    public StarShip setModel(String model) {
        this.model = model;
        return this;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public StarShip setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public String getCost_in_credits() {
        return cost_in_credits;
    }

    public StarShip setCost_in_credits(String cost_in_credits) {
        this.cost_in_credits = cost_in_credits;
        return this;
    }

    public String getLength() {
        return length;
    }

    public StarShip setLength(String length) {
        this.length = length;
        return this;
    }

    public String getMax_atmosphering_speed() {
        return max_atmosphering_speed;
    }

    public StarShip setMax_atmosphering_speed(String max_atmosphering_speed) {
        this.max_atmosphering_speed = max_atmosphering_speed;
        return this;
    }

    public Integer getCrew() {
        return crew;
    }

    public StarShip setCrew(Integer crew) {
        this.crew = crew;
        return this;
    }

    public String getPassengers() {
        return passengers;
    }

    public StarShip setPassengers(String passengers) {
        this.passengers = passengers;
        return this;
    }

    public String getCargo_capacity() {
        return cargo_capacity;
    }

    public StarShip setCargo_capacity(String cargo_capacity) {
        this.cargo_capacity = cargo_capacity;
        return this;
    }

    public String getConsumables() {
        return consumables;
    }

    public StarShip setConsumables(String consumables) {
        this.consumables = consumables;
        return this;
    }

    public String getHyperdrive_rating() {
        return hyperdrive_rating;
    }

    public StarShip setHyperdrive_rating(String hyperdrive_rating) {
        this.hyperdrive_rating = hyperdrive_rating;
        return this;
    }

    public String getMGLT() {
        return MGLT;
    }

    public StarShip setMGLT(String MGLT) {
        this.MGLT = MGLT;
        return this;
    }

    public String getStarship_class() {
        return starship_class;
    }

    public StarShip setStarship_class(String starship_class) {
        this.starship_class = starship_class;
        return this;
    }

    public List<Person> getPilots() {
        return pilots;
    }

    public StarShip setPilots(List<Person> pilots) {
        this.pilots = pilots;
        return this;
    }

    public List<Film> getFilms() {
        return films;
    }

    public StarShip setFilms(List<Film> films) {
        this.films = films;
        return this;
    }

    public String getCreated() {
        return created;
    }

    public StarShip setCreated(String created) {
        this.created = created;
        return this;
    }

    public String getEdited() {
        return edited;
    }

    public StarShip setEdited(String edited) {
        this.edited = edited;
        return this;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public StarShip setUrl(String url) {
        this.url = url;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StarShip)) return false;

        StarShip starShip = (StarShip) o;

        if (getName() != null ? !getName().equals(starShip.getName()) : starShip.getName() != null)
            return false;
        if (getModel() != null ? !getModel().equals(starShip.getModel()) : starShip.getModel() != null)
            return false;
        if (getManufacturer() != null ? !getManufacturer().equals(starShip.getManufacturer()) : starShip.getManufacturer() != null)
            return false;
        if (getCost_in_credits() != null ? !getCost_in_credits().equals(starShip.getCost_in_credits()) : starShip.getCost_in_credits() != null)
            return false;
        if (getLength() != null ? !getLength().equals(starShip.getLength()) : starShip.getLength() != null)
            return false;
        if (getMax_atmosphering_speed() != null ? !getMax_atmosphering_speed().equals(starShip.getMax_atmosphering_speed()) : starShip.getMax_atmosphering_speed() != null)
            return false;
        if (getCrew() != null ? !getCrew().equals(starShip.getCrew()) : starShip.getCrew() != null)
            return false;
        if (getPassengers() != null ? !getPassengers().equals(starShip.getPassengers()) : starShip.getPassengers() != null)
            return false;
        if (getCargo_capacity() != null ? !getCargo_capacity().equals(starShip.getCargo_capacity()) : starShip.getCargo_capacity() != null)
            return false;
        if (getConsumables() != null ? !getConsumables().equals(starShip.getConsumables()) : starShip.getConsumables() != null)
            return false;
        if (getHyperdrive_rating() != null ? !getHyperdrive_rating().equals(starShip.getHyperdrive_rating()) : starShip.getHyperdrive_rating() != null)
            return false;
        if (getMGLT() != null ? !getMGLT().equals(starShip.getMGLT()) : starShip.getMGLT() != null)
            return false;
        if (getStarship_class() != null ? !getStarship_class().equals(starShip.getStarship_class()) : starShip.getStarship_class() != null)
            return false;
        if (getPilots() != null ? !getPilots().equals(starShip.getPilots()) : starShip.getPilots() != null)
            return false;
        if (getFilms() != null ? !getFilms().equals(starShip.getFilms()) : starShip.getFilms() != null)
            return false;
        if (getCreated() != null ? !getCreated().equals(starShip.getCreated()) : starShip.getCreated() != null)
            return false;
        if (getEdited() != null ? !getEdited().equals(starShip.getEdited()) : starShip.getEdited() != null)
            return false;
        return getUrl() != null ? getUrl().equals(starShip.getUrl()) : starShip.getUrl() == null;

    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getModel() != null ? getModel().hashCode() : 0);
        result = 31 * result + (getManufacturer() != null ? getManufacturer().hashCode() : 0);
        result = 31 * result + (getCost_in_credits() != null ? getCost_in_credits().hashCode() : 0);
        result = 31 * result + (getLength() != null ? getLength().hashCode() : 0);
        result = 31 * result + (getMax_atmosphering_speed() != null ? getMax_atmosphering_speed().hashCode() : 0);
        result = 31 * result + (getCrew() != null ? getCrew().hashCode() : 0);
        result = 31 * result + (getPassengers() != null ? getPassengers().hashCode() : 0);
        result = 31 * result + (getCargo_capacity() != null ? getCargo_capacity().hashCode() : 0);
        result = 31 * result + (getConsumables() != null ? getConsumables().hashCode() : 0);
        result = 31 * result + (getHyperdrive_rating() != null ? getHyperdrive_rating().hashCode() : 0);
        result = 31 * result + (getMGLT() != null ? getMGLT().hashCode() : 0);
        result = 31 * result + (getStarship_class() != null ? getStarship_class().hashCode() : 0);
        result = 31 * result + (getPilots() != null ? getPilots().hashCode() : 0);
        result = 31 * result + (getFilms() != null ? getFilms().hashCode() : 0);
        result = 31 * result + (getCreated() != null ? getCreated().hashCode() : 0);
        result = 31 * result + (getEdited() != null ? getEdited().hashCode() : 0);
        result = 31 * result + (getUrl() != null ? getUrl().hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(StarShip o) {
        return getUrl().compareTo(o.getUrl());
    }

    @Override
    protected void finalize() throws Throwable {
        name = null;
        model = null;
        manufacturer = null;
        cost_in_credits = null;
        length = null;
        max_atmosphering_speed = null;
        crew = null;
        passengers = null;
        cargo_capacity = null;
        consumables = null;
        hyperdrive_rating = null;
        MGLT = null;
        starship_class = null;
        pilots = null;
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
                .add("model", model)
                .add("manufacturer", manufacturer)
                .add("cost_in_credits", cost_in_credits)
                .add("length", length)
                .add("max_atmosphering_speed", max_atmosphering_speed)
                .add("crew", crew)
                .add("passengers", passengers)
                .add("cargo_capacity", cargo_capacity)
                .add("consumables", consumables)
                .add("hyperdrive_rating", hyperdrive_rating)
                .add("MGLT", MGLT)
                .add("starship_class", starship_class)
                .add("pilots", pilots)
                .add("films", films)
                .add("created", created)
                .add("edited", edited)
                .add("url", url)
                .toString();
    }
}

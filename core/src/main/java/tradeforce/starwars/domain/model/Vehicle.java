package tradeforce.starwars.domain.model;

import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.List;

import tradeforce.starwars.domain.Domain;

public class Vehicle implements Domain<Vehicle>, Serializable {

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCost_in_credits() {
        return cost_in_credits;
    }

    public void setCost_in_credits(String cost_in_credits) {
        this.cost_in_credits = cost_in_credits;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Integer getMax_atmosphering_speed() {
        return max_atmosphering_speed;
    }

    public void setMax_atmosphering_speed(Integer max_atmosphering_speed) {
        this.max_atmosphering_speed = max_atmosphering_speed;
    }

    public Integer getCrew() {
        return crew;
    }

    public void setCrew(Integer crew) {
        this.crew = crew;
    }

    public Integer getPassengers() {
        return passengers;
    }

    public void setPassengers(Integer passengers) {
        this.passengers = passengers;
    }

    public Integer getCargo_capacity() {
        return cargo_capacity;
    }

    public void setCargo_capacity(Integer cargo_capacity) {
        this.cargo_capacity = cargo_capacity;
    }

    public String getConsumables() {
        return consumables;
    }

    public void setConsumables(String consumables) {
        this.consumables = consumables;
    }

    public String getVehicle_class() {
        return vehicle_class;
    }

    public void setVehicle_class(String vehicle_class) {
        this.vehicle_class = vehicle_class;
    }

    public List<Person> getPilots() {
        return pilots;
    }

    public void setPilots(List<Person> pilots) {
        this.pilots = pilots;
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

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public Vehicle setUrl(String url) {
        this.url = url;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;

        Vehicle vehicle = (Vehicle) o;

        if (getName() != null ? !getName().equals(vehicle.getName()) : vehicle.getName() != null)
            return false;
        if (getModel() != null ? !getModel().equals(vehicle.getModel()) : vehicle.getModel() != null)
            return false;
        if (getManufacturer() != null ? !getManufacturer().equals(vehicle.getManufacturer()) : vehicle.getManufacturer() != null)
            return false;
        if (getCost_in_credits() != null ? !getCost_in_credits().equals(vehicle.getCost_in_credits()) : vehicle.getCost_in_credits() != null)
            return false;
        if (getLength() != null ? !getLength().equals(vehicle.getLength()) : vehicle.getLength() != null)
            return false;
        if (getMax_atmosphering_speed() != null ? !getMax_atmosphering_speed().equals(vehicle.getMax_atmosphering_speed()) : vehicle.getMax_atmosphering_speed() != null)
            return false;
        if (getCrew() != null ? !getCrew().equals(vehicle.getCrew()) : vehicle.getCrew() != null)
            return false;
        if (getPassengers() != null ? !getPassengers().equals(vehicle.getPassengers()) : vehicle.getPassengers() != null)
            return false;
        if (getCargo_capacity() != null ? !getCargo_capacity().equals(vehicle.getCargo_capacity()) : vehicle.getCargo_capacity() != null)
            return false;
        if (getConsumables() != null ? !getConsumables().equals(vehicle.getConsumables()) : vehicle.getConsumables() != null)
            return false;
        if (getVehicle_class() != null ? !getVehicle_class().equals(vehicle.getVehicle_class()) : vehicle.getVehicle_class() != null)
            return false;
        if (getPilots() != null ? !getPilots().equals(vehicle.getPilots()) : vehicle.getPilots() != null)
            return false;
        if (getFilms() != null ? !getFilms().equals(vehicle.getFilms()) : vehicle.getFilms() != null)
            return false;
        if (getCreated() != null ? !getCreated().equals(vehicle.getCreated()) : vehicle.getCreated() != null)
            return false;
        if (getEdited() != null ? !getEdited().equals(vehicle.getEdited()) : vehicle.getEdited() != null)
            return false;
        return getUrl() != null ? getUrl().equals(vehicle.getUrl()) : vehicle.getUrl() == null;

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
        result = 31 * result + (getVehicle_class() != null ? getVehicle_class().hashCode() : 0);
        result = 31 * result + (getPilots() != null ? getPilots().hashCode() : 0);
        result = 31 * result + (getFilms() != null ? getFilms().hashCode() : 0);
        result = 31 * result + (getCreated() != null ? getCreated().hashCode() : 0);
        result = 31 * result + (getEdited() != null ? getEdited().hashCode() : 0);
        result = 31 * result + (getUrl() != null ? getUrl().hashCode() : 0);
        return result;
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
        vehicle_class = null;
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
                .add("vehicle_class", vehicle_class)
                .add("pilots", pilots)
                .add("films", films)
                .add("created", created)
                .add("edited", edited)
                .add("url", url)
                .toString();
    }
}

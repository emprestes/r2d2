package tradeforce.domain.model;

import com.google.common.base.MoreObjects;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getEpisode_id() {
        return episode_id;
    }

    public void setEpisode_id(Integer episode_id) {
        this.episode_id = episode_id;
    }

    public String getOpening_crawl() {
        return opening_crawl;
    }

    public void setOpening_crawl(String opening_crawl) {
        this.opening_crawl = opening_crawl;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public List<Person> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Person> characters) {
        this.characters = characters;
    }

    public List<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(List<Planet> planets) {
        this.planets = planets;
    }

    public List<StarShip> getStarships() {
        return starships;
    }

    public void setStarships(List<StarShip> starships) {
        this.starships = starships;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Species> getSpecies() {
        return species;
    }

    public void setSpecies(List<Species> species) {
        this.species = species;
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
        if (!(o instanceof Film)) return false;

        Film film = (Film) o;

        if (getTitle() != null ? !getTitle().equals(film.getTitle()) : film.getTitle() != null)
            return false;
        if (getEpisode_id() != null ? !getEpisode_id().equals(film.getEpisode_id()) : film.getEpisode_id() != null)
            return false;
        if (getOpening_crawl() != null ? !getOpening_crawl().equals(film.getOpening_crawl()) : film.getOpening_crawl() != null)
            return false;
        if (getDirector() != null ? !getDirector().equals(film.getDirector()) : film.getDirector() != null)
            return false;
        if (getProducer() != null ? !getProducer().equals(film.getProducer()) : film.getProducer() != null)
            return false;
        if (getRelease_date() != null ? !getRelease_date().equals(film.getRelease_date()) : film.getRelease_date() != null)
            return false;
        if (getCharacters() != null ? !getCharacters().equals(film.getCharacters()) : film.getCharacters() != null)
            return false;
        if (getPlanets() != null ? !getPlanets().equals(film.getPlanets()) : film.getPlanets() != null)
            return false;
        if (getStarships() != null ? !getStarships().equals(film.getStarships()) : film.getStarships() != null)
            return false;
        if (getVehicles() != null ? !getVehicles().equals(film.getVehicles()) : film.getVehicles() != null)
            return false;
        if (getSpecies() != null ? !getSpecies().equals(film.getSpecies()) : film.getSpecies() != null)
            return false;
        if (getCreated() != null ? !getCreated().equals(film.getCreated()) : film.getCreated() != null)
            return false;
        if (getEdited() != null ? !getEdited().equals(film.getEdited()) : film.getEdited() != null)
            return false;
        return getUrl() != null ? getUrl().equals(film.getUrl()) : film.getUrl() == null;

    }

    @Override
    public int hashCode() {
        int result = getTitle() != null ? getTitle().hashCode() : 0;
        result = 31 * result + (getEpisode_id() != null ? getEpisode_id().hashCode() : 0);
        result = 31 * result + (getOpening_crawl() != null ? getOpening_crawl().hashCode() : 0);
        result = 31 * result + (getDirector() != null ? getDirector().hashCode() : 0);
        result = 31 * result + (getProducer() != null ? getProducer().hashCode() : 0);
        result = 31 * result + (getRelease_date() != null ? getRelease_date().hashCode() : 0);
        result = 31 * result + (getCharacters() != null ? getCharacters().hashCode() : 0);
        result = 31 * result + (getPlanets() != null ? getPlanets().hashCode() : 0);
        result = 31 * result + (getStarships() != null ? getStarships().hashCode() : 0);
        result = 31 * result + (getVehicles() != null ? getVehicles().hashCode() : 0);
        result = 31 * result + (getSpecies() != null ? getSpecies().hashCode() : 0);
        result = 31 * result + (getCreated() != null ? getCreated().hashCode() : 0);
        result = 31 * result + (getEdited() != null ? getEdited().hashCode() : 0);
        result = 31 * result + (getUrl() != null ? getUrl().hashCode() : 0);
        return result;
    }

    @Override
    protected void finalize() throws Throwable {
        title = null;
        episode_id = null;
        opening_crawl = null;
        director = null;
        producer = null;
        release_date = null;
        characters = null;
        planets = null;
        starships = null;
        vehicles = null;
        species = null;
        created = null;
        edited = null;
        url = null;

        super.finalize();
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("title", title)
                .add("episode_id", episode_id)
                .add("opening_crawl", opening_crawl)
                .add("director", director)
                .add("producer", producer)
                .add("release_date", release_date)
                .add("characters", characters)
                .add("planets", planets)
                .add("starships", starships)
                .add("vehicles", vehicles)
                .add("species", species)
                .add("created", created)
                .add("edited", edited)
                .add("url", url)
                .toString();
    }
}

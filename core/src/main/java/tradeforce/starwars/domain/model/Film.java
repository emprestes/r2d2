package tradeforce.starwars.domain.model;

import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.List;

import tradeforce.starwars.domain.Domain;

public class Film implements Domain<Film>, Serializable {

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

    public Film setTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getEpisode_id() {
        return episode_id;
    }

    public Film setEpisode_id(Integer episode_id) {
        this.episode_id = episode_id;
        return this;
    }

    public String getOpening_crawl() {
        return opening_crawl;
    }

    public Film setOpening_crawl(String opening_crawl) {
        this.opening_crawl = opening_crawl;
        return this;
    }

    public String getDirector() {
        return director;
    }

    public Film setDirector(String director) {
        this.director = director;
        return this;
    }

    public String getProducer() {
        return producer;
    }

    public Film setProducer(String producer) {
        this.producer = producer;
        return this;
    }

    public String getRelease_date() {
        return release_date;
    }

    public Film setRelease_date(String release_date) {
        this.release_date = release_date;
        return this;
    }

    public List<Person> getCharacters() {
        return characters;
    }

    public Film setCharacters(List<Person> characters) {
        this.characters = characters;
        return this;
    }

    public List<Planet> getPlanets() {
        return planets;
    }

    public Film setPlanets(List<Planet> planets) {
        this.planets = planets;
        return this;
    }

    public List<StarShip> getStarships() {
        return starships;
    }

    public Film setStarships(List<StarShip> starships) {
        this.starships = starships;
        return this;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public Film setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
        return this;
    }

    public List<Species> getSpecies() {
        return species;
    }

    public Film setSpecies(List<Species> species) {
        this.species = species;
        return this;
    }

    public String getCreated() {
        return created;
    }

    public Film setCreated(String created) {
        this.created = created;
        return this;
    }

    public String getEdited() {
        return edited;
    }

    public Film setEdited(String edited) {
        this.edited = edited;
        return this;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public Film setUrl(String url) {
        this.url = url;
        return this;
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

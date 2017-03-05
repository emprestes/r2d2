package tradeforce.starwars.domain.model;

import com.google.common.base.MoreObjects;

import java.util.List;

import tradeforce.starwars.repository.orm.Column;
import tradeforce.starwars.repository.orm.Entity;
import tradeforce.starwars.repository.orm.Id;
import tradeforce.starwars.repository.orm.Table;

/**
 * Classe que representa um filme do Star Wars.
 *
 * @author Prestes, E. M.
 * @since Março de 2017
 *
 * @see Entity
 * @see Table
 * @see Id
 * @see Column
 * @see tradeforce.starwars.repository.Entity
 * @see Comparable
 */
@Entity
@Table("filme")
public class Film implements tradeforce.starwars.repository.Entity<Long>, Comparable<Film> {

    /** Constante de ID do filme. */
    public static final String _ID_FILM = "id_filme";

    /** Constante de ID do personagem. */
    public static final String _ID_PERSON = "id_personagem";

    @Id
    @Column(name = _ID, nullable = false)
    private Long id;

    @Column(name = _ID_FILM, nullable = false)
    private Long idFilm;

    @Column(name = _ID_PERSON, nullable = false)
    private Long idPerson;

    @Column(name = "nm_titulo", nullable = false)
    private String title;

    @Column(name = "id_episodio")
    private String episode_id;

    private String opening_crawl;

    private String director;

    private String producer;

    private String release_date;

    private List<String> characters;

    private List<String> planets;

    private List<String> starships;

    private List<String> vehicles;

    private List<String> species;

    @Column(name = "dt_criacao", nullable = false)
    private String created;

    @Column(name = "dt_edicao", nullable = false)
    private String edited;

    @Column(name = "ds_url", nullable = false)
    private String url;

    /** {@inheritDoc} */
    @Override
    public Long getId() {
        return id;
    }

    /** {@inheritDoc} */
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    /** {@inheritDoc} */
    @Override
    public boolean hasId() {
        return getId() != null;
    }

    /**
     * Recupera o ID do filme.
     *
     * @return ID do filme.
     */
    public Long getIdFilm() {
        return idFilm;
    }

    /**
     * Configura ID do filme.
     *
     * @param idFilm ID do filme informado.
     * @return Film
     */
    public Film setIdFilm(Long idFilm) {
        this.idFilm = idFilm;
        return this;
    }

    /**
     * Recupera o ID do personagem do filme.
     *
     * @return ID do personagem do filme.
     */
    public Long getIdPerson() {
        return idPerson;
    }

    /**
     * Configura ID do personagem do filme.
     *
     * @param idPerson ID do personagem informado.
     * @return Film
     */
    public Film setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
        return this;
    }

    /**
     * Recupera o título do filme.
     *
     * @return Título do filme.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Configura título do filme.
     *
     * @param title Título informada.
     * @return Film
     */
    public Film setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Recupera o episódio do filme.
     *
     * @return Episódio do filme.
     */
    public String getEpisode_id() {
        return episode_id;
    }

    /**
     * Configura episódio do filme.
     *
     * @param episode_id Episódio informada.
     * @return Film
     */
    public Film setEpisode_id(String episode_id) {
        this.episode_id = episode_id;
        return this;
    }

    /**
     * Recupera a triagem do filme.
     *
     * @return Triagem do filme.
     */
    public String getOpening_crawl() {
        return opening_crawl;
    }

    /**
     * Configura triagem do filme.
     *
     * @param opening_crawl Triagem informada.
     * @return Film
     */
    public Film setOpening_crawl(String opening_crawl) {
        this.opening_crawl = opening_crawl;
        return this;
    }

    /**
     * Recupera o diretor do filme.
     *
     * @return Diretor do filme.
     */
    public String getDirector() {
        return director;
    }

    /**
     * Configura diretor do filme.
     *
     * @param director Diretor informado.
     * @return Film
     */
    public Film setDirector(String director) {
        this.director = director;
        return this;
    }

    /**
     * Recupera o produtor do filme.
     *
     * @return Produtor do filme.
     */
    public String getProducer() {
        return producer;
    }

    /**
     * Configura produtor do filme.
     *
     * @param producer Produtor informado.
     * @return Film
     */
    public Film setProducer(String producer) {
        this.producer = producer;
        return this;
    }

    /**
     * Recupera a data de lançamento do filme.
     *
     * @return Data de lançamento do filme.
     */
    public String getRelease_date() {
        return release_date;
    }

    /**
     * Configura a data de lançamento do filme.
     *
     * @param release_date Data de lançamento informada.
     * @return Film
     */
    public Film setRelease_date(String release_date) {
        this.release_date = release_date;
        return this;
    }

    /**
     * Recupera os personagens do filme.
     *
     * @return Personagens do filme.
     */
    public List<String> getCharacters() {
        return characters;
    }

    /**
     * Configura os personagens do filme.
     *
     * @param characters Personagens informados.
     * @return Film
     */
    public Film setCharacters(List<String> characters) {
        this.characters = characters;
        return this;
    }

    /**
     * Recupera os planetas do filme.
     *
     * @return Planetas do filme.
     */
    public List<String> getPlanets() {
        return planets;
    }

    /**
     * Configura os planetas do filme.
     *
     * @param planets Planetas informados.
     * @return Film
     */
    public Film setPlanets(List<String> planets) {
        this.planets = planets;
        return this;
    }

    /**
     * Recupera as espaço naves do filme.
     *
     * @return Espaço naves do filme.
     */
    public List<String> getStarships() {
        return starships;
    }

    /**
     * Configura as espaço naves do filme.
     *
     * @param starships Espaço naves informada.
     * @return Film
     */
    public Film setStarships(List<String> starships) {
        this.starships = starships;
        return this;
    }

    /**
     * Recupera os veículos do filme.
     *
     * @return Veículos do filme.
     */
    public List<String> getVehicles() {
        return vehicles;
    }

    /**
     * Configura os veículos do filme.
     *
     * @param vehicles Veículos filme.
     * @return Film
     */
    public Film setVehicles(List<String> vehicles) {
        this.vehicles = vehicles;
        return this;
    }

    /**
     * Recupera as espécies do filme.
     *
     * @return Espécies do filme.
     */
    public List<String> getSpecies() {
        return species;
    }

    /**
     * Configura as espécies do filme.
     *
     * @param species Espécies informada.
     * @return Film
     */
    public Film setSpecies(List<String> species) {
        this.species = species;
        return this;
    }

    /**
     * Recupera a data de criação do filme.
     *
     * @return Data de criação do filme.
     */
    public String getCreated() {
        return created;
    }

    /**
     * Configura a data de criação do filme.
     *
     * @param created Data de criação informada.
     * @return Film
     */
    public Film setCreated(String created) {
        this.created = created;
        return this;
    }

    /**
     * Recupera a data de edição do filme.
     *
     * @return Data de edição informada.
     */
    public String getEdited() {
        return edited;
    }

    /**
     * Configura a data de edição do personagem.
     *
     * @param edited Data de edição informada.
     * @return Film
     */
    public Film setEdited(String edited) {
        this.edited = edited;
        return this;
    }

    /**
     * Recupera a url do personagem.
     *
     * @return URL do personagem.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Configura a URL do personagem.
     *
     * @param url URL informada.
     * @return Film
     */
    public Film setUrl(String url) {
        this.url = url;
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Film)) return false;

        Film film = (Film) o;

        if (getId() != null ? !getId().equals(film.getId()) : film.getId() != null) return false;
        if (getIdFilm() != null ? !getIdFilm().equals(film.getIdFilm()) : film.getIdFilm() != null)
            return false;
        if (getIdPerson() != null ? !getIdPerson().equals(film.getIdPerson()) : film.getIdPerson() != null)
            return false;
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

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getIdFilm() != null ? getIdFilm().hashCode() : 0);
        result = 31 * result + (getIdPerson() != null ? getIdPerson().hashCode() : 0);
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
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

    /** {@inheritDoc} */
    @Override
    public int compareTo(Film o) {
        return getEpisode_id().compareTo(o.getEpisode_id());
    }

    /** {@inheritDoc} */
    @Override
    protected void finalize() throws Throwable {
        id = null;
        idFilm = null;
        idPerson = null;
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

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("idFilm", idFilm)
                .add("idPerson", idPerson)
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

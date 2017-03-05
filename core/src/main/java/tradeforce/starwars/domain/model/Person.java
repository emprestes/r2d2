package tradeforce.starwars.domain.model;

import com.google.common.base.MoreObjects;

import java.util.Date;
import java.util.List;

import tradeforce.starwars.repository.orm.Column;
import tradeforce.starwars.repository.orm.Entity;
import tradeforce.starwars.repository.orm.Id;
import tradeforce.starwars.repository.orm.Table;

/**
 * Classe que representa um personagem do Star Wars.
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
@Table("personagem")
public class Person implements tradeforce.starwars.repository.Entity<Long>, Comparable<Person> {

    @Id(autoincrement = false)
    @Column(name = _ID, nullable = false)
    private Long id;

    @Column(name = "vl_url", nullable = false)
    private String url;

    @Column(name = "nm_personagem", nullable = false)
    private String name;

    @Column(name = "vl_altura")
    private String height;

    @Column(name = "vl_massa")
    private String mass;

    @Column(name = "ds_cor_cabelo")
    private String hair_color;

    @Column(name = "ds_cor_pele")
    private String skin_color;

    @Column(name = "ds_cor_olhos")
    private String eye_color;

    @Column(name = "vl_ano_nascimento")
    private String birth_year;

    @Column(name = "ds_genero")
    private String gender;

    @Column(name = "nm_planeta")
    private String homeworld;

    private List<String> films;

    private List<String> species;

    private List<String> vehicles;

    private List<String> starships;

    @Column(name = "dt_criacao", nullable = false)
    private String created;

    @Column(name = "dt_edicao", nullable = false)
    private String edited;

    @Column(name = "vl_latitude", nullable = false)
    private Double latitude;

    @Column(name = "vl_longitude", nullable = false)
    private Double longitude;

    @Column(name = "dt_hora", nullable = false)
    private Long capturedInMillis;

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
     * Recupera o nome do personagem.
     *
     * @return Nome do personagem.
     */
    public String getName() {
        return name;
    }

    /**
     * Configura o nome do personagem.
     *
     * @param name Nome informado.
     * @return Person
     */
    public Person setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Recupera a altura do personagem.
     *
     * @return Altura do personagem.
     */
    public String getHeight() {
        return height;
    }

    /**
     * Configura a altura do personagem.
     *
     * @param height Altura informada.
     * @return Person
     */
    public Person setHeight(String height) {
        this.height = height;
        return this;
    }

    /**
     * Recupera a massa do personagem.
     *
     * @return Massa do personagem.
     */
    public String getMass() {
        return mass;
    }

    /**
     * Configura massa do personagem.
     *
     * @param mass Massa informada.
     * @return Person
     */
    public Person setMass(String mass) {
        this.mass = mass;
        return this;
    }

    /**
     * Recupera a cor do cabelo do personagem.
     *
     * @return Cor do cabelo do personagem.
     */
    public String getHair_color() {
        return hair_color;
    }

    /**
     * Configura cor do cabelo do personagem.
     *
     * @param hair_color Cor do cabelo informado.
     * @return Person
     */
    public Person setHair_color(String hair_color) {
        this.hair_color = hair_color;
        return this;
    }

    /**
     * Recupera cor da pele do personagem.
     *
     * @return Cor da pele do personagem.
     */
    public String getSkin_color() {
        return skin_color;
    }

    /**
     * Configura cor da pele do personagem.
     *
     * @param skin_color Cor da pele informado.
     * @return Person
     */
    public Person setSkin_color(String skin_color) {
        this.skin_color = skin_color;
        return this;
    }

    /**
     * Recupera cor dos olhos do personagem.
     *
     * @return Cor dos olhos do personagem.
     */
    public String getEye_color() {
        return eye_color;
    }

    /**
     * Configura cor dos olhos do personagem.
     *
     * @param eye_color Cor dos olhos informado.
     * @return Person
     */
    public Person setEye_color(String eye_color) {
        this.eye_color = eye_color;
        return this;
    }

    /**
     * Recupera o ano de nascimento do personagem.
     *
     * @return Ano do nascimento do personagem.
     */
    public String getBirth_year() {
        return birth_year;
    }

    /**
     * Configura o ano de nascimento do personagem.
     *
     * @param birth_year Ano do nascimento informado.
     * @return Person
     */
    public Person setBirth_year(String birth_year) {
        this.birth_year = birth_year;
        return this;
    }

    /**
     * Recupera o gênero do personagem.
     *
     * @return Gênero do personagem.
     */
    public String getGender() {
        return gender;
    }

    /**
     * Configura o gênero do personagem.
     *
     * @param gender Gênero informado.
     * @return Person
     */
    public Person setGender(String gender) {
        this.gender = gender;
        return this;
    }

    /**
     * Recupera o mundo natal do personagem.
     *
     * @return Mundo natal do personagem.
     */
    public String getHomeworld() {
        return homeworld;
    }

    /**
     * Configura o mundo natal do personagem.
     *
     * @param homeworld Mundo natal informado.
     * @return Person
     */
    public Person setHomeworld(String homeworld) {
        this.homeworld = homeworld;
        return this;
    }

    /**
     * Recupera os filmes do personagem.
     *
     * @return Filmes do personagem.
     */
    public List<String> getFilms() {
        return films;
    }

    /**
     * Configura os filmes do personagem.
     *
     * @param films Filmes informados.
     * @return Person
     */
    public Person setFilms(List<String> films) {
        this.films = films;
        return this;
    }

    /**
     * Recupera as espécies do personagem.
     *
     * @return Espécies do personagem.
     */
    public List<String> getSpecies() {
        return species;
    }

    /**
     * Configura as espécies do personagem.
     *
     * @param species Espécies informada.
     * @return Person
     */
    public Person setSpecies(List<String> species) {
        this.species = species;
        return this;
    }

    /**
     * Recupera os veículos do personagem.
     *
     * @return Veículos do personagem.
     */
    public List<String> getVehicles() {
        return vehicles;
    }

    /**
     * Configura os veículos do personagem.
     *
     * @param vehicles Veículos informada.
     * @return Person
     */
    public Person setVehicles(List<String> vehicles) {
        this.vehicles = vehicles;
        return this;
    }

    /**
     * Recupera as espaço naves do personagem.
     *
     * @return Espaço naves do personagem.
     */
    public List<String> getStarships() {
        return starships;
    }

    /**
     * Configura as espaço naves do personagem.
     *
     * @param starships Espaço naves informada.
     * @return Person
     */
    public Person setStarships(List<String> starships) {
        this.starships = starships;
        return this;
    }

    /**
     * Recupera a data de criação do personagem.
     *
     * @return Data de criação do personagem.
     */
    public String getCreated() {
        return created;
    }

    /**
     * Configura a data de criação do personagem.
     *
     * @param created Data de criação informada.
     * @return Person
     */
    public Person setCreated(String created) {
        this.created = created;
        return this;
    }

    /**
     * Recupera a data de edição do personagem.
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
     * @return Person
     */
    public Person setEdited(String edited) {
        this.edited = edited;
        return this;
    }

    /**
     * Recupera a latitude da captura do personagem.
     *
     * @return Latitude de captura do personagem.
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * Configura a latitude da captura do personagem.
     *
     * @param latitude Latitude de captura informada.
     * @return Person
     */
    public Person setLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    /**
     * Recupera a longitude da captura do personagem.
     *
     * @return Longitude de captura do personagem.
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * Configura a longitude da captura do personagem.
     *
     * @param longitude Longitude de captura informada.
     * @return Person
     */
    public Person setLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    /**
     * Recupera a data da captura do personagem.
     *
     * @return Data de captura do personagem em millis.
     */
    public Long getCapturedInMillis() {
        return capturedInMillis;
    }

    /**
     * Recupera a data da captura do personagem.
     *
     * @return Data de captura do personagem.
     */
    public Date getCapturedDate() {
        return new Date(capturedInMillis);
    }

    /**
     * Configura a data da captura do personagem.
     *
     * @param capturedInMillis a data da captura informada.
     * @return Person
     */
    public Person setCapturedInMillis(Long capturedInMillis) {
        this.capturedInMillis = capturedInMillis;
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
     * @return Person
     */
    public Person setUrl(String url) {
        this.url = url;
        return this;
    }

    /** {@inheritDoc} */
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

    /** {@inheritDoc} */
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

    /** {@inheritDoc} */
    @Override
    public int compareTo(Person o) {
        return getName().compareTo(o.getName());
    }

    /** {@inheritDoc} */
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

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("latitude", latitude)
                .add("longitude", longitude)
                .add("capturedInMillis", capturedInMillis)
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

package tradeforce.starwars.domain.model;

import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.List;

import tradeforce.starwars.domain.Domain;

public class Species implements Domain, Serializable {

    private String name;

    private String classification;

    private String designation;

    private Integer average_height;

    private String skin_colors;

    private String hair_colors;

    private String eye_colors;

    private Integer average_lifespan;

    private String homeworld;

    private String language;

    private List<Person> people;

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

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Integer getAverage_height() {
        return average_height;
    }

    public void setAverage_height(Integer average_height) {
        this.average_height = average_height;
    }

    public String getSkin_colors() {
        return skin_colors;
    }

    public void setSkin_colors(String skin_colors) {
        this.skin_colors = skin_colors;
    }

    public String getHair_colors() {
        return hair_colors;
    }

    public void setHair_colors(String hair_colors) {
        this.hair_colors = hair_colors;
    }

    public String getEye_colors() {
        return eye_colors;
    }

    public void setEye_colors(String eye_colors) {
        this.eye_colors = eye_colors;
    }

    public Integer getAverage_lifespan() {
        return average_lifespan;
    }

    public void setAverage_lifespan(Integer average_lifespan) {
        this.average_lifespan = average_lifespan;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
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
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Species)) return false;

        Species species = (Species) o;

        if (getName() != null ? !getName().equals(species.getName()) : species.getName() != null)
            return false;
        if (getClassification() != null ? !getClassification().equals(species.getClassification()) : species.getClassification() != null)
            return false;
        if (getDesignation() != null ? !getDesignation().equals(species.getDesignation()) : species.getDesignation() != null)
            return false;
        if (getAverage_height() != null ? !getAverage_height().equals(species.getAverage_height()) : species.getAverage_height() != null)
            return false;
        if (getSkin_colors() != null ? !getSkin_colors().equals(species.getSkin_colors()) : species.getSkin_colors() != null)
            return false;
        if (getHair_colors() != null ? !getHair_colors().equals(species.getHair_colors()) : species.getHair_colors() != null)
            return false;
        if (getEye_colors() != null ? !getEye_colors().equals(species.getEye_colors()) : species.getEye_colors() != null)
            return false;
        if (getAverage_lifespan() != null ? !getAverage_lifespan().equals(species.getAverage_lifespan()) : species.getAverage_lifespan() != null)
            return false;
        if (getHomeworld() != null ? !getHomeworld().equals(species.getHomeworld()) : species.getHomeworld() != null)
            return false;
        if (getLanguage() != null ? !getLanguage().equals(species.getLanguage()) : species.getLanguage() != null)
            return false;
        if (getPeople() != null ? !getPeople().equals(species.getPeople()) : species.getPeople() != null)
            return false;
        if (getFilms() != null ? !getFilms().equals(species.getFilms()) : species.getFilms() != null)
            return false;
        if (getCreated() != null ? !getCreated().equals(species.getCreated()) : species.getCreated() != null)
            return false;
        if (getEdited() != null ? !getEdited().equals(species.getEdited()) : species.getEdited() != null)
            return false;
        return getUrl() != null ? getUrl().equals(species.getUrl()) : species.getUrl() == null;

    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getClassification() != null ? getClassification().hashCode() : 0);
        result = 31 * result + (getDesignation() != null ? getDesignation().hashCode() : 0);
        result = 31 * result + (getAverage_height() != null ? getAverage_height().hashCode() : 0);
        result = 31 * result + (getSkin_colors() != null ? getSkin_colors().hashCode() : 0);
        result = 31 * result + (getHair_colors() != null ? getHair_colors().hashCode() : 0);
        result = 31 * result + (getEye_colors() != null ? getEye_colors().hashCode() : 0);
        result = 31 * result + (getAverage_lifespan() != null ? getAverage_lifespan().hashCode() : 0);
        result = 31 * result + (getHomeworld() != null ? getHomeworld().hashCode() : 0);
        result = 31 * result + (getLanguage() != null ? getLanguage().hashCode() : 0);
        result = 31 * result + (getPeople() != null ? getPeople().hashCode() : 0);
        result = 31 * result + (getFilms() != null ? getFilms().hashCode() : 0);
        result = 31 * result + (getCreated() != null ? getCreated().hashCode() : 0);
        result = 31 * result + (getEdited() != null ? getEdited().hashCode() : 0);
        result = 31 * result + (getUrl() != null ? getUrl().hashCode() : 0);
        return result;
    }

    @Override
    protected void finalize() throws Throwable {
        name = null;
        classification = null;
        designation = null;
        average_height = null;
        skin_colors = null;
        hair_colors = null;
        eye_colors = null;
        average_lifespan = null;
        homeworld = null;
        language = null;
        people = null;
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
                .add("classification", classification)
                .add("designation", designation)
                .add("average_height", average_height)
                .add("skin_colors", skin_colors)
                .add("hair_colors", hair_colors)
                .add("eye_colors", eye_colors)
                .add("average_lifespan", average_lifespan)
                .add("homeworld", homeworld)
                .add("language", language)
                .add("people", people)
                .add("films", films)
                .add("created", created)
                .add("edited", edited)
                .add("url", url)
                .toString();
    }
}

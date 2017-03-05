package tradeforce.starwars.domain.model;

import com.google.common.base.MoreObjects;

import java.io.Serializable;

/**
 * Classe que representa planetas do Star Wars.
 *
 * @author Prestes, E. M.
 * @since Março de 2017
 *
 * @see Serializable
 */
public class Planet implements Serializable {

    private String name;

    /**
     * Recupera o nome do planeta.
     *
     * @return Nome do planeta.
     */
    public String getName() {
        return name;
    }

    /**
     * Configura o nome do planeta.
     *
     * @param name Nome do planeta.
     * @return Planeta
     */
    public Planet setName(String name) {
        this.name = name;
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Planet)) return false;

        Planet planet = (Planet) o;

        return getName() != null ? getName().equals(planet.getName()) : planet.getName() == null;

    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        return getName() != null ? getName().hashCode() : 0;
    }

    /** {@inheritDoc} */
    @Override
    protected void finalize() throws Throwable {
        name = null;

        super.finalize();
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .toString();
    }
}

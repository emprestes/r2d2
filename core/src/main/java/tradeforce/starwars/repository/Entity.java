package tradeforce.starwars.repository;

import java.io.Serializable;

/**
 * Interface que representa entidades serializadas.
 *
 * @param <PK> Tipo da chave primária
 *
 * @author Prestes, E. M.
 * @since Março de 2017
 *
 * @see Serializable
 */
public interface Entity<PK> extends Serializable {

    /** Constante da chave ID */
    String _ID = "_id";

    /**
     * Verifica se a entidade possui ID.
     *
     * @return true persistido, false transiente
     */
    boolean hasId();

    /**
     * Recupera o ID da entidade.
     *
     * @return ID da entidade em acordo a PK.
     */
    PK getId();

    /**
     * Configura o ID da entidade.
     *
     * @param id ID da entidade em acordo a PK.
     */
    void setId(PK id);
}

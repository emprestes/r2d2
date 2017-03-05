package tradeforce.starwars.r2d2.util.function;

/**
 * Interface funcional para consumo de um comportamento.
 *
 * @param <T> Tipo a ser consumido.
 *
 * @author Prestes, E. M.
 * @since Março de 2017
 *
 */
public interface Consumer<T> {

    /**
     * Comportamento a ser consumido com valor informado.
     *
     * @param value Valor informado.
     */
    void accept(T value);
}

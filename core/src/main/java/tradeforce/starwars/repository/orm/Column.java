package tradeforce.starwars.repository.orm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Anotação que representa informações de coluna em banco de dados.
 *
 * @author Prestes, E. M.
 * @since Março de 2017
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Column {

    /**
     * Nome da coluna em tabela de banco de dados.
     *
     * @return Nome da coluna.
     */
    String name() default "";

    /**
     * Tamanho da coluna em tabela de banco de dados.
     * @return Tamanho da coluna
     */
    int length() default 255;

    /**
     * Obrigatoriedade de valor em coluna de banco de dados.
     * @return Null or Not Null
     */
    boolean nullable() default true;
}

package tradeforce.starwars.repository.orm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Anotação que representa informações de tabela em banco de dados.
 *
 * @author Prestes, E. M.
 * @since Março de 2017
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Table {

    /**
     * Nome da tabela.] em banco de dados.
     *
     * @return Nome da tabela.
     */
    String value() default "";
}

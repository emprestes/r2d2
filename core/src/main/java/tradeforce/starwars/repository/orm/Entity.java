package tradeforce.starwars.repository.orm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Anotação que representa informações de entidade em banco de dados.
 *
 * @author Prestes, E. M.
 * @since Março de 2017
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Entity {

}

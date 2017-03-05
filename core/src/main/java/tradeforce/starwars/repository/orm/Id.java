package tradeforce.starwars.repository.orm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Anotação que representa informações de chave primária de tabela em banco de dados.
 *
 * @author Prestes, E. M.
 * @since Março de 2017
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Id {

    /**
     * Configura se a chave primária possui auto incremento.
     *
     * @return Liga/Desliga auto incremento.
     */
    boolean autoincrement() default true;
}

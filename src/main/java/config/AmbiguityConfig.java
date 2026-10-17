package config;

import dao.DaoImpl;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * Etape 10 : reproduit l'ambiguite.
 * On exclut DaoImpl (la seule qui porte @Primary) du scan : il reste dao2, daoFile
 * et daoApi, donc Spring ne sait plus laquelle injecter dans MetierImpl.
 */
@Configuration
@ComponentScan(
        basePackages = {"dao", "metier"},
        excludeFilters = @ComponentScan.Filter(
                type = FilterType.ASSIGNABLE_TYPE,
                classes = DaoImpl.class))
public class AmbiguityConfig {
}

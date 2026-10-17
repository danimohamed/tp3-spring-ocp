package config;

import dao.DaoApi;
import dao.DaoImpl;
import dao.IDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Primary;

/**
 * Strategie B : alias via @Bean.
 * Pour changer de source, il suffit de modifier la ligne "return new DaoApi();".
 * Ni les classes DAO ni le code metier ne bougent.
 */
@Configuration
@ComponentScan(
        basePackages = {"dao", "metier"},
        excludeFilters = @ComponentScan.Filter(
                type = FilterType.ASSIGNABLE_TYPE,
                classes = DaoImpl.class))
public class DaoAliasConfig {

    @Bean
    @Primary
    public IDao daoAlias() {
        return new DaoApi();
    }
}

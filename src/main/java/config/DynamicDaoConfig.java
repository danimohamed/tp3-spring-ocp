package config;

import dao.DaoApi;
import dao.DaoFile;
import dao.DaoImpl;
import dao.DaoImpl2;
import dao.IDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

/**
 * Strategie C : selection par propriete externe.
 * La cible vient de app.properties (dao.target=dao2) et peut etre surchargee
 * par la variable d'environnement DAO_TARGET sans recompiler.
 */
@Configuration
@ComponentScan(
        basePackages = {"dao", "metier"},
        excludeFilters = @ComponentScan.Filter(
                type = FilterType.ASSIGNABLE_TYPE,
                classes = DaoImpl.class))
@PropertySource("classpath:app.properties")
public class DynamicDaoConfig {

    @Value("${dao.target}")
    private String daoTarget;

    @Bean
    @Primary
    public IDao dynamicDao() {
        System.out.println("[CONFIG] dao.target = " + daoTarget);
        switch (daoTarget) {
            case "dao":
                return new DaoImpl();
            case "dao2":
                return new DaoImpl2();
            case "daoFile":
                return new DaoFile();
            case "daoApi":
                return new DaoApi();
            default:
                throw new IllegalArgumentException("Cible DAO inconnue: " + daoTarget);
        }
    }
}

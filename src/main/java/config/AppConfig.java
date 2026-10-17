package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Configuration principale : scanne dao + metier et charge app.properties.
 * DaoImpl porte @Primary, c'est donc elle qui est injectee par defaut (strategie A).
 */
@Configuration
@ComponentScan(basePackages = {"dao", "metier"})
@PropertySource("classpath:app.properties")
public class AppConfig {
}

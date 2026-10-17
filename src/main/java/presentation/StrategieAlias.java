package presentation;

import config.DaoAliasConfig;
import metier.IMetier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Strategie B : le bean alias @Primary remplace DaoImpl.
 * DaoApi renvoie 220.0, donc le resultat est 440.0.
 */
public class StrategieAlias {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DaoAliasConfig.class);

        IMetier metier = context.getBean("metier", IMetier.class);
        System.out.println("Resultat (alias @Bean -> DaoApi) : " + metier.calcul());

        context.close();
    }
}

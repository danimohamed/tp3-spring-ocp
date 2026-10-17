package presentation;

import config.DynamicDaoConfig;
import metier.IMetier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Strategie C : la cible vient de app.properties (dao.target=dao2).
 * DaoImpl2 renvoie 150.0, donc le resultat est 300.0.
 */
public class StrategieProprietes {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DynamicDaoConfig.class);

        IMetier metier = context.getBean("metier", IMetier.class);
        System.out.println("Resultat (propriete dao.target) : " + metier.calcul());

        context.close();
    }
}

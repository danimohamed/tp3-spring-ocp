import config.AppConfig;
import metier.IMetier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * Etape 9 : point d'entree.
 * Strategie A : DaoImpl porte @Primary, Spring l'injecte automatiquement.
 * MetierImpl n'est jamais modifie.
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("[CONTENEUR] Beans IDao disponibles : "
                + Arrays.toString(context.getBeanNamesForType(dao.IDao.class)));

        IMetier metier = context.getBean("metier", IMetier.class);
        double resultat = metier.calcul();

        System.out.println("Resultat final : " + resultat);

        context.close();
    }
}

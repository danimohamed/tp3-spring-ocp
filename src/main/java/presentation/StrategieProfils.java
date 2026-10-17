package presentation;

import config.AppConfig;
import dao.IDao;
import metier.IMetier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * Etape 17 : les profils Spring activent/desactivent des beans selon l'environnement.
 * daoProfilProd n'existe qu'avec le profil "prod" actif.
 */
public class StrategieProfils {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("prod");
        context.register(AppConfig.class);
        context.refresh();

        System.out.println("[CONTENEUR] Profil actif : "
                + Arrays.toString(context.getEnvironment().getActiveProfiles()));
        System.out.println("[CONTENEUR] Beans IDao : "
                + Arrays.toString(context.getBeanNamesForType(IDao.class)));

        IMetier metier = context.getBean("metier", IMetier.class);
        System.out.println("Resultat (profil prod) : " + metier.calcul());

        context.close();
    }
}

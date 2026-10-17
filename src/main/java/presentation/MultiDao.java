package presentation;

import config.AppConfig;
import metier.MetierMultiple;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Etape 20 : injection d'une List<IDao> et d'une Map<String, IDao>.
 * On injecte toutes les implementations d'un coup (agregation / strategies multiples).
 */
public class MultiDao {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        MetierMultiple metier = context.getBean("metierMultiple", MetierMultiple.class);

        System.out.println("[CONTENEUR] Nombre de DAO injectes : " + metier.getDaos().size());
        System.out.println("[CONTENEUR] Cles de la Map : " + metier.getDaoMap().keySet());
        System.out.println("Somme de toutes les sources : " + metier.calcul());

        context.close();
    }
}

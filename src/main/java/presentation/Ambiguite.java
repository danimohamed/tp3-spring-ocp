package presentation;

import config.AmbiguityConfig;
import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Etape 10 : sans @Primary, Spring leve NoUniqueBeanDefinitionException.
 */
public class Ambiguite {

    public static void main(String[] args) {
        try {
            new AnnotationConfigApplicationContext(AmbiguityConfig.class);
            System.out.println("[ERREUR] Aucune exception levee, comportement inattendu");
        } catch (BeansException e) {
            System.out.println("[ERREUR] " + e.getClass().getSimpleName());
            Throwable cause = e;
            while (cause.getCause() != null) {
                cause = cause.getCause();
            }
            System.out.println("[ERREUR] " + cause.getClass().getSimpleName()
                    + " : " + cause.getMessage());
        }
    }
}

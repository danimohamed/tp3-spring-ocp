package ocp;

import config.AppConfig;
import dao.IDao;
import metier.IMetier;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Strategie A : @Primary sur DaoImpl.
 * Le code metier n'a pas bouge, seul le conteneur choisit.
 */
public class OcpSelectionTest {

    @Test
    public void primarySelectionneDaoImpl() {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {

            IMetier metier = context.getBean("metier", IMetier.class);

            assertEquals(200.0, metier.calcul(), 0.001);
        }
    }

    @Test
    public void quatreImplementationsSontDisponibles() {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {

            assertEquals(4, context.getBeanNamesForType(IDao.class).length);
        }
    }

    @Test
    public void leMetierDependDeLInterface() {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {

            IMetier metier = context.getBean("metier", IMetier.class);
            assertTrue(metier.getClass().getSimpleName().equals("MetierImpl"));
        }
    }
}

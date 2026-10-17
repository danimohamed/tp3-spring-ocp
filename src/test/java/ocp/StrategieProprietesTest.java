package ocp;

import config.DynamicDaoConfig;
import metier.IMetier;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;

/**
 * Strategie C : dao.target=dao2 dans app.properties -> DaoImpl2 (150.0).
 */
public class StrategieProprietesTest {

    @Test
    public void proprieteSelectionneDaoImpl2() {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(DynamicDaoConfig.class)) {

            IMetier metier = context.getBean("metier", IMetier.class);

            assertEquals(300.0, metier.calcul(), 0.001);
        }
    }
}

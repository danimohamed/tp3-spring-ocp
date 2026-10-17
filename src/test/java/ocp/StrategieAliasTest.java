package ocp;

import config.DaoAliasConfig;
import metier.IMetier;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;

/**
 * Strategie B : le bean alias pointe vers DaoApi (220.0).
 */
public class StrategieAliasTest {

    @Test
    public void aliasInjecteDaoApi() {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(DaoAliasConfig.class)) {

            IMetier metier = context.getBean("metier", IMetier.class);

            assertEquals(440.0, metier.calcul(), 0.001);
        }
    }
}

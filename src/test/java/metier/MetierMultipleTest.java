package metier;

import config.AppConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Etape 20 : injection de plusieurs implementations a la fois.
 */
public class MetierMultipleTest {

    @Test
    public void tousLesDaoSontInjectesDansLaListe() {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {

            MetierMultiple metier = context.getBean("metierMultiple", MetierMultiple.class);

            assertEquals(4, metier.getDaos().size());
            assertTrue(metier.getDaoMap().containsKey("dao"));
            assertTrue(metier.getDaoMap().containsKey("dao2"));
            assertTrue(metier.getDaoMap().containsKey("daoFile"));
            assertTrue(metier.getDaoMap().containsKey("daoApi"));
        }
    }

    @Test
    public void calculSommeLesQuatreSources() {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {

            MetierMultiple metier = context.getBean("metierMultiple", MetierMultiple.class);

            assertEquals(650.0, metier.calcul(), 0.001);
        }
    }
}

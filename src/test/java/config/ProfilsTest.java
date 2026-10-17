package config;

import dao.IDao;
import metier.IMetier;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Etape 17 : le profil "prod" active daoProfilProd.
 */
public class ProfilsTest {

    @Test
    public void profilProdEnregistreLeBeanDedie() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("prod");
        context.register(AppConfig.class);
        context.refresh();

        try {
            String[] noms = context.getBeanNamesForType(IDao.class);
            assertEquals(5, noms.length);
            assertTrue(Arrays.asList(noms).contains("daoProfilProd"));

            IMetier metier = context.getBean("metier", IMetier.class);
            assertEquals(200.0, metier.calcul(), 0.001);
        } finally {
            context.close();
        }
    }

    @Test
    public void sansProfilLeBeanDedieEstAbsent() {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {

            String[] noms = context.getBeanNamesForType(IDao.class);
            assertEquals(4, noms.length);
        }
    }
}

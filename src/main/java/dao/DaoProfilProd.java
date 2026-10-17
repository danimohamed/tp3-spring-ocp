package dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Bean actif uniquement sous le profil "prod" (etape 17 du lab).
 */
@Component("daoProfilProd")
@Profile("prod")
public class DaoProfilProd implements IDao {

    @Override
    public double getValue() {
        System.out.println("[DAO] Lecture via le profil 'prod'");
        return 100.0;
    }
}

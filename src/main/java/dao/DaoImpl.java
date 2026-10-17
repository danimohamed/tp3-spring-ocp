package dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Strategie A : @Primary designe l'implementation par defaut.
 * Spring l'injectera dans MetierImpl sans que le code metier soit modifie.
 */
@Primary
@Component("dao")
public class DaoImpl implements IDao {

    @Override
    public double getValue() {
        System.out.println("[DAO] Lecture depuis la base de donnees (prod) - PRIMARY");
        return 100.0;
    }
}

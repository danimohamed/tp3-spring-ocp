package metier;

import dao.IDao;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Coeur de l'application.
 * Cette classe ne doit JAMAIS etre modifiee pour changer de source de donnees :
 * toute la logique de selection est externalisee dans la configuration (OCP).
 */
@Service("metier")
public class MetierImpl implements IMetier {

    private final IDao dao;

    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    @PostConstruct
    public void init() {
        System.out.println("[TRACE] Implementation DAO injectee : " + dao.getClass().getSimpleName());
    }

    @Override
    public double calcul() {
        return dao.getValue() * 2.0;
    }
}

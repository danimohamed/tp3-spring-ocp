package metier;

import dao.IDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Etape 20 : injection de plusieurs implementations de la meme interface.
 * Spring fournit la liste de tous les beans IDao et une map nom -> bean.
 */
@Service("metierMultiple")
public class MetierMultiple implements IMetier {

    private final List<IDao> daos;
    private final Map<String, IDao> daoMap;

    public MetierMultiple(List<IDao> daos, Map<String, IDao> daoMap) {
        this.daos = daos;
        this.daoMap = daoMap;
    }

    public List<IDao> getDaos() {
        return daos;
    }

    public Map<String, IDao> getDaoMap() {
        return daoMap;
    }

    @Override
    public double calcul() {
        return daos.stream().mapToDouble(IDao::getValue).sum();
    }
}

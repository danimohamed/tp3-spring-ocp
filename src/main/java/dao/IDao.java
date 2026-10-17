package dao;

/**
 * Contrat commun a toutes les sources de donnees.
 * C'est le point de couplage faible entre le metier et la persistance.
 */
public interface IDao {

    /**
     * Recupere une valeur numerique depuis la source de donnees.
     *
     * @return la valeur recuperee
     */
    double getValue();
}

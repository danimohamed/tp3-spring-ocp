package dao;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DaoTest {

    @Test
    public void daoImplRetourne100() {
        assertEquals(100.0, new DaoImpl().getValue(), 0.001);
    }

    @Test
    public void daoImpl2Retourne150() {
        assertEquals(150.0, new DaoImpl2().getValue(), 0.001);
    }

    @Test
    public void daoFileRetourne180() {
        assertEquals(180.0, new DaoFile().getValue(), 0.001);
    }

    @Test
    public void daoApiRetourne220() {
        assertEquals(220.0, new DaoApi().getValue(), 0.001);
    }

    @Test
    public void daoProfilProdRetourne100() {
        assertEquals(100.0, new DaoProfilProd().getValue(), 0.001);
    }
}

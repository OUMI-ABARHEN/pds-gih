package ma.uiass.eia.pds.backend.HibernateUtility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtility {
    private static EntityManager entityManager;
    public static EntityManager getEntityManger() {
        if (entityManager == null) {
            try {
                EntityManagerFactory factory = Persistence.createEntityManagerFactory("gih-backend");
                entityManager = factory.createEntityManager();
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        return entityManager;
    }
}

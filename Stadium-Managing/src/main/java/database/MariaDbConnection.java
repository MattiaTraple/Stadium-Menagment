package database;

import jakarta.persistence.*;

public class MariaDbConnection {

    private static EntityManagerFactory emf = null;
    private static EntityManager em = null;

    public synchronized static EntityManager getInstance() {

        if (em==null) {
            if (emf==null) {
                emf = Persistence.createEntityManagerFactory("CompanyMariaDbUnit");
            }
            em = emf.createEntityManager();
        }
        return em;
    }
}

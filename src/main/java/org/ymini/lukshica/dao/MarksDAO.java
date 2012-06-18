
package org.ymini.lukshica.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class MarksDAO {
    
    EntityManagerFactory emf;
    EntityManager em;

    public MarksDAO() {
       
        this.emf = Persistence.createEntityManagerFactory("jpatestPU");
        this.em = emf.createEntityManager();
    }
    public boolean addMarks(final Marks result) {
        if (result == null) {
            return false;
        }
        em.getTransaction().begin();
        em.persist(result);
        em.getTransaction().commit();
        return true;
    }

    

    
    
}

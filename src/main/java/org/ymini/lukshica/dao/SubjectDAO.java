
package org.ymini.lukshica.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class SubjectDAO {
        EntityManagerFactory emf;
        EntityManager em;
        
        public SubjectDAO() {
        
        this.emf = Persistence.createEntityManagerFactory("jpatestPU");
        this.em = emf.createEntityManager();
    }
    
    public List<Subject> getSubjectList() {
        Query query = em.createQuery("select s from Subject s");
        return query.getResultList();
    }

    public boolean addSubject(final Subject subject) {
        if (subject == null) {
            return false;
        }
        em.getTransaction().begin();
        em.persist(subject);
        em.getTransaction().commit();
        return true;
    }
    
  
    public boolean deleteSubject(final Subject subject) {
        if (subject == null) {
            return false;
        }
        em.getTransaction().begin();
        
        Subject persistSubject = em.find(Subject.class, subject.getSubjectid());
        if (persistSubject == null) {
            return false;
        } else {
            em.remove(persistSubject);            
            em.getTransaction().commit();
        }
        return true;
    }
    
    public boolean updateSubject(final Subject subject) {
        if (subject == null) {
            return false;
        }
        em.getTransaction().begin();
        
        Subject persistSubject = em.find(Subject.class, subject.getSubjectid());
        if (persistSubject == null) {
            return false;
        } else {
            persistSubject.setSubjectname(subject.getSubjectname());
            em.getTransaction().commit();
        }
        return true;
    }
    
    public List getSubjectListIDs() {
        Query query = em.createQuery("select s.subjectid from Subject s");
        return query.getResultList();
    }
    
    
}

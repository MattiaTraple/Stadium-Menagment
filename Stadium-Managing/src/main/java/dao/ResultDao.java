package dao;

import entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class ResultDao {

    public void persist(ResultDb emp) {
        EntityManager em = datasource.MariaDbJpaConnection.getInstance();
        em.getTransaction().begin();
        em.persist(emp);
        em.getTransaction().commit();
    }

    public ResultDb find(int id) {
        EntityManager em = datasource.MariaDbJpaConnection.getInstance();
        ResultDb emp = em.find(ResultDb.class, id);
        return emp;
    }

    public void update(ResultDb emp) {
        EntityManager em = datasource.MariaDbJpaConnection.getInstance();
        em.getTransaction().begin();
        em.merge(emp);
        em.getTransaction().commit();
    }

    public void delete(ResultDb emp) {
        EntityManager em = datasource.MariaDbJpaConnection.getInstance();
        em.getTransaction().begin();
        em.remove(emp);
        em.getTransaction().commit();
    }

    public List<String> getId() {
        try {
            EntityManager em = datasource.MariaDbJpaConnection.getInstance();
            Query query = em.createQuery("SELECT c.id FROM ResultDb c");
            List<String> names = query.getResultList();
            return names;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}

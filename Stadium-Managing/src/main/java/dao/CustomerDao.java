package dao;

import entity.*;
import jakarta.persistence.EntityManager;
import simu.model.Customer;

public class CustomerDao {

    public void persist(CustomerDb emp) {
        EntityManager em = datasource.MariaDbJpaConnection.getInstance();
        em.getTransaction().begin();
        em.persist(emp);
        em.getTransaction().commit();
    }

    public CustomerDb find(int id) {
        EntityManager em = datasource.MariaDbJpaConnection.getInstance();
        CustomerDb emp = em.find(CustomerDb.class, id);
        return emp;
    }

    public void update(CustomerDb emp) {
        EntityManager em = datasource.MariaDbJpaConnection.getInstance();
        em.getTransaction().begin();
        em.merge(emp);
        em.getTransaction().commit();
    }

    public void delete(CustomerDb emp) {
        EntityManager em = datasource.MariaDbJpaConnection.getInstance();
        em.getTransaction().begin();
        em.remove(emp);
        em.getTransaction().commit();
    }
}

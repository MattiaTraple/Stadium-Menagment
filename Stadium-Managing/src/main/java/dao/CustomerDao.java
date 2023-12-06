package dao;

import entity.*;
import jakarta.persistence.EntityManager;

public class CustomerDao {

    public void persist(Customer emp) {
        EntityManager em = database.MariaDbConnection.getInstance();
        em.getTransaction().begin();
        em.persist(emp);
        em.getTransaction().commit();
    }

    public Customer find(int id) {
        EntityManager em = database.MariaDbConnection.getInstance();
        Customer emp = em.find(Customer.class, id);
        return emp;
    }

    public void update(Customer emp) {
        EntityManager em = database.MariaDbConnection.getInstance();
        em.getTransaction().begin();
        em.merge(emp);
        em.getTransaction().commit();
    }

    public void delete(Customer emp) {
        EntityManager em = database.MariaDbConnection.getInstance();
        em.getTransaction().begin();
        em.remove(emp);
        em.getTransaction().commit();
    }
}

package com.mojafirma.model.dao;

import com.mojafirma.model.User;
import com.mojafirma.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class UserDao {

    public void addUser(User user) {
        Session session = HibernateUtil.getHibernateSession().getSessionFactory().openSession();

        session.beginTransaction();
        session.save(user);

        session.getTransaction().commit();
        session.close();
    }

    public User getUser(int id) {
        Session session = HibernateUtil.getHibernateSession().getSessionFactory().openSession();

        session.beginTransaction();
        User user = session.get(User.class, id);
        session.getTransaction().commit();

        session.close();

        return user;
    }

    public List<User> getUsersList() {
        Session session = HibernateUtil.getHibernateSession().getSessionFactory().openSession();

        session.beginTransaction();
        List<User> users = session.createQuery("FROM User").list();
        session.getTransaction().commit();

        session.close();

        return users;
    }

    public void deleteUser(int id) {
        Session session = HibernateUtil.getHibernateSession().getSessionFactory().openSession();

        session.beginTransaction();
        User user = session.get(User.class, id);
        session.delete(user);
        session.getTransaction().commit();

        session.close();
    }

    public void updateUser(User user) {
        Session session = HibernateUtil.getHibernateSession().getSessionFactory().openSession();

        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();

        session.close();
    }
}

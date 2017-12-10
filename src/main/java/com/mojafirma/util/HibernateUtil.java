package com.mojafirma.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

    private final static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    private static Session session = sessionFactory.openSession();

    private HibernateUtil() { };

    public static Session getHibernateSession() {
        if (session == null) {
            session = (Session) new HibernateUtil();

        }
        return session;
    }
}

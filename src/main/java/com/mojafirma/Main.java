package com.mojafirma;

import com.mojafirma.util.HibernateUtil;
import org.hibernate.Session;

public class Main {

    public static void main(String[] args) {

        Session session = HibernateUtil.getHibernateSession();
        session.beginTransaction();

        session.getTransaction().commit();
        session.close();
        System.exit(0);
    }
}

package com.topolski.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class DbUtil {
    private final SessionFactory sessionFactory;
    private DbUtil() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }
    private SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }
    public static Session getSession() {
        return DbUtilWrapper.INSTANCE.getSessionFactory().openSession();
    }
    private static class DbUtilWrapper {
        private static final DbUtil INSTANCE = new DbUtil();
    }
}

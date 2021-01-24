package com.sda.watherservice.backend;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class LocationService {
    void saveNewLocationNoRegion (String name, float latitude, float longitude, String country) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Location location = new Location(name, latitude, longitude, country);
        session.persist(location);

        transaction.commit();
        session.close();
    }

    void saveNewLocationRegion (String name, float latitude, float longitude, String country, String region) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Location location = new Location(name, latitude, longitude, country, region);
        session.persist(location);

        transaction.commit();
        session.close();
    }
}

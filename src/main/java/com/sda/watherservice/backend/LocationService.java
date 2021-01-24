package com.sda.watherservice.backend;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class LocationService { // todo rename to LocationRepository

    void saveNewLocationNoRegion(String name, float latitude, float longitude, String country) {
        // todo accept only a Location object as a parameter
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Location location = new Location(name, latitude, longitude, country); // todo move to a service layer
        session.persist(location);

        transaction.commit();
        session.close();
    }
}

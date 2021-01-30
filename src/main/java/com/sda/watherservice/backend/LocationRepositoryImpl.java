package com.sda.watherservice.backend;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class LocationRepositoryImpl implements LocationRepository {

    @Override
    public Location saveNewLocation(Location location) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(location);

        transaction.commit();
        session.close();
        return location;
    }
}

package com.sda.weatherservice.backend;

import com.sda.weatherservice.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

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

    @Override
    public List<Location> findAllLocations() {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Location> locations = session.createQuery("FROM Location").getResultList();

        transaction.commit();
        session.close();
        return locations;
    }
}

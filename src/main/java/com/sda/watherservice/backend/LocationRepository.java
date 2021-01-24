package com.sda.watherservice.backend;

public class LocationRepository {

    Location saveNewLocationNoRegion(Location location) {
        /*SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(location);

        transaction.commit();
        session.close();*/
        return location;
    }
}

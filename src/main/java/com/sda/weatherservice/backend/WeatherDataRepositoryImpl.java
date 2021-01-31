package com.sda.weatherservice.backend;

import com.sda.weatherservice.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class WeatherDataRepositoryImpl implements WeatherDataRepository {

    @Override
    public List<String> findAllLocationsNames() {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<String> locationList = session.createQuery("SELECT name FROM Location").getResultList();

        transaction.commit();
        session.close();
        return locationList;
    }

    @Override
    public List<WeatherData> saveNewData(List<WeatherData> datas) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        for (int i = 0; i < datas.size(); i++) {
            session.persist(datas.get(i));
        }
        transaction.commit();
        session.close();
        return null;
    }

    @Override
    public List<WeatherData> findAllWhetherData() {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<WeatherData> whetherData = session.createQuery("FROM WeatherData").getResultList();

        transaction.commit();
        session.close();

        return whetherData;
    }
}

package ru.geekbrains.thirdLesson.component;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class HibernateSessionFacManager {

    SessionFactory factory;

    @PostConstruct
    private void init() {
        factory = new Configuration().configure("config/hibernate.cfg.xml").buildSessionFactory();
    }

    public Session getSession(){
        return factory.getCurrentSession();
    }

    @PreDestroy
    private void destroy(){
        factory.close();
    }

}

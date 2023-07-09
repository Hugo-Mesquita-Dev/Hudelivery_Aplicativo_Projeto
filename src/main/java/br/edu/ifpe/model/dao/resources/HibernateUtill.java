
package br.edu.ifpe.model.dao.resources;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtill {
    
     private static HibernateUtill instance;
    private static SessionFactory sessions;

    public static HibernateUtill getInstance() {
        if (instance == null) {
            instance = new HibernateUtill();
        }
        return instance;
    }

    private HibernateUtill() {
        Configuration cfg = new Configuration().configure();
        sessions = cfg.buildSessionFactory();
    }

    public Session getSession() {
        return sessions.openSession();
    }
    
}

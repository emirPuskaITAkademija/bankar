package ba.bank;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * <li>SessionFactory</li>
 * <li>Session</li>
 */
public class SessionFactoryUtil {
    private static SessionFactory sessionFactory = null;

    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            try{
                /**
                 * Ovo je konfiguracija pomoću koje ću ja
                 * <li>1. Otvoriti konekciju na bazu</li>
                 * <li>2. Pisati SQL upite u skladu sa konfigurisanim dijalektom</li>
                 */
                Configuration configuration = new Configuration();
                configuration.configure();// -> hibernate.cfg.xml
                //local session factory objekat
                sessionFactory = configuration.buildSessionFactory();
            }catch (HibernateException exception){
                System.err.println(exception.getMessage());
            }
        }
        return  sessionFactory;
    }
}

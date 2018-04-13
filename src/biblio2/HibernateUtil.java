package biblio2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private Session currentSession;
    private Transaction currentTransaction;
    private String pathConfiguration;
    private static ServiceRegistry serviceRegistry;
    private static String mainConfiguration;

    public HibernateUtil() {
        this.pathConfiguration = mainConfiguration;
    }

    public static void setMainConfiguration() {
        mainConfiguration = "cfg\\hibernateMySQL.cfg.xml";
    }

    public static ServiceRegistry getServiceRegistry() {
        return serviceRegistry;
    }

    public String getPathConfiguration() {
        return pathConfiguration;
    }

    public void setPathConfiguration(String pathConfiguration) {
        this.pathConfiguration = pathConfiguration;
    }

    static SessionFactory getSessionFactory() {
        //Configuration configuration = new Configuration().configure(pathConfiguration);
        Configuration configuration = new Configuration().configure("cfg\\hibernateMySQL.cfg.xml");
        
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }

    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public static String getMainConfiguration() {
        return mainConfiguration;
    }

    public static void setMainConfiguration(String mainConfiguration) {
        HibernateUtil.mainConfiguration = mainConfiguration;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

}

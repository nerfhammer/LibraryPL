package biblio2;

import biblio2.FXGUI2.FXGUI2;
import java.util.Calendar;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class Biblio2 {

    public static void main(String[] args) {
        HibernateUtil hu = new HibernateUtil();
        HibernateUtil.setMainConfiguration();
        Session session = hu.openCurrentSessionwithTransaction();
        Transaction transaction = hu.getCurrentTransaction();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        ServiceRegistry serviceRegistry = HibernateUtil.getServiceRegistry();

        CzytelnikDAO czDAO = new CzytelnikDAO();

        /*        Czytelnik c1 = new Czytelnik();
        c1.setImie("Marian");
        c1.setNazwisko("Kowalski");
        
        Czytelnik c2 = new Czytelnik();
        c2.setImie("Michał");
        c2.setNazwisko("Gumienny");
        
        Ksiazka k1 = new Ksiazka();
        k1.setTytul("Jak nastroic skrzypce");
        k1.setAutor("B. Gordon");
        
        Ksiazka k2 = new Ksiazka();
        k2.setTytul("Opór na co dzień");
        k2.setAutor("O. Mowy");
        
        Ksiazka k3 = new Ksiazka();
        k3.setTytul("2 sposoby na sadzone jajko. Poradnik dla opornych");
        k3.setAutor("R. Makłowicz");
        
        Wypozyczenie w1 = new Wypozyczenie();
        w1.setCzytelnik(c2);
        w1.setKsiazka(k3);
        w1.setData_wyp(today());
        w1.setData_zwr(today());
        
        Wypozyczenie w2 = new Wypozyczenie();
        w2.setCzytelnik(c1);
        w2.setKsiazka(k3);
        w2.setData_wyp(today());
        w2.setData_zwr(today());
        
        session.save(c1);
        session.save(c2);
        session.save(k1);
        session.save(k2);
        session.save(k3);
        session.save(w1);
        session.save(w2);*/
        transaction.commit();

//      Query query = session.createSQLQuery("select name from czytelnik");
//      System.out.println(query.toString() + "kurwa mac");
        session.close();
        factory.close();
        FXGUI2.go(args);
        StandardServiceRegistryBuilder.destroy(serviceRegistry);
    }

    public static Date today() {
        Date date = Calendar.getInstance().getTime();
        return date;
    }

    /*    @Override
    public void start(Stage primaryStage) throws Exception {
    
    window = primaryStage;
    window.setTitle("Biblioteka - Michał Jakub Malinowski");
    showKsiazki = new Button("Pokaż wszystkie książki");
    showCzytelnicy = new Button("Pokaż wszystkich czytelników");
    showCzytelnicy.setOnAction(e -> showCzytelnicy());
    showWypozyczenia = new Button("Pokaz wszystkie wypozyczenia");
    
    GridPane layout = new GridPane();
    layout.add(showKsiazki, 0, 0);
    layout.add(showCzytelnicy, 1, 0);
    layout.add(showWypozyczenia, 2, 0);
    Scene scene = new Scene(layout, 1024, 768);
    
    window.setScene(scene);
    window.show();
    
    }*/

 /*    @Override
    public void start(Stage stage) throws Exception {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
}

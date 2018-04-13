package biblio2;

import java.util.List;

public class WypozyczenieDAO extends DAO<Wypozyczenie, Integer> {

    @Override
    public Wypozyczenie findById(Integer id) {
        openCurrentSession();
        Wypozyczenie w1 = (Wypozyczenie) getCurrentSession().get(Wypozyczenie.class, id);
        closeCurrentSession();
        return w1;
    }

    @Override
    public List<Wypozyczenie> findAll() {
        openCurrentSession();
        List<Wypozyczenie> listawypozyczen = (List<Wypozyczenie>) getCurrentSession().createQuery("from Wypozyczenie").list();
        closeCurrentSession();
        return listawypozyczen;
    }
}

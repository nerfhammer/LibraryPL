package biblio2;

import java.util.List;

public class KsiazkaDAO extends DAO<Ksiazka, Integer> {

    @Override
    public Ksiazka findById(Integer id) {
        openCurrentSession();
        Ksiazka k1 = (Ksiazka) getCurrentSession().get(Ksiazka.class, id);
        closeCurrentSession();
        return k1;
    }

    @Override
    public List<Ksiazka> findAll() {
        openCurrentSession();
        List<Ksiazka> listaksiazek = (List<Ksiazka>) getCurrentSession().createQuery("from Ksiazka").list();
        closeCurrentSession();
        return listaksiazek;
    }
}

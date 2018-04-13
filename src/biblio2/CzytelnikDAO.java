package biblio2;

import java.util.List;

public class CzytelnikDAO extends DAO<Czytelnik, Integer> {

    @Override
    public Czytelnik findById(Integer id) {
        openCurrentSession();
        Czytelnik c1 = (Czytelnik) getCurrentSession().get(Czytelnik.class, id);
        closeCurrentSession();
        return c1;
    }

    @Override
    public List<Czytelnik> findAll() {
        openCurrentSession();
        List<Czytelnik> listaczytelnikow = (List<Czytelnik>) getCurrentSession().createQuery("from Czytelnik").list();
        closeCurrentSession();
        return listaczytelnikow;
    }

}

package biblio2;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Czytelnik")
public class Czytelnik implements Serializable {

    @Column(name = "id_czytelnika")
    @Id
    @GeneratedValue
    private int id_czytelnika;

    @Column(name = "imie")
    private String imie;

    @Column(name = "nazwisko")
    private String nazwisko;

    @OneToMany(mappedBy = "czytelnik")
    private Collection<Wypozyczenie> wypozyczenie;

    public Czytelnik() {
    }

    public int getId_czytelnika() {
        return id_czytelnika;
    }

    public void setId_czytelnika(int id_czytelnika) {
        this.id_czytelnika = id_czytelnika;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Collection<Wypozyczenie> getWypozyczenie() {
        return wypozyczenie;
    }

    public void setWypozyczenie(Collection<Wypozyczenie> wypozyczenie) {
        this.wypozyczenie = wypozyczenie;
    }

    @Override
    public String toString() {
        return "imie=" + imie + ", nazwisko=" + nazwisko + ", wypozyczenie=" + wypozyczenie + '}';
    }

}

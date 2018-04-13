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
@Table(name = "Ksiazka")
public class Ksiazka implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_ksiazki")
    private int id;

    @Column(name = "tytul")
    private String tytul;

    @Column(name = "autor")
    private String autor;

    @Column(name = "dostepnosc")
    private boolean dostepnosc = true;

    @OneToMany(mappedBy = "ksiazka")
    private Collection<Wypozyczenie> wypozyczenia;

    public Ksiazka() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isDostepnosc() {
        return dostepnosc;
    }

    public void setDostepnosc(boolean dostepnosc) {
        this.dostepnosc = dostepnosc;
    }

    public void changeStan() {
        this.dostepnosc = !this.dostepnosc;
    }

    public Collection<Wypozyczenie> getWypozyczenia() {
        return wypozyczenia;
    }

    public void setWypozyczenia(Collection<Wypozyczenie> wypozyczenia) {
        this.wypozyczenia = wypozyczenia;
    }

    @Override
    public String toString() {
        return "Ksiazka{" + "id=" + id + ", tytul=" + tytul + ", autor=" + autor + ", dostepnosc=" + dostepnosc + ", wypozyczenia=" + wypozyczenia + '}';
    }

}

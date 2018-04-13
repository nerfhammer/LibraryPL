package biblio2;

import static biblio2.Biblio2.today;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Wypozyczenia")
public class Wypozyczenie implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_wypozyczenia")
    public int id_wypozyczenia;

    @ManyToOne
    @JoinColumn(name = "id_ksiazki")
    private Ksiazka ksiazka;

    @ManyToOne
    @JoinColumn(name = "id_czytelnika")
    private Czytelnik czytelnik;

    @Column(name = "data_wyp")
    public Date data_wyp;

    @Column(name = "data_zwr")
    public Date data_zwr;

    public Wypozyczenie() {
    }

    public int getId_wypozyczenia() {
        return id_wypozyczenia;
    }

    public void setId_wypozyczenia(int id_wypozyczenia) {
        this.id_wypozyczenia = id_wypozyczenia;
    }

    public Date getData_wyp() {
        return data_wyp;
    }

    public void setData_wyp(Date data_wyp) {
        this.data_wyp = data_wyp;
    }

    public Date getData_zwr() {
        return data_zwr;
    }

    public void setData_zwr(Date data_zwr) {
        this.data_zwr = data_zwr;
    }

    public Ksiazka getKsiazka() {
        return ksiazka;
    }

    public void setKsiazka(Ksiazka ksiazka) {
        this.ksiazka = ksiazka;
    }

    public Czytelnik getCzytelnik() {
        return czytelnik;
    }

    public void setCzytelnik(Czytelnik czytelnik) {
        this.czytelnik = czytelnik;
    }

    public void dodajWypozyczenie(Czytelnik c, Ksiazka k) {
        Wypozyczenie i = new Wypozyczenie();
        i.setData_wyp(today());
        k.changeStan();
    }

    @Override
    public String toString() {
        return "Wypozyczenie{" + "id_wypozyczenia=" + id_wypozyczenia + ", ksiazka=" + ksiazka + ", czytelnik=" + czytelnik + ", data_wyp=" + data_wyp + ", data_zwr=" + data_zwr + '}';
    }

}

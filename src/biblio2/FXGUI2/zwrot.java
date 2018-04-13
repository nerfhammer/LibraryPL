package biblio2.FXGUI2;

import static biblio2.Biblio2.today;
import static biblio2.FXGUI2.addWypozyczenie.getIdWypozyczen;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import static biblio2.FXGUI2.addWypozyczenie.lvWypozyczenie;
import biblio2.Ksiazka;
import biblio2.KsiazkaDAO;
import biblio2.Wypozyczenie;
import biblio2.WypozyczenieDAO;
import java.util.ArrayList;
import javafx.scene.control.Label;

public class zwrot {

    public static Scene show() {
        GridPane gp = new GridPane();
        Scene sc = new Scene(gp);
        Button goBack = new Button("Powrot");
        goBack.setOnAction(e -> FXGUI2.goBack());
        gp.add(goBack, 0, 0);
        
        ListView<String> lw = lvWypozyczenie(true);
        ArrayList<Integer> al = getIdWypozyczen();
        gp.add(lw, 1, 0);
        lw.setPrefSize(800, 600);
        Label l1 = new Label();
        gp.add(l1, 1, 1);
        
        
        Button zwr = new Button("Zwroc ksiazke!");
        gp.add(zwr, 2, 0);
        zwr.setOnAction(e->{
            Integer selected = al.get(lw.getSelectionModel().getSelectedIndex());
            l1.setText(zwrotKsiazki(selected));

        });

        return sc;
    }
    
    public static String zwrotKsiazki(int id_wyp){
        WypozyczenieDAO wDAO = new WypozyczenieDAO();
        KsiazkaDAO kDAO = new KsiazkaDAO();
        
     Wypozyczenie w = wDAO.findById(id_wyp);
     Ksiazka k = wDAO.findById(id_wyp).getKsiazka();
     int id_ksiazki = wDAO.findById(id_wyp).getKsiazka().getId();
        if(!k.isDostepnosc()){
          //w.setData_zwr(today());
            wDAO.delete(w);
            k.changeStan();
            kDAO.update(k);
            return "Ksiazka zwrocona pomyslnie !!!";
        }
        else return "Błąd, książka już zwrócona !!!";
    }
}
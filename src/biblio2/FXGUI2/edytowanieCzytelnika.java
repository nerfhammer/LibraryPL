package biblio2.FXGUI2;

import biblio2.Czytelnik;
import biblio2.CzytelnikDAO;
import static biblio2.FXGUI2.addWypozyczenie.getIdCzytelnikow;
import static biblio2.FXGUI2.addWypozyczenie.lvCzytelnikow;
import biblio2.Wypozyczenie;
import biblio2.WypozyczenieDAO;
import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;

public class edytowanieCzytelnika {

        public static Scene show() {
        GridPane gp = new GridPane();
        Scene sc = new Scene(gp);
        Button goBack = new Button("Powrot");
        goBack.setOnAction(e -> FXGUI2.goBack());
        gp.add(goBack, 0, 0);
        
        ListView<String> lw = lvCzytelnikow();
        ArrayList<Integer> al = getIdCzytelnikow();
        
        Button remove = new Button("Usuń!");
        gp.add(remove, 2, 0);
        remove.setOnAction(e->{
        lw.getItems().remove(lw.getSelectionModel().getSelectedIndex());
        int selected = al.get(lw.getSelectionModel().getSelectedIndex());
        usuwanieCzytelnika(selected);
        
        });
        
        gp.add(lw, 1, 0);
        
        return sc;
}

        
        public static void usuwanieCzytelnika(int selected){
            WypozyczenieDAO wDAO = new WypozyczenieDAO();
            CzytelnikDAO cDAO = new CzytelnikDAO();
            ArrayList<Wypozyczenie> a = (ArrayList<Wypozyczenie>) wDAO.findAll();
            
            for (int i = 0; i<a.size(); i++){
                if(a.get(i).getCzytelnik().getId_czytelnika()==selected){
                    Wypozyczenie w = a.get(i);
                    wDAO.delete(w);
                }
            }
            Czytelnik c = cDAO.findById(selected);
            cDAO.delete(c);
        }
}

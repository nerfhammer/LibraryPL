package biblio2.FXGUI2;

import biblio2.Ksiazka;
import biblio2.KsiazkaDAO;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;

public class usuwanieKsiazki {

        public static Scene show() {
        GridPane gp = new GridPane();
        Scene sc = new Scene(gp);
        Button goBack = new Button("Powrot");
        goBack.setOnAction(e -> FXGUI2.goBack());
        gp.add(goBack, 0, 0);
        
        ListView<String> lw = lvKsiazek();
        ArrayList<Integer> al = getIdKsiazek();
        gp.add(lw, 1, 0);
        lw.setPrefSize(500, 600);
        Label l1 = new Label();
        gp.add(l1, 1, 1);
        
        Button zwr = new Button("Usun ksiazke z bazy");
        gp.add(zwr, 2, 0);
        
        zwr.setOnAction(e-> {
            int selected = al.get(lw.getSelectionModel().getSelectedIndex());
            System.out.println("selected: " + selected);
            l1.setText(usuwanieKsiazki(selected));
        });
        
        return sc;
        }
        
        public static String usuwanieKsiazki(int id_ksiazki){
            
            KsiazkaDAO ksDAO = new KsiazkaDAO();
            Ksiazka k = ksDAO.findById(id_ksiazki);
            if(k!=null&&k.isDostepnosc()) {ksDAO.delete(k);
            return "Ksiazke usunieto pomyslnie!";
        }
            else return "Ksiazki nie da sie usunac!";
        }
        
            public static ListView<String> lvKsiazek() {
        int ilosc = getIdKsiazek().size();
        ArrayList<Integer> a = getIdKsiazek();
        ListView<String> lv = new ListView<>();
        ArrayList<String> arr = new ArrayList<>();
        KsiazkaDAO k = new KsiazkaDAO();
        ArrayList<Ksiazka> ks = (ArrayList<Ksiazka>) k.findAll();

        for (int i = 0; i < ilosc; i++) {
            arr.add(ks.get(i).getAutor() + " - " + ks.get(i).getTytul());
            //arr.add(k.findById(a.get(i)).getAutor() + " - " + k.findById(a.get(i)).getTytul());
        }
        lv.getItems().addAll(arr);
        return lv;
    }

    public static ArrayList<Integer> getIdKsiazek() {

        KsiazkaDAO wDAO = new KsiazkaDAO();
        List<Ksiazka> intlist = new ArrayList<>();
        intlist.addAll(wDAO.findAll());
        ArrayList<Integer> id = new ArrayList<>();
        for (int i = 0; i < intlist.size(); i++) {
            id.add(intlist.get(i).getId());
        }
        return id;
    }
        
}

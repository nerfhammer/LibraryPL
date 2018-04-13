package biblio2.FXGUI2;

import static biblio2.Biblio2.today;
import biblio2.Czytelnik;
import biblio2.CzytelnikDAO;
import biblio2.Ksiazka;
import biblio2.KsiazkaDAO;
import biblio2.Wypozyczenie;
import biblio2.WypozyczenieDAO;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.GridPane;

public class addWypozyczenie {
 
    public static Scene show() {
        GridPane gp = new GridPane();
        Scene sc = new Scene(gp);
        Button goBack = new Button("Powrot");
        goBack.setOnAction(e -> FXGUI2.goBack());
        gp.add(goBack, 0, 0);

        ListView<String> lk = lvKsiazek();
        lk.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        lk.setPrefSize(400, 500);
        gp.add(lk, 2, 0);
        
        ListView<String> lc = lvCzytelnikow();
        lc.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        gp.add(lc, 1, 0);
        
        Button submit = new Button("Wypozycz ksiazke!");
        Label l1 = new Label();
        //l1.setText(lk.getSelectionModel().getSelectedItem() + "      " + lc.getSelectionModel().getSelectedItem());
        
        submit.setOnAction(e->{
                ArrayList<Integer> ks = getIdKsiazek();
                ArrayList<Integer> cz = getIdCzytelnikow();
                l1.setText(dodajWypozyczenie(cz.get(lc.getSelectionModel().getSelectedIndex()),ks.get(lk.getSelectionModel().getSelectedIndex())));
              //System.out.println("Usunieto ksiazke z listy: " +lk.getItems().remove(lk.getSelectionModel().getSelectedIndex()));
        });
        
        gp.add(submit, 3, 0);
        gp.add(l1, 2, 1);

        return sc;
    }

        public static String dodajWypozyczenie(int i1, int i2) {

        CzytelnikDAO czytDAO = new CzytelnikDAO();
        KsiazkaDAO ksDAO = new KsiazkaDAO();
        WypozyczenieDAO wypDAO = new WypozyczenieDAO();

        Czytelnik c = czytDAO.findById(i1);
        Ksiazka k = ksDAO.findById(i2);

        if (k.isDostepnosc()) {
            Wypozyczenie w = new Wypozyczenie();
            w.setCzytelnik(c);
            w.setKsiazka(k);
            w.setData_wyp(today());
            k.setDostepnosc(false);
            ksDAO.update(k);
            wypDAO.save(w);
            return "Wypozyczenie dodane pomyslnie!";
        } else {
            return "Ksiazka nie jest dostepna!";
        }
    }
    
    public static ListView<String> lvWypozyczenie(boolean aktualne) {
        int ilosc = getIdWypozyczen().size();
        ArrayList<Integer> a = getIdWypozyczen();
        ListView<String> lv = new ListView<>();
        ArrayList<String> arr = new ArrayList<>();
        WypozyczenieDAO wDAO = new WypozyczenieDAO();
        ArrayList<Wypozyczenie> w = (ArrayList<Wypozyczenie>) wDAO.findAll();
        if(aktualne){
        for (int i = 0; i < ilosc; i++) {
            if(w.get(i).data_zwr == null)arr.add(w.get(i).data_wyp.toString() + " Czytelnik/czytelniczka "+w.get(i).getCzytelnik().getImie() + " " + w.get(i).getCzytelnik().getNazwisko() + " Wypozyczyl(a): " + w.get(i).getKsiazka().getTytul());
         // arr.add(wDAO.findById(a.get(i)).getCzytelnik().getImie() + " " + wDAO.findById(a.get(i)).getCzytelnik().getNazwisko() + " Wypozyczyl(a) " + wDAO.findById(a.get(i)).getKsiazka().getTytul());
        }}
        else{
        for (int i = 0; i < ilosc; i++) {
            if(w.get(i).data_zwr != null)arr.add(w.get(i).data_wyp.toString() + " Czytelnik/czytelniczka "+w.get(i).getCzytelnik().getImie() + " " + w.get(i).getCzytelnik().getNazwisko() + " Wypozyczyl(a): " + w.get(i).getKsiazka().getTytul());
         // arr.add(wDAO.findById(a.get(i)).getCzytelnik().getImie() + " " + wDAO.findById(a.get(i)).getCzytelnik().getNazwisko() + " Wypozyczyl(a) " + wDAO.findById(a.get(i)).getKsiazka().getTytul());
        }
        
        }
        lv.getItems().addAll(arr);
        return lv;
    }

    public static ArrayList<Integer> getIdWypozyczen() {

        WypozyczenieDAO wDAO = new WypozyczenieDAO();
        List<Wypozyczenie> intlist = new ArrayList<>();
        intlist.addAll(wDAO.findAll());
        ArrayList<Integer> idwypozyczen = new ArrayList<>();
        for (int i = 0; i < intlist.size(); i++) {
            idwypozyczen.add(intlist.get(i).id_wypozyczenia);
        }
        return idwypozyczen;
    }

    public static ListView<String> lvKsiazek() {
        int ilosc = getIdKsiazek().size();
        ArrayList<Integer> a = getIdKsiazek();
        ListView<String> lv = new ListView<>();
        ArrayList<String> arr = new ArrayList<>();
        KsiazkaDAO k = new KsiazkaDAO();
        ArrayList<Ksiazka> ks = (ArrayList<Ksiazka>) k.findAll();

        for (int i = 0; i < ilosc; i++) {
            if(ks.get(i).isDostepnosc())arr.add(ks.get(i).getAutor() + " - " + ks.get(i).getTytul());
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

    public static ListView<String> lvCzytelnikow() {
        int ilosc = getIdCzytelnikow().size();
        ArrayList<Integer> a = getIdCzytelnikow();
        ListView<String> lv = new ListView<>();
        ArrayList<String> arr = new ArrayList<>();
        CzytelnikDAO k = new CzytelnikDAO();
        ArrayList<Czytelnik> cz = (ArrayList<Czytelnik>) k.findAll();
        for (int i = 0; i < ilosc; i++) {
            arr.add(cz.get(i).getImie() + " " + cz.get(i).getNazwisko());
        //    arr.add(k.findById(a.get(i)).getImie() + " " + k.findById(a.get(i)).getNazwisko());
        }
        lv.getItems().addAll(arr);
        return lv;
    }

    public static ArrayList<Integer> getIdCzytelnikow() {

        CzytelnikDAO wDAO = new CzytelnikDAO();
        List<Czytelnik> intlist = new ArrayList<>();
        intlist.addAll(wDAO.findAll());
        ArrayList<Integer> id = new ArrayList<>();
        for (int i = 0; i < intlist.size(); i++) {
            id.add(intlist.get(i).getId_czytelnika());
        }
        return id;
    }
}
package biblio2.FXGUI2;

import biblio2.Wypozyczenie;
import biblio2.WypozyczenieDAO;
import java.util.List;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class showWypozyczenia {
    
    public static Scene show() {
        GridPane gp = new GridPane();
        Scene pokazCzytelnikow = new Scene(gp);
        Button goBack = new Button("Powrot");
        gp.add(goBack, 0, 0);
        goBack.setOnAction(e -> FXGUI2.goBack());
        Label label = new Label();
        label.setText(showWypozyczenia());
        gp.add(label, 0, 1);
        
        /*        String [][] w = showWyp();
        
        for (int i = 0; i<showWyp().length; i++){
        Label l = new Label();
        l.setText(w[i][0]);
        gp.add(l, (i+1), 0);
        }*/

        return pokazCzytelnikow;
    }
    
        private static String showWypozyczenia() {

        StringBuilder sb = new StringBuilder();
        WypozyczenieDAO wd = new WypozyczenieDAO();
        List<Wypozyczenie> l = wd.findAll();

        for (int i = 0; i < l.size(); i++) {

           // if (l.get(i).data_zwr == null) {
                sb.append(l.get(i).getId_wypozyczenia()).append(". ").append("ID ksiazki: ").append(l.get(i).getKsiazka().getId()).append(" ID czytelnika: ")
                        .append(l.get(i).getCzytelnik().getId_czytelnika()).append("           ").append(l.get(i).getCzytelnik().getImie()).append(" ")
                        .append(l.get(i).getCzytelnik().getNazwisko()).append(" Wypozyczyl(a) ").append(l.get(i).getKsiazka().getTytul()).append(" - ")
                        .append(l.get(i).getKsiazka().getAutor()).append("\n");
           // }
        }
        return sb.toString();

    }
        
/*        private static String [][] showWyp(){
            WypozyczenieDAO wyDAO = new WypozyczenieDAO();            
            String[][] w = new String[wyDAO.findAll().size()][4];

            for(int i = 0; i<wyDAO.findAll().size(); i++){
                w[i][0] = wyDAO.findById(i).getCzytelnik().toString();
                w[i][1] = wyDAO.findById(i).getKsiazka().toString();
                w[i][2] = wyDAO.findById(i).data_wyp.toString();
                w[i][3] = wyDAO.findById(i).data_zwr.toString();
            }
            return w;
        } */
    
}

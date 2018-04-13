package biblio2.FXGUI2;

import biblio2.Ksiazka;
import biblio2.KsiazkaDAO;
import java.util.List;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class showKsiazki {

    public static Scene show() {
        GridPane gp = new GridPane();
        Scene pokazCzytelnikow = new Scene(gp);
        Button goBack = new Button("Powrot");
        gp.add(goBack, 0, 0);
        goBack.setOnAction(e -> FXGUI2.goBack());
        Label label = new Label();
        label.setText(showKsiazki());
        gp.add(label, 0, 1);

        return pokazCzytelnikow;
    }

    private static String showKsiazki() {
        StringBuilder sb = new StringBuilder();
        KsiazkaDAO ks = new KsiazkaDAO();
        List<Ksiazka> l = ks.findAll();

        for (int i = 0; i < l.size(); i++) {
            if (l.get(i).isDostepnosc()) {
                sb.append(l.get(i).getId()).append(". ").append(l.get(i).getAutor()).append(" - ").append(l.get(i).getTytul()).append("\n");
            }
        }
        return sb.toString();
    }

}

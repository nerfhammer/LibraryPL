package biblio2.FXGUI2;

import biblio2.Czytelnik;
import biblio2.CzytelnikDAO;
import java.util.List;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class pokazCzytelnik {

    
    public static Scene show(){
        GridPane gp = new GridPane();
        Scene pokazCzytelnikow = new Scene(gp);
        Button goBack = new Button("Powrot");
        gp.add(goBack, 0, 0);
        goBack.setOnAction(e-> FXGUI2.goBack() );
        Label label = new Label();
        label.setText(showCzytelnicy());
        gp.add(label, 0, 1);

        return pokazCzytelnikow;
    }
    
        private static String showCzytelnicy() {
        CzytelnikDAO cz = new CzytelnikDAO();
        List<Czytelnik> l = cz.findAll();     
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < l.size(); i++) {
            sb.append(l.get(i).getId_czytelnika()).append(". ").append(l.get(i).getImie()).append(" ").append(l.get(i).getNazwisko()).append("\n");
        }
        return sb.toString();
    }
}

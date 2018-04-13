package biblio2.FXGUI2;

import biblio2.Ksiazka;
import biblio2.KsiazkaDAO;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class addKsiazka {

    public static Scene show() {
        GridPane gp = new GridPane();
        Scene pokazCzytelnikow = new Scene(gp);
        Button goBack = new Button("Powrot");
        gp.add(goBack, 0, 0);
        goBack.setOnAction(e -> FXGUI2.goBack());
        Label l1 = new Label();
        Label l2 = new Label();
        Label msg = new Label();
        l1.setText("Podaj Autora");
        l2.setText("Podaj tytul");
        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        Button submit = new Button("Dodaj!");
        msg.setPrefWidth(150);
        
        submit.setOnAction(e->{
                msg.setText(dodajKsiazke(tf1.getText(), tf2.getText()));
                tf1.clear();
                tf2.clear();
        });
        
        gp.add(l1, 0, 1);
        gp.add(l2, 0, 2);
        gp.add(msg, 1, 3);
        gp.add(tf1, 1, 1);
        gp.add(tf2, 1, 2);
        gp.add(submit, 2, 3);

        return pokazCzytelnikow;
    }

    public static String dodajKsiazke(String autor, String tytul) {
        if (autor.isEmpty() || tytul.isEmpty()) {
            return "Brak autora lub tytulu!";
        } else {
            Ksiazka k = new Ksiazka();
            k.setAutor(autor);
            k.setTytul(tytul);
            KsiazkaDAO dodaj = new KsiazkaDAO();
            dodaj.save(k);
        }
        return "Ksiazke dodano pomyslnie";
    }
}

package biblio2.FXGUI2;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class menu {

    public static Scene menu() {
        GridPane pane = new GridPane();
        Scene menu = new Scene(pane);
        
        Button pokazKsiazki = new Button("Pokaz dostepne ksiazki");
        Button pokazCzytelnikow = new Button("pokaz wszystkich czytelnikow");
        Button pokazWypozyczenia = new Button("Pokaz wszystkie wypozyczenia");
        Button dodajKsiazke = new Button("Dodaj ksiazke do bazy");
        Button dodajCzytelnika = new Button("Dodaj czytelnika do bazy");
        Button dodajWypozyczenie = new Button("Dodaj wypozyczenie");
        Button usunKsiazke = new Button("Usun ksiazke");
        Button usunCzytelnika = new Button("Usun czytelnika");
        Button zwrocKsiazke = new Button("Zwroc ksiazke");

        pokazCzytelnikow.setPrefSize(200, 50);
        pokazKsiazki.setPrefSize(200, 50);
        pokazWypozyczenia.setPrefSize(200, 50);
        dodajCzytelnika.setPrefSize(200, 50);
        dodajKsiazke.setPrefSize(200, 50);
        dodajWypozyczenie.setPrefSize(200, 50);
        zwrocKsiazke.setPrefSize(200, 50);
        usunKsiazke.setPrefSize(200, 50);
        usunCzytelnika.setPrefSize(200, 50);

        pokazCzytelnikow.setOnAction(e-> FXGUI2.setScene(pokazCzytelnik.show()));
        pokazKsiazki.setOnAction(e-> FXGUI2.setScene(showKsiazki.show()));
        pokazWypozyczenia.setOnAction(e-> FXGUI2.setScene(showWypozyczenia.show()));
        dodajKsiazke.setOnAction(e-> FXGUI2.setScene(addKsiazka.show()));
        dodajCzytelnika.setOnAction(e-> FXGUI2.setScene(addCzytelnik.show()));
        dodajWypozyczenie.setOnAction(e-> FXGUI2.setScene(addWypozyczenie.show()));
        zwrocKsiazke.setOnAction(e-> FXGUI2.setScene(zwrot.show()));
        usunKsiazke.setOnAction(e-> FXGUI2.setScene(usuwanieKsiazki.show()));
        usunCzytelnika.setOnAction(e-> FXGUI2.setScene(edytowanieCzytelnika.show()));
        
        pane.setGridLinesVisible(true);
        pane.add(pokazKsiazki, 0, 0);
        pane.add(pokazCzytelnikow, 0, 1);
        pane.add(pokazWypozyczenia, 0, 2);
        pane.add(dodajKsiazke, 1, 0);
        pane.add(dodajCzytelnika, 1, 1);
        pane.add(dodajWypozyczenie, 1, 2);
        pane.add(usunKsiazke, 2, 0);
        pane.add(usunCzytelnika, 2, 1);
        pane.add(zwrocKsiazke, 2, 2);

        return menu;
    }
}

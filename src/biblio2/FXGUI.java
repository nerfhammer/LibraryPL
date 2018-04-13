package biblio2;

import static biblio2.Biblio2.today;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class FXGUI extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Stage window;
        window = stage;

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });

        Button showKsiazki, showCzytelnicy, showWypozyczenia, goBack, dodajCzytelnika, dodajKsiazke, dodajWypozyczenie, goBack2, goBack3, goBack4, goBack5, dodaj, dodajK, dodajW, zwrocKsiazke = new Button(), zwrot = new Button();
        Label dodajCzLabel1 = new Label(), dodajCzLabel2 = new Label(), dodajKsLabel1 = new Label(),
                dodajKsLabel2 = new Label(), confirmation = new Label(), confirmation2 = new Label(),
                confirmation3 = new Label(), dodajWLabel1 = new Label(), dodajWLabel2 = new Label(), zwrotKsiazki = new Label(), confirmation4 = new Label();

        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        TextField tf3 = new TextField();
        TextField tf4 = new TextField();
        TextField tf5 = new TextField();
        TextField tf6 = new TextField();
        TextField tf7 = new TextField();

        goBack = new Button("Powrot do menu glownego");
        goBack2 = new Button("Powrot do menu glownego");
        goBack3 = new Button("Powrot do menu glownego");
        goBack4 = new Button("Powrot do menu glownego");
        goBack5 = new Button("Powrot do menu glownego");
        dodaj = new Button("Dodaj czytelnika");
        dodajK = new Button("Dodaj ksiazke");
        dodajW = new Button("Dodaj wypozyczenie");
        zwrot = new Button("Zwroc ksiazke");
        //  zwrotKsiazki.setText("Zwroc Ksiazke");

        GridPane pane = new GridPane();
        GridPane menuglowne = new GridPane();
        GridPane dodajCz = new GridPane();
        GridPane dodajKs = new GridPane();
        GridPane dodajWyp = new GridPane();
        GridPane zwrocKs = new GridPane();

        Scene menu = new Scene(menuglowne);
        Scene popupShow = new Scene(pane);
        Scene dCz = new Scene(dodajCz);
        Scene dKs = new Scene(dodajKs);
        Scene dWyp = new Scene(dodajWyp);
        Scene zKs = new Scene(zwrocKs);

        dodajCz.add(goBack2, 0, 1);
        dodajKs.add(goBack3, 0, 0);
        dodajWyp.add(goBack4, 0, 0);
        zwrocKs.add(goBack5, 0, 1);

        pane.setMaxHeight(1000);
        pane.add(goBack, 0, 0);
        Label label = new Label();
        label.autosize();
        pane.add(label, 0, 1);

        goBack.setOnAction(e1 -> window.setScene(menu));
        goBack2.setOnAction(e2 -> window.setScene(menu));
        goBack3.setOnAction(e3 -> window.setScene(menu));
        goBack4.setOnAction(e4 -> window.setScene(menu));
        goBack5.setOnAction(e15 -> window.setScene(menu));

        window.setTitle("Biblioteka - Michał Jakub Malinowski");

        showKsiazki = new Button("Pokaż dostepne książki");
        showKsiazki.setOnAction(e5 -> {
            label.setText(showKsiazki());
            window.setScene(popupShow);
        });
        showCzytelnicy = new Button("Pokaż wszystkich czytelników");
        showCzytelnicy.setOnAction(e6 -> {
            label.setText(showCzytelnicy());
            window.setScene(popupShow);
        });
        showWypozyczenia = new Button("Pokaz wszystkie wypozyczenia");
        showWypozyczenia.setOnAction(e7 -> {
            label.setText(showWypozyczenia());
            window.setScene(popupShow);
        });

        dodajCzLabel1.setText("Podaj imie czytelnika");
        dodajCz.add(dodajCzLabel1, 0, 2);
        dodajCzLabel2.setText("Podaj nazwisko czytelnika");
        dodajCz.add(dodajCzLabel2, 0, 3);
        dodajCz.add(tf1, 1, 2);
        dodajCz.add(tf2, 1, 3);
        dodajCz.add(dodaj, 1, 4);
        dodajCz.add(confirmation, 0, 4);

        dodajCzytelnika = new Button("Dodaj Czytelnika do bazy");
        dodajCzytelnika.setOnAction(e8 -> {

            dodaj.setOnAction(e9 -> {
                if (dodajCzytelnika(tf1.getText(), tf2.getText())) {
                    confirmation.setText("Dodano pomyslnie!");
                } else {
                    confirmation.setText("Nie wpisales imienia lub nazwiska!");
                }
                tf1.clear();
                tf2.clear();
            });
            window.setScene(dCz);

        });

        dodajKsLabel1.setText("Podaj imie i nazwisko autora");
        dodajKsLabel2.setText("Podaj tytul ksiazki");
        dodajKs.add(dodajKsLabel1, 0, 2);
        dodajKs.add(dodajKsLabel2, 0, 3);
        dodajKs.add(tf3, 1, 2);
        dodajKs.add(tf4, 1, 3);
        dodajKs.add(dodajK, 1, 4);
        dodajKs.add(confirmation2, 0, 4);

        dodajKsiazke = new Button("Dodaj Ksiazke do bazy");
        dodajKsiazke.setOnAction(e9 -> {
            window.setScene(dKs);
            dodajK.setOnAction(e10 -> {
                confirmation2.setText(dodajKsiazke(tf3.getText(), tf4.getText()));
                tf3.clear();
                tf4.clear();
            });
        });

        ListView<Ksiazka> listViewKsiazka = new ListView();
              VBox listViewKsiazkaVBox = new VBox(15);
             Scene listViewKsiazkaScene = new Scene(listViewKsiazkaVBox);
              ListView<String> listViewCzytelnik = new ListView();
              VBox listViewCzytelnikVBox = new VBox(15);
             Scene listViewCzytelnikScene = new Scene(listViewCzytelnikVBox);
        dodajWLabel1.setText("Podaj NUMER czytelnika");
        dodajWLabel2.setText("Podaj NUMER ksiazki");
        dodajWyp.add(dodajWLabel1, 0, 2);
        dodajWyp.add(dodajWLabel2, 0, 3);
        dodajWyp.add(tf5, 1, 2);
        dodajWyp.add(tf6, 1, 3);
        dodajWyp.add(dodajW, 1, 4);
        dodajWyp.add(confirmation3, 0, 4);

            CzytelnikDAO czyDAO = new CzytelnikDAO(); 
             KsiazkaDAO ksiDAO = new KsiazkaDAO();
             WypozyczenieDAO wypoDAO = new WypozyczenieDAO();
            ArrayList czytelnikList = new ArrayList();
            czytelnikList = (ArrayList) czyDAO.findAll();
            ArrayList ksiazkaList = new ArrayList();
            ksiazkaList = (ArrayList) ksiDAO.findAll();
            Button submitKsiazka = new Button("Wybierz ksiazke");
            Button submitCzytelnik = new Button("Wybierz wypozyczenie");
            listViewCzytelnikVBox.getChildren().addAll(listViewCzytelnik, submitCzytelnik);
            listViewKsiazkaVBox.getChildren().addAll(listViewKsiazka, submitKsiazka);
            Button chooseKsiazkaButton = new Button("Wybierz ksiazke");
            dodajWyp.add(chooseKsiazkaButton, 2, 3);
            ObservableList<String> olc;
            listViewCzytelnik.getItems();            
            chooseKsiazkaButton.setOnAction(e20->{
            window.setScene(listViewCzytelnikScene);

           listViewCzytelnik.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
           });
            
             Button chooseCzytelnikButton = new Button("Wybierz czytelnika");
            dodajWyp.add(chooseCzytelnikButton, 2, 2);
           chooseCzytelnikButton.setOnAction(e21->{});
             Label chooseKsiazkaLabel = new Label();
            Label chooseCzytelnikLabel = new Label();
            dodajWyp.add(chooseKsiazkaLabel, 3, 3);
             dodajWyp.add(chooseCzytelnikLabel, 3, 2);
        dodajWypozyczenie = new Button("Wypozycz ksiazke");
        dodajWypozyczenie.setOnAction(e11 -> {
            window.setScene(dWyp);
            dodajW.setOnAction(e12 -> {
                confirmation3.setText(dodajWypozyczenie(tf5.getText(), tf6.getText()));
            });
        });

        zwrotKsiazki.setText("Podaj numer wypozyczenia");
        zwrocKs.add(zwrotKsiazki, 0, 2);
        zwrocKs.add(tf7, 1, 2);
        zwrocKs.add(zwrot, 1, 3);
        zwrocKs.add(confirmation4, 0, 3);

        showCzytelnicy.setPrefSize(200, 50);
        showKsiazki.setPrefSize(200, 50);
        showWypozyczenia.setPrefSize(200, 50);
        dodajCzytelnika.setPrefSize(200, 50);
        dodajKsiazke.setPrefSize(200, 50);
        dodajWypozyczenie.setPrefSize(200, 50);
        zwrocKsiazke.setPrefSize(200, 50);

        menuglowne.add(showKsiazki, 1, 0);
        menuglowne.add(showCzytelnicy, 0, 0);
        menuglowne.add(showWypozyczenia, 2, 0);
        menuglowne.add(dodajCzytelnika, 0, 1);
        menuglowne.add(dodajKsiazke, 1, 1);
        menuglowne.add(dodajWypozyczenie, 2, 1);
        // menuglowne.add(zwrocKsiazke, 0, 2);

        window.setScene(menu);
        window.show();

    }

    /*    public static int chooseKsiazka(){
    
    return 0;
    }*/
    
    private String[] listCzytelnicy(){
        CzytelnikDAO cz = new CzytelnikDAO();
        List<Czytelnik> l = cz.findAll();            
        String [] czytelnicyString = new String[l.size()];
        int x = 0;
        l.forEach((i) -> {
            czytelnicyString[i.getId_czytelnika()-1] = i.getImie() + i.getNazwisko();
        });
        return czytelnicyString;
    }
    
    private String showCzytelnicy() {
            CzytelnikDAO cz = new CzytelnikDAO();
        List<Czytelnik> l = cz.findAll();     

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < l.size(); i++) {
            sb.append(l.get(i).getId_czytelnika()).append(". ").append(l.get(i).getImie()).append(" ").append(l.get(i).getNazwisko()).append("\n");
        }
        return sb.toString();
    }

    private String showKsiazki() {
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

    private String showWypozyczenia() {

        StringBuilder sb = new StringBuilder();
        WypozyczenieDAO wd = new WypozyczenieDAO();
        List<Wypozyczenie> l = wd.findAll();

        for (int i = 0; i < l.size(); i++) {

            if (l.get(i).data_zwr == null) {
                sb.append(l.get(i).getId_wypozyczenia()).append(". ").append("ID ksiazki: ").append(l.get(i).getKsiazka().getId()).append(" ID czytelnika: ")
                        .append(l.get(i).getCzytelnik().getId_czytelnika()).append("           ").append(l.get(i).getCzytelnik().getImie()).append(" ")
                        .append(l.get(i).getCzytelnik().getNazwisko()).append(" Wypozyczyl(a) ").append(l.get(i).getKsiazka().getTytul()).append(" - ")
                        .append(l.get(i).getKsiazka().getAutor()).append("\n");
            }
        }
        return sb.toString();

    }

    public static void go(String[] args) {
        launch(args);
    }

    public static boolean dodajCzytelnika(String imie, String nazwisko) {
        if (imie.isEmpty() || nazwisko.isEmpty()) {
            return false;
        } else {
            Czytelnik c = new Czytelnik();
            c.setImie(imie);
            c.setNazwisko(nazwisko);
            CzytelnikDAO dodaj = new CzytelnikDAO();
            dodaj.save(c);
        }
        return true;
    }

    public String dodajKsiazke(String autor, String tytul) {
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

    public static String dodajWypozyczenie(String czytelnik, String ksiazka) {
        int i1 = Integer.parseInt(czytelnik);
        int i2 = Integer.parseInt(ksiazka);

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

    public static String zwrocKsiazke(String numer) {
        int i = Integer.parseInt(numer);
        WypozyczenieDAO wypDAO = new WypozyczenieDAO();
        KsiazkaDAO ksDAO = new KsiazkaDAO();
        Wypozyczenie w = wypDAO.findById(i);
        if (w.data_zwr == null) {
            w.data_zwr = today();
            Ksiazka k = ksDAO.findById(w.getKsiazka().getId());
            k.setDostepnosc(true);
            ksDAO.save(k);
            wypDAO.save(w);
            return "Ksiazka zwrocona!";
        } else {
            return "Zly numer wypozyczenia!";
        }
    }
}

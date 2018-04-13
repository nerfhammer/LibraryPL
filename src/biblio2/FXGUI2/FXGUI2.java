package biblio2.FXGUI2;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class FXGUI2 extends Application {
        static Stage window;
    @Override
    public void start(Stage stage) throws Exception {
        window = stage;

        stage.setOnCloseRequest((WindowEvent t) -> {
            Platform.exit();
            System.exit(0);
        });
        window.setScene(menu.menu());
        window.show();
    }
    public static void go(String[] args) {
    launch(args);
    }
    
    public static void goBack(){
        window.setScene(menu.menu());
    }
    
    public static void setScene(Scene s){
        window.setScene(s);
    }
}

import javafx.application.Application;
import javafx.stage.Stage;

public class Connexion extends Application {
    @Override

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Formulaire de connexion utilisateur");
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
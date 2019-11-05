import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class Inscription extends Application {
    @Override

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Formulaire d'inscription");
        primaryStage.show();
    }

    private GridPane  creationVoletFormulaireInscription(){

        GridPane gridPane = new GridPane();  // On instancie un nouveau volet de grille

        gridPane.setAlignment(Pos.CENTER); // On positionne le volet au centre de l'écran, à la fois verticalement et horizontalement

        gridPane.setPadding(new Insets(40, 40, 40, 40));     // On définit un padding de 20px de chaque coté

        gridPane.setHgap(10); // On définit l'espace horizontal entre les colonnes

        gridPane.setVgap(10); // On définit l'écart vertical entre les lignes

        // On ajoute des contraintes de colonne

        //columnOneConstaints sera appliqué à tous les noeuds placés dans la première colonne.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        // columnTwoConstraints sera appliqué à tous les noeuds placés dans la deuxième colonne.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Registration Form JavaFX Application");


        GridPane gridPane = creationVoletFormulaireInscription();// Créer le volet de formulaire d'inscription

        Scene scene = new Scene(gridPane, 800, 500);
        // Set the scene in primary stage
        primaryStage.setScene(scene);

        primaryStage.show();
    }

}
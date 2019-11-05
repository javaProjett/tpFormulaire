
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Window;

import java.util.prefs.Preferences;

public class Connexion {

    private Inscription inscription;
    private Group root;

    private TextField champLogin;
    private PasswordField champMotDePasse;

    Preferences preferences;

    public Connexion(Inscription inscription, Group root) {
        this.inscription = inscription;
        this.root = root;
    }

    // Méthode pour confirmer le login, en statique, pour tester avec mon prénom et un mot de passe à 4 chiffres
    private void login(ActionEvent event){
        if(champLogin.getText().equals("mehdi") && champMotDePasse.getText().equals("1234")) {
            preferences.put("login", champLogin.getText());
            preferences.put("mot de passe", champMotDePasse.getText());
        }
        else {
            System.out.println("Mot de passe invalide");
        }
    }
    private GridPane creationVoletFormulaireConnexion() {

        GridPane gridPane = new GridPane();  // On instancie un nouveau volet de grille

        gridPane.setAlignment(Pos.CENTER); // On positionne le volet au centre de l'écran, à la fois verticalement et horizontalement


        gridPane.setPadding(new Insets(40, 40, 40, 40)); // On définit un padding de 20px de chaque coté

        gridPane.setHgap(10);  // On définit l'espace horizontal entre les colonnes


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

    private void addUIControls(GridPane gridPane) {
        // On ajoute l'entête
        Label headerLabel = new Label("Formulaire de connexion");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

        // On ajoute un label pour le login
        Label labelLogin = new Label("Login : ");
        gridPane.add(labelLogin, 0,1);

        // On ajoute un champ texte pour le login
        TextField champLogin = new TextField();
        champLogin.setPrefHeight(40);
        gridPane.add(champLogin, 1,1);

        // On ajoute un label pour le mot de passe
        Label labelMotDePasse  = new Label("Mot de passe : ");
        gridPane.add(labelMotDePasse, 0, 2);

        // On ajoute un champ texte pour le mot de passe
        PasswordField champMotDePasse = new PasswordField();
        champMotDePasse.setPrefHeight(40);
        gridPane.add(champMotDePasse, 1, 2);


        // On ajoute un bouton qui efface les saisie de l'utilisateur
        Button boutonEffacer = new Button("Effacer les champs" +
                "");
        boutonEffacer.setPrefHeight(40);
        boutonEffacer.setDefaultButton(true);
        boutonEffacer.setPrefWidth(150);
        gridPane.add(boutonEffacer, 0, 7, 35, 1);
        GridPane.setHalignment(boutonEffacer, HPos.LEFT);
        GridPane.setMargin(boutonEffacer, new Insets(20, 0,20,0));


        // On ajoute un bouton connexion
        Button boutonValider = new Button("Connexion" +
                "");
        boutonValider.setPrefHeight(40);
        boutonValider.setDefaultButton(true);
        boutonValider.setPrefWidth(150);
        gridPane.add(boutonValider, 0, 7, 2, 1);
        GridPane.setHalignment(boutonValider, HPos.RIGHT);
        GridPane.setMargin(boutonValider, new Insets(20, 0,20,0));

        boutonValider.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(champLogin.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Erreur !", "Saisissez votre login");
                    return;
                }
                if(champMotDePasse.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Saisissez votre mot de passe");
                    return;
                }

                showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Inscription réussi", "Bienvenue " + champLogin.getText());
            }
        });
    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

}

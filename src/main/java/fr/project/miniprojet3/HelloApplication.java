package fr.project.miniprojet3;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
//vue
/**

 La classe HelloApplication étend la classe Application de JavaFX et représente l'application de démonstration.

 Elle est responsable de la création et de l'affichage de la fenêtre principale de l'application.
 */
public class HelloApplication extends Application {
    public Scene scene ;
    /**

     La méthode start() est appelée lors du démarrage de l'application et crée la fenêtre principale
     de l'application en chargeant le fichier de vue hello-view.fxml à l'aide de la classe FXMLLoader.
     @param stage la fenêtre principale de l'application
     @throws IOException si une erreur se produit lors du chargement du fichier de vue
     */
    @Override
    public void start(Stage stage) throws IOException {
        Button restartButton = new Button("Relancer l'application");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 800, 800);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }


    /**

     La méthode main() est la méthode principale de l'application et est appelée au lancement de l'application.
     @param args les arguments passés à l'application
     */
    public static void main(String[] args) {
        launch();
    }
}
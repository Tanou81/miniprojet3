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
public class HelloApplication extends Application {
    public Scene scene ;
    @Override
    public void start(Stage stage) throws IOException {
        Button restartButton = new Button("Relancer l'application");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 800, 800);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    /*@FXML
    protected void onHelloButtonClick() throws IOException {
        //welcomeText.setText("number of point is :  "+ point);
        //this = new HelloController();
        // HelloApplication l = new HelloApplication();
        System.out.println("click ");
        scene.setRoot((FXMLLoader.load(getClass().getResource("hello-view.fxml"))));
    }*/

    public static void main(String[] args) {
        launch();
    }
}
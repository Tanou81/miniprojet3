package fr.project.miniprojet3;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

//controleur
public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private ImageView monImage;

    private Image imageDos = new Image("C:\\Users\\natha\\IdeaProjects\\miniprojet3\\src\\main\\mesImages\\dos.JPEG");


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void imageClicked(MouseEvent event){
        monImage =  (ImageView) event.getSource();
        String id = monImage.getId();
        System.out.println("Clicked "+ monImage );
        System.out.println("Clicked "+ id);
        if (id.equals("roi")){

            System.out.println(" is roi");
            System.out.println(monImage.getImage());
            Image image = monImage.getImage();
            String imageUrl = image.getUrl();

            System.out.println("Image URL: " + imageUrl);

            monImage.setImage(imageDos);
        }else if (id.equals("dos")){
            System.out.println(" is dos");
            System.out.println(monImage.getImage());
            Image image = monImage.getImage();
            String imageUrl = image.getUrl();

            System.out.println("Image URL: " + imageUrl);
        }


    }
    public void initalise (){

    }
}
package fr.project.miniprojet3;

import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.util.Duration;
//controleur
public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private ImageView monImage;
    //C:\Users\natha\IdeaProjects\miniprojet3\src\main\mesImages\roi.png
    //"C:\Users\natha\IdeaProjects\miniprojet3\src\main\mesImages\dame.png"
    private List<Carte> cartes = new ArrayList<>(); // supposons que vous avez une liste de carts


    private int nbCLick = 0;
    private ArrayList<ImageView> listeImage = new ArrayList<ImageView>();
    private Image imageDos = new Image("C:\\Users\\natha\\IdeaProjects\\miniprojet3\\src\\main\\mesImages\\dos.JPEG");

    private int point = 0 ;
    private ArrayList<Carte> listeImage2 = new ArrayList<Carte>();
    private Carte roi ;
    private Carte dame ;
    private Carte dos  ;
    private Carte valet  ;
    private Carte roib ;
    private Carte dameb ;
    private Carte valetb  ;
    private Model model ;
    public HelloController(){
       //this.model = new Model(this);
        /*this.roi = this.model.getRoi();
        this.dame = this.model.getDame();
        this.valet = this.model.getValet();
        this.dos = this.model.getDos();*/
        this.dos = new Carte("dos", "C:\\Users\\natha\\IdeaProjects\\miniprojet3\\src\\main\\mesImages\\dos.JPEG", this , "dos1");

        this.roi = new Carte("roi", "C:\\Users\\natha\\IdeaProjects\\miniprojet3\\src\\main\\mesImages\\roi.PNG",  this, "roi1" );
        this.dame = new Carte("dame", "C:\\Users\\natha\\IdeaProjects\\miniprojet3\\src\\main\\mesImages\\dame.PNG",  this, "dame1");
        this.valet = new Carte("valet", "C:\\Users\\natha\\IdeaProjects\\miniprojet3\\src\\main\\mesImages\\valet.PNG",  this, "valet1");


        this.roib = new Carte("roi", "C:\\Users\\natha\\IdeaProjects\\miniprojet3\\src\\main\\mesImages\\roi.PNG",  this, "roi2" );
        this.dameb = new Carte("dame", "C:\\Users\\natha\\IdeaProjects\\miniprojet3\\src\\main\\mesImages\\dame.PNG",  this, "dame2");
        this.valetb = new Carte("valet", "C:\\Users\\natha\\IdeaProjects\\miniprojet3\\src\\main\\mesImages\\valet.PNG",  this, "valet2");
        //this.dos = new Carte("dos", "C:\\Users\\natha\\IdeaProjects\\miniprojet3\\src\\main\\mesImages\\dos.JPEG", this , "dos2");
        this.cartes.add(this.dameb);

        this.cartes.add(this.roi);
        this.cartes.add(this.valet);
        this.cartes.add(this.dame);

        this.cartes.add(this.roib);
        this.cartes.add(this.valetb);

        //this.cartes.add(this.roi);
        /*this.cartes.add(this.dame);
        this.cartes.add(this.valet);*/

    }

    public void initialize() {
        System.out.println("intialise of : "+this.cartes.size()+ " "+this.cartes.get(0));
        initializeTimer(); // appel de la fonction initializeTimer()

        for (Carte carte : cartes) {
            ImageView imageView = new ImageView(new Image(carte.getUrl())); // supposons que votre objet Carte possède une méthode "getUrlImage" qui renvoie l'URL de l'image de la carte
            cardsContainer.getChildren().add(carte.getMyimageVieux());

        }
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("nombre de point is : "+ point);
    }

    public void imageClicked(MouseEvent event) {

        monImage = (ImageView) event.getSource();
        String id = monImage.getId();
        System.out.println("Clicked " + monImage);
        System.out.println("Clicked " + id + " "+ nbCLick);
        nbCLick += 1;
        listeImage.add(monImage);
        if (nbCLick<3) {
            if (id.equals("roi1") || id.equals("roi2")) {
                listeImage2.add(id.equals("roi1") ? this.roi : this.roib);
                System.out.println(" is roi");
                System.out.println(monImage.getImage());
                Image image = monImage.getImage();
                String imageUrl = image.getUrl();

                System.out.println("Image URL: " + imageUrl + " " + this.roi.getMyimage().getUrl() + " " + this.roi.getMyimage());

                monImage.setImage(this.roi.getMyimage());

            } else if (id.equals("dame1") || id.equals("dame2")) {
                listeImage2.add(id.equals("dame1") ? this.dame : this.dameb);

                System.out.println(" is dame "+ listeImage2.toString());
                System.out.println(monImage.getImage());
                Image image = monImage.getImage();
                String imageUrl = image.getUrl();
                //listeImage.add(image);

                System.out.println("Image URL: " + imageUrl);
                monImage.setImage(this.dame.getMyimage());


            } else if (id.equals("valet1") || id.equals("valet2")) {
                listeImage2.add(id.equals("valet1") ? this.valet : this.valetb);

                System.out.println(" is valet ");
                System.out.println(monImage.getImage());
                Image image = monImage.getImage();
                String imageUrl = image.getUrl();
                //listeImage.add(image);

                System.out.println("Image URL: " + imageUrl);
                monImage.setImage(this.valet.getMyimage());


            }


            if (nbCLick == 2) {

                isWin();
                restartGameTime();

            }
        }
    }

    public void restartGameTime() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                resetCards();
            }
        }, 1000);
    }

    private void resetCards() {
        System.out.println(" taille liste image 2 "+ listeImage.size());
        nbCLick = 0 ;
        for (int i = 0; i < listeImage.size(); i++) {

            Image image = listeImage.get(i).getImage();
            System.out.println(" taille liste image 2 "+ listeImage.get(i).getImage());
            String imageUrl = image.getUrl();
            listeImage.get(i).setImage(imageDos);
        }
        listeImage.clear();
        listeImage2.clear();

    }






    public void isWin(){
        Carte c0 = listeImage2.get(0);
        Carte c1 = listeImage2.get(1);
        if (c1.getNom() == c0.getNom()){
            point +=1 ;
            System.out.println("wen ? "+ c0.getNom()+ " "+ c1.getNom() + " " + point);
            welcomeText.setText("nombre de point is : "+ point);
            deleteCarte(c0,c1);



        }
    }

public void deleteCarte( Carte c0, Carte c1 ){
        while (true ) {
            if (cartes.contains(c0) && cartes.contains(c1)) {
                System.out.println("equald is " + c0.equals(c1));
                //for (int j = 0 ; j<cartes.size();j++) {
                for (int i = 0; i < cartes.size(); i++) {
                    System.out.println("carte is " + cartes.get(i) + " " + c1);
                    if (cartes.get(i) == c0) {
                        try {
                            System.out.println("carte is ok 1" + cartes.get(i));
                            cartes.remove(i);
                            System.out.println("remove is " + cartes.get(i));
                            this.clear();
                        }catch (Exception e){
                            System.out.println("error is " );
                            }
                        deleteCarte(c0,c1);
                    } else if (cartes.get(i) == c1) {
                        try {
                            System.out.println("carte is ok 2" + cartes.get(i));
                            cartes.remove(i);
                            System.out.println("remove is " + cartes.get(i));
                            this.clear();
                        }catch (Exception e){
                            System.out.println("error is " );
                        }
                        deleteCarte(c0,c1);
                    }
                }
                // }
            } else {
                break;
            }
        }
}

    //---------------------------------------------------------Timer---------------------------------------------
    @FXML
    private Label welcomeText1;

    private Timeline timeline;
    private int timeSeconds = 0;



    @FXML
    private HBox cardsContainer;

    // initialiser le timer
    private void initializeTimer() {
        System.out.println("intialise2");
        // Créer la timeline pour mettre à jour le timer toutes les secondes
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            //System.out.println("intialise3");
            timeSeconds++;
            welcomeText1.setText("Time elapsed: " + timeSeconds + " seconds");
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        startTimer();


    }

    // Démarrer le timer
    public void startTimer() {
        timeline.play();
    }

    // Arrêter le timer
    public void stopTimer() {
        timeline.stop();
    }

    public void clear(){
        cardsContainer.getChildren().clear();
        for (Carte carte : cartes) {
            ImageView imageView = new ImageView(new Image(carte.getUrl())); // supposons que votre objet Carte possède une méthode "getUrlImage" qui renvoie l'URL de l'image de la carte
            cardsContainer.getChildren().add(carte.getMyimageVieux());

        }
    }
}
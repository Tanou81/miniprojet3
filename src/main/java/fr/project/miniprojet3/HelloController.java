package fr.project.miniprojet3;

import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.*;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
//controleur
public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private ImageView monImage;
    @FXML
    private VBox root;
    @FXML
    private Label welcomeText1;
    @FXML
    private HBox cardsContainer;

    private List<Carte> cartes = new ArrayList<>(); // supposons que vous avez une liste de carts

    private int nbCLick = 0;

    private int point = 0 ;
    private ArrayList<Carte> ListeCarte = new ArrayList<Carte>();
    private Timeline timeline;
    private int timeSeconds = 0;

    private Carte roi ;
    private Carte dame ;
    private Carte dos  ;
    private Carte valet  ;
    private Carte roib ;
    private Carte dameb ;
    private Carte valetb  ;
    /**

     Le contrôleur HelloController crée six cartes et les ajoute à une liste de cartes.

     Les cartes sont créées en utilisant des images situées dans un répertoire spécifique.

     Les cartes sont mélangées de manière aléatoire à la fin de la création.
     */
    public HelloController(){


        this.roi = new Carte("roi", "C:\\Users\\natha\\IdeaProjects\\miniprojet3\\src\\main\\mesImages\\roi.PNG",  this, "roi1" );
        this.dame = new Carte("dame", "C:\\Users\\natha\\IdeaProjects\\miniprojet3\\src\\main\\mesImages\\dame.PNG",  this, "dame1");
        this.valet = new Carte("valet", "C:\\Users\\natha\\IdeaProjects\\miniprojet3\\src\\main\\mesImages\\valet.PNG",  this, "valet1");

        this.roib = new Carte("roi", "C:\\Users\\natha\\IdeaProjects\\miniprojet3\\src\\main\\mesImages\\roi.PNG",  this, "roi2" );
        this.dameb = new Carte("dame", "C:\\Users\\natha\\IdeaProjects\\miniprojet3\\src\\main\\mesImages\\dame.PNG",  this, "dame2");
        this.valetb = new Carte("valet", "C:\\Users\\natha\\IdeaProjects\\miniprojet3\\src\\main\\mesImages\\valet.PNG",  this, "valet2");

        this.cartes.add(this.dameb);

        this.cartes.add(this.roi);
        this.cartes.add(this.valet);
        this.cartes.add(this.dame);

        this.cartes.add(this.roib);
        this.cartes.add(this.valetb);
        // Mélanger les cartes de manière aléatoire
        Collections.shuffle(cartes);


    }
    /**
     Cette méthode initialise le jeu en affichant la taille de la liste de cartes et la première carte dans la console.
     Elle appelle également la fonction initializeTimer() pour initialiser le chronomètre du jeu.
     Ensuite, pour chaque carte dans la liste de cartes, elle crée une ImageView contenant l'image de la carte à partir de son URL, puis l'ajoute à un conteneur de cartes.
     @param Aucun paramètre n'est nécessaire pour cette méthode.
     @return Cette méthode ne retourne aucune valeur.
     */
    public void initialize() {
        System.out.println("intialise of : "+this.cartes.size()+ " "+this.cartes.get(0));
        initializeTimer(); // appel de la fonction initializeTimer()

        for (Carte carte : cartes) {
            ImageView imageView = new ImageView(new Image(carte.getUrl())); // supposons que votre objet Carte possède une méthode "getUrlImage" qui renvoie l'URL de l'image de la carte
            cardsContainer.getChildren().add(carte.getMyimageVieux());

        }
    }

    /**
     Cette méthode est associée à l'événement de clic sur un bouton "Hello". Lorsque ce bouton est cliqué, cette méthode appelle la méthode "reload()" pour recharger les données de l'application.
     @exception Exception est levée si une erreur se produit lors de l'exécution de la méthode "reload()".
     @param Aucun paramètre n'est nécessaire pour cette méthode.
     @return Cette méthode ne retourne aucune valeur.
     */
    @FXML
    protected void onHelloButtonClick() throws  Exception{
        reload();
    }

    /**
     Cette méthode recharge la vue principale de l'application. Elle crée une nouvelle scène à partir du fichier FXML "hello-view.fxml" et la définit comme racine de la scène actuelle.
     Si une exception est levée lors de la tentative de rechargement de la vue, un message d'erreur est affiché dans la console.
     @throws Exception si une exception est levée lors de la tentative de rechargement de la vue principale.
     @return Cette méthode ne retourne aucune valeur.
     */
    public  void reload() throws Exception{
        try {
            Scene scene = root.getScene();
            scene.setRoot(FXMLLoader.load(this.getClass().getResource("hello-view.fxml")));
        }catch ( Exception e ){
            System.out.println("error"+e);
        }

    }


    /**

     Cette méthode est appelée lorsqu'une image est cliquée. Elle vérifie le nombre de clics effectués sur l'image, ainsi que l'identifiant de l'image.
     Si l'identifiant correspond à une carte dans la liste des cartes, la carte est ajoutée à une liste de cartes sélectionnées. Si deux cartes ont été sélectionnées, la méthode redémarre le chronomètre du jeu et vérifie si les deux cartes sélectionnées correspondent. Si elles correspondent, le joueur a gagné la partie.
     @param event Un événement de souris qui contient des informations sur l'événement de clic.
     @return Cette méthode ne retourne aucune valeur.
     */
    public void imageClicked(MouseEvent event) {

        monImage = (ImageView) event.getSource();
        String id = monImage.getId();
        System.out.println("Clicked " + monImage);
        System.out.println("Clicked " + id + " "+ nbCLick);
        nbCLick += 1;

        String id2 = "";
        if (ListeCarte.size()>0) {
            id2 = ListeCarte.get(0).getId();
            if(id2==id) {
                nbCLick = 1;
            }
        }
        if (nbCLick<3 && id2!=id  ) {
            if (id.equals("roi1") || id.equals("roi2")) {
                ListeCarte.add(id.equals("roi1") ? this.roi : this.roib);
                System.out.println(" is roi");
                System.out.println(monImage.getImage());
                Image image = monImage.getImage();
                String imageUrl = image.getUrl();

                System.out.println("Image URL: " + imageUrl + " " + this.roi.getMyimage().getUrl() + " " + this.roi.getMyimage());

                monImage.setImage(this.roi.getMyimage());

            } else if (id.equals("dame1") || id.equals("dame2")) {
                ListeCarte.add(id.equals("dame1") ? this.dame : this.dameb);

                System.out.println(" is dame "+ ListeCarte.toString());
                System.out.println(monImage.getImage());
                Image image = monImage.getImage();
                String imageUrl = image.getUrl();


                System.out.println("Image URL: " + imageUrl);
                monImage.setImage(this.dame.getMyimage());


            } else if (id.equals("valet1") || id.equals("valet2")) {
                ListeCarte.add(id.equals("valet1") ? this.valet : this.valetb);

                System.out.println(" is valet ");
                System.out.println(monImage.getImage());
                Image image = monImage.getImage();
                String imageUrl = image.getUrl();


                System.out.println("Image URL: " + imageUrl);
                monImage.setImage(this.valet.getMyimage());


            }

            if (nbCLick == 2) {
                restartGameTime();
                isWin();
            }
        }
    }
    /**
     Cette méthode appel  la méthode resetCards() après une seconde de délai.
     La méthode resetCards() réinitialise le nombre de clics à zéro et remet toutes les cartes dans leur état initial.
     @param Aucun paramètre n'est nécessaire pour cette méthode.
     @return Cette méthode ne retourne aucune valeur.
     */
    public void restartGameTime() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                resetCards();
            }
        }, 1000);
    }
    /**
     Cette méthode réinitialise le nombre de clics à zéro et remet toutes les cartes dans leur état initial.
     Elle parcourt la liste de cartes et appelle la méthode setMyImage() pour chacune d'entre elles.
     Enfin, elle vide la liste de cartes pour les prochains cliques
     @param Aucun paramètre n'est nécessaire pour cette méthode.
     @return Cette méthode ne retourne aucune valeur.
     */
    private void resetCards() {
        nbCLick = 0 ;
        for (int i = 0; i < ListeCarte.size(); i++) {
            ListeCarte.get(i).setMyImage();
        }
        ListeCarte.clear();
    }


    /**
     Cette méthode vérifie si les deux premières cartes de la liste de cartes ont le même nom. Si c'est le cas, elle ajoute un point au score, affiche le score et supprime les deux cartes de la liste.
     Si toutes les cartes ont été supprimées de la liste, elle affiche "IS WINNER" dans le texte d'accueil.
     @param Aucun paramètre n'est nécessaire pour cette méthode.
     @return Cette méthode ne retourne aucune valeur.
     */
    public void isWin(){
        Carte c0 = ListeCarte.get(0);
        Carte c1 = ListeCarte.get(1);
        if (c1.getNom() == c0.getNom()){
            point +=1 ;
            System.out.println("wen ? "+ c0.getNom()+ " "+ c1.getNom() + " " + point);
            welcomeText.setText("number of point is : "+ point);
            deleteCarte(c0,c1);


        }
        if (this.cartes.size()==0){
            System.out.println("is WINNER ");
            welcomeText.setText("IS WINNER !!!!!!!!!!!!!!!!!!!!");
        }
    }

    /**

     Cette méthode permet de supprimer deux cartes du jeu. Elle effectue une boucle infinie tant que l'une ou les deux cartes sont présentes dans la liste de cartes.
     Elle vérifie si les cartes c0 et c1 sont présentes dans la liste, puis parcourt la liste pour trouver chaque carte et la supprimer en utilisant la méthode remove().
     Si une carte ne peut pas être supprimée, la méthode appelle récursivement deleteCarte(c0, c1) pour essayer de supprimer à nouveau les cartes.
     Si les deux cartes ont été supprimées avec succès, la méthode appelle clear() pour réinitialiser le jeu.
     @param c0 : La première carte à supprimer du jeu.
     @param c1 : La deuxième carte à supprimer du jeu.
     @return Cette méthode ne retourne aucune valeur.
     */
    public void deleteCarte( Carte c0, Carte c1 ){

        while (true ) {
            System.out.println("delete carte"+ cartes.contains(c0) + " "+ cartes.contains(c1));
            if (cartes.contains(c0) || cartes.contains(c1)) {

                System.out.println("equald is " + c0.equals(c1));
                //for (int j = 0 ; j<cartes.size();j++) {
                for (int i = 0; i < cartes.size(); i++) {
                    //System.out.println("carte is " + cartes.get(i) + " " + c1);
                    if (cartes.get(i) == c0) {

                        try {
                            System.out.println("carte is ok 1" + cartes.get(i)+ " "+ c0.toString());
                            cartes.remove(i);
                            System.out.println("remove is " + cartes.get(i));

                        }catch (Exception e){
                            this.deleteCarte(c0,c1);
                            System.out.println("errorrrrrrrrrrr!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! is " +e  );
                        }


                    } else if (cartes.get(i) == c1) {

                        try {
                            System.out.println("carte is ok 2" + cartes.get(i)+ " "+ c1.toString());
                            cartes.remove(i);
                            System.out.println("remove is " + cartes.get(i)  );
                            //this.clear();
                        }catch (Exception e){
                            this.deleteCarte(c0,c1);
                            System.out.println("errorrrrrrrrrrr!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! is " + e );
                        }


                    }
                }
                // }
            } else {
                this.clear();
                break;
            }
        }
    }



    //---------------------------------------------------------Timer---------------------------------------------


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
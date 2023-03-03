package fr.project.miniprojet3;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.Objects;
/**

 La classe Carte représente une carte de jeu. Elle possède un identifiant unique, une valeur et une image associée.
 Cette classe est utilisée pour construire le jeu
 */
public class Carte {
    private String  nom  ;

    private HelloController helloController;
    private String  urlDos ="C:\\Users\\natha\\IdeaProjects\\miniprojet3\\src\\main\\mesImages\\dos.JPEG"  ;
    private Image myimageFace ;
    private Image myimagedos ;
    private ImageView myimageVieux ;
    //private Image imageDos = new Image();
    private Boolean isDo ;
    private String urlFace ;
    private String id ;


    /**
     * Constructeur de la classe Carte.
     *
     * @param nom              Le nom de la carte.
     * @param url              L'URL de l'image de la carte.
     * @param helloController  Le contrôleur de la vue.
     * @param id               L'identifiant de la carte.
     */
    public Carte(String nom , String url,HelloController helloController, String  id ){
        this.nom  = nom  ;
        this.urlFace = url;
        this.myimageFace = new Image(url);
        this.myimagedos = new Image(urlDos);
        this.isDo = true;
        this.myimageVieux = new ImageView(this.myimagedos);
        this.id = id ;
        this.setImage();
        this.helloController = helloController;

    }

    /**
     * Constructeur de la classe Carte.
     *
     * @param nom              Le nom de la carte.
     * @param url              L'URL de l'image de la carte.
     * @param helloController  Le contrôleur de la vue.
     */
    public Carte(String nom , String url, HelloController helloController){
        this.nom  = nom  ;
        this.urlFace = url;
        this.myimageFace = new Image(url);
        this.myimagedos = new Image(urlDos);
        this.isDo = true;
        this.myimageVieux = new ImageView(this.myimagedos);
        this.id = "" ;
        this.setImage();
        this.helloController = helloController;

    }

    /**
     Getter pour le nom de la carte.
     @return nom de la carte
     */
    public String getNom() {
        return nom;
    }
    /**
     Getter pour l'URL de l'image de la carte.
     @return URL de l'image de la carte
     */
    public String getUrl() {
        return urlFace;
    }
    /**

     Getter pour l'image de la carte.
     @return image de la carte
     */
    public Image getMyimage(){
        return myimageFace;
    }

    /**

     Getter pour la vue de l'image de la carte.
     @return vue de l'image de la carte
     */
    public ImageView getMyimageVieux(){
        return  this.myimageVieux;
    }
    /**

     Configure l'image de la carte.
     */
    public void setImage(){
        this.myimageVieux.setFitWidth(100);
        this.myimageVieux.setFitHeight(150.0  );
        this.myimageVieux.setId( this.id);
        this.myimageVieux.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                helloController.imageClicked(event);
            }
        });
        //this.myimageVieux.getOnMouseClicked();
    }
    /**

     Configure l'image de la carte.et change en dos
     */
    public void setMyImage(){
        System.out.println("ici man ");
        this.myimageVieux.setImage(this.myimagedos);
    }
    /**

     Setter pour l'URL de l'image de la carte.
     */
    public void setUrl() {

    }
    /**

     Vérifie si la carte est égale à un autre objet.
     @param o l'objet à comparer
     @return true si la carte est égale à l'objet, false sinon
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carte carte = (Carte) o;
        return Objects.equals(nom, carte.nom) &&
                Objects.equals(urlFace, carte.urlFace) &&
                Objects.equals(id, carte.id);
    }
    /**

     Calcule le code de hachage de la carte.
     @return le code de hachage de la carte
     */
    @Override
    public int hashCode() {
        return Objects.hash(nom, urlFace, id);
    }
    /**

     Overrides the default toString method to provide a String representation of the Carte object.
     @return a String representation of the Carte object, including its name, image URL, isDo boolean value, and ID
     */
    @Override
    public String toString() {
        return "Carte{" +
                "nom='" + nom + '\'' +
                ", urlFace='" + urlFace + '\'' +
                ", isDo=" + isDo +
                ", id='" + id + '\'' +
                '}';
    }
    /**

     Returns the ID of the Carte object.
     @return the ID of the Carte object as a String
     */
    public String getId(){
        return this.id;
    }


}

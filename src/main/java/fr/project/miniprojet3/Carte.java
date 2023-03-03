package fr.project.miniprojet3;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.Objects;

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


    public String getNom() {
        return nom;
    }

    public String getUrl() {
        return urlFace;
    }

    public Image getMyimage(){
        return myimageFace;
    }


    public ImageView getMyimageVieux(){
        return  this.myimageVieux;
    }

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
    public void setMyImage(){
        System.out.println("ici man ");
        this.myimageVieux.setImage(this.myimagedos);
    }

    public void setUrl() {

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carte carte = (Carte) o;
        return Objects.equals(nom, carte.nom) &&
                Objects.equals(urlFace, carte.urlFace) &&
                Objects.equals(id, carte.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, urlFace, id);
    }

    @Override
    public String toString() {
        return "Carte{" +
                "nom='" + nom + '\'' +
                ", urlFace='" + urlFace + '\'' +
                ", isDo=" + isDo +
                ", id='" + id + '\'' +
                '}';
    }

    public String getId(){
        return this.id;
    }


}

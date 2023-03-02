package fr.project.miniprojet3;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Carte {
    private String  nom  ;
    private String  url   ;
    private Image myimage ;
    private ImageView myimageVieux ;

    public Carte(String nom , String url){
        this.nom  = nom  ;
        this.url = url;
        this.myimage = new Image(url);
        this.myimageVieux = new ImageView(this.myimage);
    }

    public String getNom() {
        return nom;
    }

    public String getUrl() {
        return url;
    }

    public Image getMyimage(){
        return myimage;
    }


    public ImageView getMyimageVieux(){
        return  this.myimageVieux;
    }


}

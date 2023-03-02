package fr.project.miniprojet3;

public class Model {
    private int score ;
    private int temps ;

    private Carte roi ;
    private Carte dame ;
    private Carte dos  ;
    private Carte valet  ;

    /*a les données
    donne objet metier
    de cartes et la logique pour vérifier si
les cartes sont assorties ou non*/
    public Model(){
        this.roi = new Carte("roi", "C:\\Users\\natha\\IdeaProjects\\miniprojet3\\src\\main\\mesImages\\roi.PNG");
        this.dame = new Carte("dame", "C:\\Users\\natha\\IdeaProjects\\miniprojet3\\src\\main\\mesImages\\dame.PNG");
        this.valet = new Carte("dame", "C:\\Users\\natha\\IdeaProjects\\miniprojet3\\src\\main\\mesImages\\valet.PNG");
        this.dos = new Carte("dos", "C:\\Users\\natha\\IdeaProjects\\miniprojet3\\src\\main\\mesImages\\dos.JPEG");
    }

    public Carte getDame() {
        return dame;
    }

    public Carte getDos() {
        return dos;
    }

    public Carte getValet() {
        return valet;
    }

    public Carte getRoi() {
        return roi;
    }



}

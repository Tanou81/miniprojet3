package fr.project.miniprojet3;

public class Model {
    private int score ;
    private int temps ;
    private HelloController helloController;
    private Carte roi ;
    private Carte dame ;
    private Carte dos  ;
    private Carte valet  ;

    /*a les données
    donne objet metier
    de cartes et la logique pour vérifier si
les cartes sont assorties ou non*/
    public Model(HelloController helloController){
        this.helloController =  helloController;
        this.roi = new Carte("roi", "C:\\Users\\natha\\IdeaProjects\\miniprojet3\\src\\main\\mesImages\\roi.PNG",  this.helloController, "roi1" );
        this.dame = new Carte("dame", "C:\\Users\\natha\\IdeaProjects\\miniprojet3\\src\\main\\mesImages\\dame.PNG",  this.helloController, "dame1");
        this.valet = new Carte("dame", "C:\\Users\\natha\\IdeaProjects\\miniprojet3\\src\\main\\mesImages\\valet.PNG",  this.helloController, "valet1");
        this.dos = new Carte("dos", "C:\\Users\\natha\\IdeaProjects\\miniprojet3\\src\\main\\mesImages\\dos.JPEG", this.helloController , "dos1");
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

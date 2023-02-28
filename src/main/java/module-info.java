module fr.project.miniprojet3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.project.miniprojet3 to javafx.fxml;
    exports fr.project.miniprojet3;
}
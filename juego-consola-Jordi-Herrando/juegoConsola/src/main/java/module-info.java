module com.example.juegoconsola {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.juegoconsola to javafx.fxml;
    exports com.example.juegoconsola;
}
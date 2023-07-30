module com.emilianoacevedo.calculadorajavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.emilianoacevedo.calculadorajavafx to javafx.fxml;
    exports com.emilianoacevedo.calculadorajavafx;
}
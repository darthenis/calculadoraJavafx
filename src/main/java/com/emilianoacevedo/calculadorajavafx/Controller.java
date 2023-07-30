package com.emilianoacevedo.calculadorajavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField textField;

    @FXML
    void addValue(ActionEvent event) {
        textField.setText(textField.getText() + ((Button)event.getSource()).getText());
    }

    @FXML
    void deleteAll(){
        textField.setText("");
    }
}

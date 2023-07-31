package com.emilianoacevedo.calculadorajavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.controlsfx.control.action.Action;


public class Controller {

    private final Service service;

    @FXML
    private Label textField;

    public Controller(){
        this.service = new Service(new Model());
    }

    @FXML
    void addValue(ActionEvent event) {
        String value = ((Button)event.getSource()).getText();
        service.addValue(value);
        this.updateText();
    }

    @FXML
    void deleteAll(){
        service.deleteAll();
        this.updateText();
    }

    @FXML
    void delete(){
        service.delete();
        this.updateText();
    }

    @FXML
    void operation(ActionEvent actionEvent){
        String symbol = ((Button)actionEvent.getSource()).getText();
        service.addSymbol(symbol);
        this.updateText();
    }

    @FXML
    void getResult(){
        service.getResult();
        updateText();
    }

    private void updateText(){
        textField.setText(service.getValue());
    }
}

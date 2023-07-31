package com.emilianoacevedo.calculadorajavafx;

public class Service {


    public Service(Model model){
        this.model = model;
    }

    private Model model;

    public void addValue(String value){
        model.addValue(value);
    }

    public void deleteAll(){
        model.deleteAll();
    }

    public void delete(){
        model.delete();
    }

    public String getValue(){
        return model.getValue();
    }

    //OPERATIONS

    public void addSymbol(String symbol){
        model.addSymbol(symbol);
    }

    public void getResult(){
        model.result();
    }
}

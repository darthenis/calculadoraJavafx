package com.emilianoacevedo.calculadorajavafx;

import javafx.scene.layout.VBox;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Model extends VBox {

    private String value = "0";

    private List<String> operation = new ArrayList<>();

    public Model(){}

    public void addValue(String value){
        if(this.value.equals("0")) {
            this.value = "";
        } if(!this.value.contains(".") || !value.equals(".")){
            if(this.value.equals("") && value.equals(".")){
                this.value = "0.";
            } else {
                    this.value = this.value + value;
            }
        }

    }

    public void deleteAll(){
        this.value = "0";
    }

    public void delete(){
        if(this.value.length() == 1){
            this.value = "0";
        } else {
            //agregar borrado de operations
            System.out.println(this.operation.toString());
            String last = this.value.substring(this.value.length() - 2, this.value.length() - 1);
            if(this.operation.get(this.operation.size() - 1).equals(last)){
                this.operation.remove(this.operation.size() - 1);
            }
            this.value = this.value.substring(0, this.value.length() - 1);
        }

    }

    public void addSymbol(String symbol) {
        if(!this.value.equals("0")){
            if(this.operation.isEmpty()){
                this.operation.add(this.value);
            }else{
                String value = String.join("", this.operation);
                this.operation.add(this.value.substring(value.length()));
            }
            this.value = this.value + symbol;
            this.operation.add(symbol);
        }
    }

    public void result(){
        double total = 0;
        String operation = "";
        int index = this.value.lastIndexOf(this.operation.get(this.operation.size() - 1));
        this.operation.add(this.value.substring(index+1));

        for(String element : this.operation){
            switch (element){
                case "+":
                    operation = "+";
                    break;
                case "-":
                    operation = "-";
                    break;
                case "x":
                    operation = "x";
                    break;
                case "/":
                    operation = "/";
                    break;
                case "%":
                    operation = "%";
                    break;
                default:
                    switch(operation) {
                        case "+":
                            total = total + Double.parseDouble(element);
                            break;
                        case "-":
                            total = total - Double.parseDouble(element);
                            break;
                        case "x":
                            total = total * Double.parseDouble(element);
                            break;
                        case "/":
                            total = total / Double.parseDouble(element);
                            break;
                        case "%":
                            total = (total / 100) * Double.parseDouble(element);
                            break;
                        case "":
                            total = Double.parseDouble(element);
                            break;
                    }
            }
        }
        DecimalFormat format = new DecimalFormat("0.#");
        this.value = String.valueOf(format.format(total));
        this.operation.clear();
    }

    String getValue(){
        return this.value;
    }
}

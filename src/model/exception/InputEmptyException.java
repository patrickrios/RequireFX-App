package model.exception;

import javafx.scene.control.TextField;

public class InputEmptyException extends Exception{
    private TextField clone;
    public InputEmptyException(TextField input){
        this.clone = input;
    }

    public void markAsEmpty(){
        this.clone.getStyleClass().add("field-textfield-exception");
    }
}

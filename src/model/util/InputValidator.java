package model.util;

import javafx.scene.control.TextField;
import model.exception.InputEmptyException;

public class InputValidator {

    public static void text(TextField input) throws InputEmptyException {
        if( input.getText().isEmpty() ){
            throw new InputEmptyException(input);
        }
    }
}

package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.entity.Require;

public class RequireListItemController {
    @FXML
    private Label typeLabel;
    @FXML
    private Button doneButton;
    @FXML
    private Label nameLabel;

    private Require require;

    public void setRequire(Require require){
        setTypeLabelStyle(require.getType());
        nameLabel.setText(require.getName());
        this.require = require;
    }

    private void setTypeLabelStyle(int typeValue){
        String style = getTypeLabelStyleClass(typeValue);
        this.typeLabel.getStyleClass().add(style);
    }

    private String getTypeLabelStyleClass(int value){
        String style = "rf";
        if(value == 2)
            style = "rnf";
        else if(value == 3)
            style = "rn";
        return style+"-label";
    }

}

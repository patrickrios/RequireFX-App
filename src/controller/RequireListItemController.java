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
        typeLabel.setText(require.getTypeName());
        nameLabel.setText(require.getName());
        this.require = require;
    }

}

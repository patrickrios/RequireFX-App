package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.ResourceBundle;

public class RequireCreateNewController implements Initializable {

    @FXML
    private AnchorPane RequireInput;
    @FXML
    private TextField inputName;
    @FXML
    private Button buttonRF;
    @FXML
    private Button createButton;

    private  Button selected;

    private RequireListController controller;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.selected = this.buttonRF;
        this.createButton.setDisable(true);
    }

    public void setListController(RequireListController controller) {
        this.controller = controller;
    }

    @FXML
    void closeInput() {
        this.controller.removeRequireInput(this.RequireInput);
    }

    @FXML
    void createRequire() {
        //TODO
        System.out.println(inputName.getText()+" type:"+selected.getText());
    }

    @FXML
    void validateInput(KeyEvent event) {
        String key = event.getCode().toString();
        if (this.inputName.getText().length() == 1)
            if(key.equals("SPACE"))
                this.inputName.setText("");

        if(this.inputName.getText().isEmpty()) {
            this.createButton.setDisable(true);
        }else {
            if(key.equals("ENTER"))
                createRequire();
            if(createButton.isDisable()) {
                this.createButton.setDisable(false);
            }
        }
    }

    @FXML
    void setRequireType(ActionEvent event) {
        Button clicked = (Button)event.getTarget();
        if(!clicked.equals(this.selected)){
            switchSelectButton(clicked);
        }
    }

    private void switchSelectButton(Button clicked){
        setInputFocus();
        switchSelectButtonIcon(clicked);
        switchSelectButtonStyle(clicked);
        this.selected= clicked;
    }

    private void switchSelectButtonStyle(Button clicked){
        String SELECT_CLASS     = "require-type-selected";
        String UNSELECTED_CLASS = "require-type-unselected";
        clicked.getStyleClass().remove(UNSELECTED_CLASS);
        clicked.getStyleClass().add(SELECT_CLASS);
        this.selected.getStyleClass().remove(SELECT_CLASS);
        this.selected.getStyleClass().add(UNSELECTED_CLASS);
    }

    private void switchSelectButtonIcon(Button clicked){
        clicked.setGraphic( new ImageView( new Image("/view/images/require-add-check.png")));
        this.selected.setGraphic(new ImageView(new Image("/view/images/require-add-uncheck.png")));
    }

    public void setInputFocus() {
        this.inputName.requestFocus();
    }
}
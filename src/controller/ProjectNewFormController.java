package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class ProjectNewFormController {
    @FXML
    private HBox anchorProjectNewForm;
    @FXML
    private TextField inputProjectName;
    @FXML
    private Label labelNameException;
    @FXML
    private Button buttonSubmit;

    @FXML
    void closeForm() {
        StackPane form = (StackPane)anchorProjectNewForm.getParent();
        form.getChildren().remove(anchorProjectNewForm);
    }

    @FXML
    void createProject() {
        //TODO
        String name = inputProjectName.getText();
        labelNameException.setText("Salvou o projeto "+name);
        //montar objeto de modelo
        //salvar no db
        //informar usuário
    }

    @FXML
    void verifyInputName(KeyEvent event){
        String input = inputProjectName.getText();

        if( input.length() < 5) {
            labelNameException.setText("Muito curto");
            buttonSubmit.setDisable(true);
        }
        else if(alreadyExist(input)){
            //TODO verificar existência
            labelNameException.setText("já existe");
            buttonSubmit.setDisable(true);
        }else{
            buttonSubmit.setDisable(false);
            labelNameException.setText("");
        }
    }

    private boolean alreadyExist(String name){
        return name.equals("buceta");
    }
}
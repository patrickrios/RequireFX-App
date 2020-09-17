package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class ProjectNewFormController {
    @FXML
    private AnchorPane anchorProjectNewForm;
    @FXML
    private TextField inputProjectName;
    @FXML
    private Label labelNameException;

    @FXML
    void closeForm() {
        StackPane form = (StackPane)anchorProjectNewForm.getParent();
        form.getChildren().remove(anchorProjectNewForm);
    }

    @FXML
    void createProject() {
        //TODO
        //validar entrada
        //montar objeto de modelo
        //salvar no db
        //informar usuário
        labelNameException.setText("Já existe um projeto com este nome");
    }

}

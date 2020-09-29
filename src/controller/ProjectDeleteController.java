package controller;

import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class ProjectDeleteController {

    @FXML
    private HBox deleteProject;

    @FXML
    void close(){
        StackPane stk = (StackPane) deleteProject.getParent();
        stk.getChildren().remove(deleteProject);
    }
}

package controller;

import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import model.entity.Project;

public class ProjectDeleteController {

    @FXML
    private HBox deleteProject;

    private Project project;

    public void initialize(Project project){
        this.project = project;
    }

    @FXML
    void close(){
        StackPane stk = (StackPane) deleteProject.getParent();
        stk.getChildren().remove(deleteProject);
    }

    @FXML
    void deleteProject(){
        ViewportController c = (ViewportController) deleteProject.getScene().lookup("#MainContainer").getUserData();
        c.deleteProject(this.deleteProject);
    }
}

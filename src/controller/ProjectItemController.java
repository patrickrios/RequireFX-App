package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import model.entity.Project;

import java.io.IOException;

public class ProjectItemController extends LayoutController{
    @FXML
    private Label projectName;

    private Project project;

    public void initiProject(Project project){
        this.project = project;
        this.projectName.setText(project.getName());
    }

    @FXML
    void loadProject() {
        super.getLayoutController().openProject(this.project);
    }
}

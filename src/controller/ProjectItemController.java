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
        try {
            super.getLayoutController().openProject(this.project);
            Parent home = FXMLLoader.load(getClass().getResource("/view/fxml/RequireList.fxml"));
            super.getLayoutController().setContent(home);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

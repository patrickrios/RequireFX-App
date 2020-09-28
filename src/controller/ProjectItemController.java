package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import model.entity.Project;

import java.io.IOException;

public class ProjectItemController {
    @FXML
    private Label projectName;

    private Project project;

    public void initi(Project project){
        this.project = project;
        this.projectName.setText(project.getName());
    }

    @FXML
    void openProject() {
        Scene scene = this.projectName.getScene();
        AnchorPane main = (AnchorPane) scene.lookup("#MainContainer");
        ViewportController c = (ViewportController) main.getUserData();
        c.addMainMenu();
        c.setCurrentProject(this.project);
        c.setProjectName(projectName.getText());

        try {
            Parent home = FXMLLoader.load(getClass().getResource("/view/fxml/RequireList.fxml"));
            c.addMainContent(home);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

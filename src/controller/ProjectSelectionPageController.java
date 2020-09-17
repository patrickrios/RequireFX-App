package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import java.io.IOException;

public class ProjectSelectionPageController {
    @FXML
    void openNewProjectForm(ActionEvent event) {
        Button button = (Button)event.getTarget();
        StackPane stack = (StackPane)button.getScene().lookup("#stackMainContent");
        try {
            Parent form = FXMLLoader.load(getClass().getResource("/view/fxml/ProjectNewForm.fxml"));
            stack.getChildren().add(form);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

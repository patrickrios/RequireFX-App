package controller;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class ProjectNewFormController {
    @FXML
    private AnchorPane anchorProjectNewForm;

    @FXML
    void closeForm() {
        StackPane form = (StackPane)anchorProjectNewForm.getParent();
        form.getChildren().remove(anchorProjectNewForm);
    }

}

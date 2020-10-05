package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import java.io.IOException;

public class RequireListController {
    @FXML
    private Pane newRequireContainer;
    @FXML
    private Button addInputButton;

    @FXML
    void loadNewRequireInput() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/RequireCreateNew.fxml"));
            Parent input = loader.load();
            RequireCreateNewController c = loader.getController();
            c.setListController(this);
            this.newRequireContainer.getChildren().setAll(input);
            c.setInputFocus();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeRequireInput(Parent input){
        this.newRequireContainer.getChildren().remove(input);
        this.newRequireContainer.getChildren().add(this.addInputButton);
    }

}

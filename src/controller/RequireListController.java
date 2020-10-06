package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.entity.Project;
import java.io.IOException;

public class RequireListController {
    @FXML
    private VBox vboxList;
    @FXML
    private Pane newRequireContainer;
    @FXML
    private Button addInputButton;

    private Project project;

    public void initialize(Project project){
        this.project= project;
        //TODO load list
    }

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

    public Project getProject() {
        return project;
    }

    public void addItemToList(Parent item){
        this.vboxList.getChildren().add(item);
    }
}
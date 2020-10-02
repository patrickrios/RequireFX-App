package controller;

import javafx.fxml.FXML;
import javafx.scene.layout.HBox;

public class ProjectDeleteController extends  LayoutController{

    @FXML
    private HBox deleteProject;

    @FXML
    void close(){
        super.getLayoutController().removePopup(deleteProject);
    }

    @FXML
    void deleteProject(){
        super.getLayoutController().deleteProject();
        this.close();
    }
}
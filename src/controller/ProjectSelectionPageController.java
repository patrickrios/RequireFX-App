package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import model.dao.ProjectDAO;
import model.entity.Project;
import model.util.List;
import view.effects.FadeEffectTransition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProjectSelectionPageController implements Initializable {
    @FXML
    private FlowPane listView;
    private List list;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadFirstPage();
    }

    private void loadFirstPage(){
        this.list = new List(new ProjectDAO());
        for(Object p : this.list.load()){
            Project project = (Project)p;
            loadItem(project.getName(), project.getID());
        }
    }

    private void loadItem(String project, int id){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/ProjectItemCard.fxml"));
        try {
            Parent item = loader.load();
            ProjectItemController c = loader.getController();
            c.initi(project, id);
            this.listView.getChildren().add(item);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void openNewProjectForm(ActionEvent event) {
        Button button = (Button)event.getTarget();
        StackPane stack = (StackPane)button.getScene().lookup("#stackMainContent");
        try {
            Parent form = FXMLLoader.load(getClass().getResource("/view/fxml/ProjectNewForm.fxml"));
            new FadeEffectTransition(form);
            stack.getChildren().add(form);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

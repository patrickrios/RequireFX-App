package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.dao.RequireDAO;
import model.entity.Project;
import model.entity.Require;
import model.util.List;
import java.io.IOException;

public class RequireListController {
    @FXML
    private VBox vboxList;
    @FXML
    private Pane newRequireContainer;
    @FXML
    private Button addInputButton;

    private Project project;

    private List list;

    public void initialize(Project project){
        this.project= project;
        this.list = new List(new RequireDAO( project.getID() ));
        loadList();
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

    private void loadList(){
        for(Object req : this.list.load()){
            Require require = (Require) req;
            addItemToList( loadItem(require) );
        }
    }

    public void removeRequireInput(Parent input){
        this.newRequireContainer.getChildren().remove(input);
        this.newRequireContainer.getChildren().add(this.addInputButton);
    }

    public Project getProject() {
        return project;
    }

    private Parent loadItem(Require require){
        Parent item = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/RequireListItem.fxml"));
            item = loader.load();
            RequireListItemController c = loader.getController();
            c.setRequire(require);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return item;
    }

    public void addItemToList(Parent item){
        this.vboxList.getChildren().add(item);
    }
}
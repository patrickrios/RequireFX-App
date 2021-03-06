package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.FlowPane;
import model.dao.ProjectDAO;
import model.entity.Project;
import model.util.List;
import java.io.IOException;
import java.util.ArrayList;

public class ProjectSelectionPageController extends LayoutController{
    @FXML
    private FlowPane listView;

    @Override
    public void initialize(ViewportControllable controller) {
        super.layoutController = controller;
        try {
            loadFirstPage();
        } catch (Exception e) {
            loadWelcomeLayout();
        }
    }

    private void loadFirstPage() throws Exception {
        List list = new List(new ProjectDAO());

        ArrayList<?> items = list.load();

        if (items.isEmpty()) {
            throw new Exception();
        }else {
            for (Object p : items) {
                Project project = (Project) p;
                this.loadItem(project);
            }
        }
    }

    private void loadItem(Project project){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/ProjectItemCard.fxml"));
            Parent item = loader.load();
            ProjectItemController controller = loader.getController();
            controller.initialize(super.getLayoutController());
            controller.initiProject(project);
            this.listView.getChildren().add(item);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void openNewProjectForm() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/ProjectNewForm.fxml"));
            Parent form = loader.load();
            ProjectNewFormController controller = loader.getController();
            controller.initialize(super.getLayoutController());
            controller.setTitle("Criar novo projeto");
            super.getLayoutController().addPopup(form);
            controller.setInputFocus();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadWelcomeLayout(){
        try {
            Parent welcome = FXMLLoader.load(getClass().getResource("/view/fxml/ProjectListWelcome.fxml"));
            this.listView.getChildren().setAll(welcome);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.entity.Project;
import view.effects.FadeEffectTransition;

public class ViewportController implements Initializable, ViewportControllable{
	@FXML
	private AnchorPane MainContainer;
	@FXML
    private AnchorPane anchorMenu;
	@FXML
	private StackPane stackMainContent;
	@FXML
	private AnchorPane mainContentConteiner;
	@FXML
	private MenuButton projectButton;
	@FXML
	private Button projectExitButton;

	private Project project;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		projectButton.setVisible(false);
		projectExitButton.setVisible(false);
		initializeProjectSelection();
	}
	
	@FXML
    void minimizeStage() {
		Stage stage = (Stage)MainContainer.getScene().getWindow();
		stage.setIconified(true);
    }
    
    @FXML
    void closeApplication() {
    	System.exit(0);
    }
    
    @FXML
    void maximizeStage() {
    	Stage stage = (Stage)MainContainer.getScene().getWindow();
    	stage.setX(0.0);
    	stage.setY(0.0);
    }
    
    private void addMainMenu() {
    	FXMLLoader load = new FXMLLoader(getClass().getResource("/view/fxml/MainMenu.fxml"));
		try {
			Parent menu = load.load();
			MainMenuController c = load.getController();
			c.initi(this.mainContentConteiner);
			new FadeEffectTransition(menu);
			this.anchorMenu.getChildren().setAll(menu);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    private void setProjectName(String name){
		this.projectButton.setText(name);
		this.projectButton.setVisible(true);
		projectExitButton.setVisible(true);
	}

	private void setCurrentProject(Project project){
		this.project = project;
	}

    private void initializeProjectSelection(){
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/ProjectSelectionPage.fxml"));
			Parent selection =  loader.load();
			ProjectSelectionPageController controller = loader.getController();
			controller.initialize(this);
			setContent(selection);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setContent(Parent child) {
		new FadeEffectTransition(child);
		this.mainContentConteiner.getChildren().setAll(child);
	}

	@Override
	public void removeContent(Parent content) {
		this.mainContentConteiner.getChildren().remove(content);
	}

	@Override
	public void addPopup(Parent popup) {
		new FadeEffectTransition(popup);
		this.stackMainContent.getChildren().add(popup);
	}

	@Override
	public void removePopup(Parent popup) {
		this.stackMainContent.getChildren().remove(popup);
	}

	@Override
	public void updateProjectName(String name) {
		this.projectButton.setText(name);
	}

	@Override
	public void openProject(Project project) {
		this.addMainMenu();
		this.setCurrentProject(project);
		this.setProjectName(project.getName());

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/RequireList.fxml"));
			Parent home  = loader.load();
			RequireListController controller = loader.getController();
			controller.initialize(this.project);
			setContent(home);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void closeProject() {
		exitProject();
	}

	@FXML
	void exitProject(){
		anchorMenu.getChildren().clear();
		initializeProjectSelection();
		projectButton.setVisible(false);
		projectExitButton.setVisible(false);
	}

	@FXML
	void loadEditProject(){
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/ProjectNewForm.fxml"));
			Parent form = loader.load();
			ProjectNewFormController controller = loader.getController();
			controller.initialize(this);
			controller.setTitle("Editar projeto");
			controller.setButtonSubmitText("Salvar informações");
			controller.editingProject(this.project);
			controller.isCreating(false);
			addPopup(form);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void deleteCurrentProject(){
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/ProjectDelete.fxml"));
			Parent delete = loader.load();
			ProjectDeleteController controller = loader.getController();
			controller.initialize(this);
			addPopup(delete);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteProject(){
		this.project.deleteThis();
		this.closeProject();
	}
}
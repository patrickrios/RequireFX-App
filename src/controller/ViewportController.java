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
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.entity.Project;
import view.effects.FadeEffectTransition;

public class ViewportController implements Initializable{
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
    
    public void addMainMenu() {
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

    public void setProjectName(String name){
		this.projectButton.setText(name);
		this.projectButton.setVisible(true);
		projectExitButton.setVisible(true);
	}

	public void setCurrentProject(Project project){
		this.project = project;
	}

	public void addMainContent(Parent parent){
		new FadeEffectTransition(parent);
		this.mainContentConteiner.getChildren().setAll(parent);
	}
    private void initializeProjectSelection(){
		try {
			Parent selection =  FXMLLoader.load(getClass().getResource("/view/fxml/ProjectSelectionPage.fxml"));
			this.mainContentConteiner.getChildren().setAll(selection);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void closeProject(){
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
			controller.setTitle("Editar projeto");
			controller.setButtonSubmitText("Salvar informações");
			controller.editingProject(this.project);
			controller.isCreating(false);
			new FadeEffectTransition(form);
			this.stackMainContent.getChildren().add(form);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void deleteCurrentProject(){
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/ProjectDelete.fxml"));
			Parent delete = loader.load();
			new FadeEffectTransition(delete);
			this.stackMainContent.getChildren().add(delete);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void deleteProject(HBox deleteLayout){
		this.project.deleteThis();
		this.stackMainContent.getChildren().remove(deleteLayout);
		this.closeProject();
	}
}
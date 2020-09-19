package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import view.effects.FadeEffectTransition;

public class ViewportController implements Initializable{
	@FXML
	private AnchorPane MainContainer;
	@FXML
    private AnchorPane anchorMenu;
	@FXML
	private AnchorPane mainContentConteiner;
	@FXML
	private Label labelProjectName;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
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
		this.labelProjectName.setText(name);
	}
    private void initializeProjectSelection(){
		try {
			Parent selection =  FXMLLoader.load(getClass().getResource("/view/fxml/ProjectSelectionPage.fxml"));
			this.mainContentConteiner.getChildren().setAll(selection);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
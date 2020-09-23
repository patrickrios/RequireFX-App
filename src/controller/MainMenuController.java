package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class MainMenuController {
	@FXML
    private AnchorPane AnchorSidebar;
	private String selectedID = "#MenuItemHome";
	private Map<String, String> menuIcons;
	private AnchorPane mainContentContainer;
	
	public void initi(AnchorPane main) {
		this.mainContentContainer = main;
		initiIconsMap();
		AnchorPane.setTopAnchor(AnchorSidebar, 0.0);
		AnchorPane.setRightAnchor(AnchorSidebar, 0.0);
		AnchorPane.setBottomAnchor(AnchorSidebar, 0.0);
		AnchorPane.setLeftAnchor(AnchorSidebar, 0.0);
	}

	@FXML
    void displayAddNewForm(ActionEvent event) {
    	setMenuItem(event);
		try {
			Parent form = FXMLLoader.load(getClass().getResource("/view/fxml/AddNewForm.fxml"));
			this.mainContentContainer.getChildren().setAll(form);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    @FXML
    void displayHomepage(ActionEvent event) {
    	setMenuItem(event);
		try {
			Parent home = FXMLLoader.load(getClass().getResource("/view/fxml/RequireList.fxml"));
			this.mainContentContainer.getChildren().setAll(home);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    @FXML
    void displayList(ActionEvent event)  {
    	setMenuItem(event);
		try {
			Parent page2 = FXMLLoader.load(getClass().getResource("/view/fxml/BasicPage2.fxml"));
			this.mainContentContainer.getChildren().setAll(page2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void closeProject(){
		Scene scene = this.mainContentContainer.getScene();
		AnchorPane main = (AnchorPane) scene.lookup("#MainContainer");
		ViewportController c = (ViewportController) main.getUserData();
		c.closeProject();
	}

	private void setMenuItem(ActionEvent event) {
		Button pressed = (Button)event.getSource();
		String pressedID = "#"+pressed.getId();
		resetSelectedButton(pressedID);
		switchStyleClass(pressed, "menu-item-selected");
		//switchIcon(pressed, this.menuIcons.get(pressedID)+"blue.png");
	}
	
	private void resetSelectedButton(String newId) {
		Button current = (Button)mainContentContainer.getScene().lookup(this.selectedID);
		switchStyleClass(current, "menu-item");
		//switchIcon(current, menuIcons.get(this.selectedID)+"light.png");
		this.selectedID = newId;
	}
	
	private void switchStyleClass(Button button, String newClass) {
		button.getStyleClass().remove(1);
		button.getStyleClass().add(newClass);
	}
	
	private void switchIcon(Button button, String path) {
		button.setGraphic( new ImageView(new Image(getClass().getResourceAsStream(path))));
	}
	
	private void initiIconsMap() {
		String folder = "/view/images/menu-";
		this.menuIcons = new HashMap<String, String>();
		this.menuIcons.put("#MenuItemHome",   folder+"home-");
		this.menuIcons.put("#MenuItemAddNew", folder+"add-");
		this.menuIcons.put("#MenuItemList",   folder+"list-");
		this.menuIcons.put("#MenuItemReport", folder+"report-");
	}
}
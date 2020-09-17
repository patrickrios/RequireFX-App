package model;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Viewport {
	
	private double xOffset = 0; 
	private double yOffset = 0;
	private final Stage stage;

	public Viewport(Stage stage) {
		this.stage = stage;
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("/view/fxml/Viewport.fxml"));
			Scene root = new Scene(parent);
			stage.setScene(root);
			setSceneSize(stage);
			stage.initStyle(StageStyle.UNDECORATED);
			draggable(root, stage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void draggable(Scene root, Stage stage) {
    	root.setOnMousePressed(event -> {
			xOffset = event.getSceneX();
			yOffset = event.getSceneY();
		});
        root.setOnMouseDragged(event -> {
			stage.setX(event.getScreenX() - xOffset);
			stage.setY(event.getScreenY() - yOffset);
		});
    }  
    
    private void setSceneSize(Stage stage) {
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	double width = screenSize.getWidth();
    	double height = screenSize.getHeight()-40;
    	stage.setWidth(width);
    	stage.setHeight(height);
    }
    
    public void display() {
    	this.stage.show();
    }
}

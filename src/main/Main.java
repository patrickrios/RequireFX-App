package main;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Viewport;

public class Main extends Application{
	
	@Override
	public void start(Stage primaryStage){
		Viewport window = new Viewport(primaryStage);
		window.display();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
package gui;

import java.util.List;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.*;

public class guiMain extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	Button search;
	TextField queryText;
	@Override
	public void start(Stage primaryStage) throws Exception {
		search = new Button("Search");
		StackPane layout = new StackPane();
		List l = layout.getChildren();
		l.add(search);
		queryText = new TextField();
		
		Scene s = new Scene(layout,500,500);
		primaryStage.setScene(s);
		primaryStage.show();
	}

}

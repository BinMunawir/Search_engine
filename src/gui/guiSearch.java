package gui;

import java.util.List;

import javafx.application.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.*;

public class guiSearch extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	Button search;
	Label logo;
	TextField queryText;
	@Override
	public void start(Stage primaryStage) throws Exception {
		logo = new Label("Bu3abed search engine");
		search = new Button("Search");
		queryText = new TextField();
		search.setOnAction(e -> {
			new guiResult().show();
		});
		
		HBox hBox = new HBox(10);
		hBox.setAlignment(Pos.CENTER);
		hBox.getChildren().addAll(queryText,search);
		
		VBox mainBox = new VBox(20);
		mainBox.setAlignment(Pos.CENTER);
		mainBox.getChildren().addAll(logo,hBox);
		
		Scene scene = new Scene(mainBox,500,300);
		
		primaryStage.setTitle("Bu3abed Search engine");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}

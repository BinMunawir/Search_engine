package gui;

import java.awt.*;

import javafx.application.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.*;

public class guiTesting extends Application{

	public static void main(String[] args) {
		launch(args);
		
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		Button b = new Button("hi there");
		Label l = new Label("i'm just saying hi there i'm just saying hi there i'm just saying hi there");
		l.setWrapText(true);
		VBox layout = new VBox();
		layout.getChildren().addAll(b);
		layout.getChildren().add(l);
		Scene s = new Scene(layout,200,500);
		
		stage.setScene(s);
		stage.setTitle("hi");
		stage.show();
		
	}

}

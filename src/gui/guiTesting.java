package gui;

import java.awt.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class guiTesting extends Application{

	public static void main(String[] args) {
		launch(args);
		
	}

	@Override
	public void start(Stage stage) throws Exception {
//		stage.setTitle("javafx");
//		Button b = new Button("click me");
//		b.setOnAction(e -> System.out.println("hi"));
//		StackPane layout = new StackPane();
//        layout.getChildren().add(b);
//        Scene scene = new Scene(layout, 600, 500);
//
//        stage.setScene(scene);
//        stage.show();
		stage.setTitle("Main search eare");
		Label l = new Label("hi");
//		Scene s = new Scene(l,500,500);
		
		
		stage.setScene(s);
		stage.show();
	}

}

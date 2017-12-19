package gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class guiResult extends Stage{

	public static void main(String[] args) {
		Stage s = new guiResult();
		s.show();
	}
	
	
	
	
	Button search;
	Label logo;
	TextField queryText;
	public guiResult(){
		BorderPane border = new BorderPane();
		
		BorderPane topBorder = new BorderPane();
		HBox top = new HBox(20);
		queryText = new TextField();
		search = new Button("Search");
		search.setOnAction(e -> {});
		logo = new Label("Bu3abed search engine");
		top.getChildren().addAll(queryText,search);
		top.setAlignment(Pos.CENTER);
		topBorder.setLeft(logo);
		topBorder.setCenter(top);
		border.setTop(topBorder);
		
		Scene scene = new Scene(border,700,500);
		this.setScene(scene);
		this.setTitle("Result");
		
		
		
	}
	
	
	
}

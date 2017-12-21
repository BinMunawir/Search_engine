package gui;

import java.io.IOException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import classes.Data;
import classes.InvertedIndex;
import javafx.application.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.*;

public class guiSearch extends Stage{
	
//	static int time=0;
	
	Button search;
	Label logo,quereyTpye,invTime;
	TextField queryText;
	ChoiceBox<String> queryiesChoice;
	public guiSearch() {
//		new Timer().schedule(new TimerTask() {
//		    @Override
//		    public void run() {
////		       System.out.println(a+"/ms");
//		       time++;
//		    }
//		}, 0, 1);
		
		// fill components
		logo = new Label("Bu3abed search engine");
		logo.setFont(new Font(30));
		
		queryText = new TextField();
		queryText.setPrefSize(250, 25);
		quereyTpye = new Label("Query type: ");
		queryiesChoice= new ChoiceBox<>();
		queryiesChoice.getItems().addAll("Single Query","AND Queryies","OR Queryies","NOt Query");
		queryiesChoice.setValue("OR Queryies");
		search = new Button("Search");
		search.setOnAction(e -> {
			this.close();
			new guiResult(queryText.getText(),queryiesChoice.getValue()).show();
		});
		
		//queryies typs
		HBox ch = new HBox(10);
		ch.setAlignment(Pos.CENTER);
		ch.getChildren().addAll(quereyTpye,queryiesChoice);
		
		//search eare layout
		HBox hBox = new HBox(10);
		hBox.setAlignment(Pos.CENTER);
		hBox.getChildren().addAll(queryText,search);
		
		//main layout
		VBox mainLayout = new VBox(20);
		mainLayout.setAlignment(Pos.CENTER);
		mainLayout.getChildren().addAll(logo,hBox,ch);
		
		
		
		Scene scene = new Scene(mainLayout,500,300);
		this.setScene(scene);
		this.setTitle("Bu3abed Search engine");
		
	}

}

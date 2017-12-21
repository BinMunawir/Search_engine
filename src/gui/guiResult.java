package gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import classes.*;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;




public class guiResult extends Stage{
	
	
	Border b = new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
	int time =0;
	
	
	Button search;
	TextField queryText;
	ChoiceBox<String> queryiesChoice;
	Label info;
	public guiResult(String s , String type){
		
		new Timer().schedule(new TimerTask() {
	    @Override
	    public void run() {
//	       System.out.println(a+"/ms");
	       time++;
	    }
		}, 0, 1);
		
		
		HashMap<Integer,Decument> data = (new Data()).data;
		System.out.println("after create the data: "+time);
		InvertedIndex iv = null;
		try {
			iv = new InvertedIndex(data);
			System.out.println("after create the inv: "+time);
		} catch (IOException e1) {
			System.out.println("error:sth with inverted index");
			System.exit(0);
		}
		
		//top
		HBox top = new HBox(20);
		top.setBorder(b);
		top.setPrefSize(600, 100);
		top.setAlignment(Pos.CENTER);
		queryText = new TextField(s);
		queryText.setAlignment(Pos.CENTER_RIGHT);
		queryText.setPrefSize(300, 50);
		search = new Button("Search");
		search.setOnAction(e -> {
			this.close();
			new guiResult(queryText.getText(),queryiesChoice.getValue()).show();
		});
		queryiesChoice= new ChoiceBox<>();
		HBox.setHgrow(queryiesChoice,Priority.ALWAYS);
		queryiesChoice.getItems().addAll("Single Query","AND Queryies","OR Queryies","NOt Query");
		queryiesChoice.setValue(type);
		top.getChildren().addAll(queryiesChoice,queryText,search);
		
		//middle
		Query q = new Query(iv.getMap(),s,type);
		ArrayList<Index> r = q.getResult();
		
		VBox result[] = new VBox[r.size()];
		HBox tb[] = new HBox[r.size()];
		Button title[] = new Button[r.size()];
		Label f[] = new Label[r.size()];
		Label shortText[] = new Label[r.size()];
		
		
		VBox middle = new VBox(10);
		middle.setPadding(new Insets(10,0,10,0));
		for (int i = 0; i < r.size(); i++) {
			Decument d = data.get(r.get(i).getDcId());
			result[i] = new VBox();
			tb[i]= new HBox(5);
			title[i] = new Button((i+1)+")  "+d.title());
			title[i].setFont(new Font(14));
			f[i] = new Label("("+r.get(i).getFr()+")");
			tb[i].getChildren().addAll(title[i],f[i]);
			shortText[i] = new Label(d.shortText());
			shortText[i].setMaxWidth(550);
			shortText[i].setPrefHeight(70);
//			shortText[i].setBorder(b);
			shortText[i].setWrapText(true);
			shortText[i].setFont(new Font(12));
			result[i].getChildren().addAll(tb[i],shortText[i]);
			result[i].setPadding(new Insets(5,10,5,20));
			middle.getChildren().add(result[i]);
		}
		ScrollPane sp = new ScrollPane(middle);
		sp.setHbarPolicy(ScrollBarPolicy.NEVER);
		sp.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		
		// bottom side
		HBox bottom = new HBox();
//		bottom.setBorder(b);
		info = new Label(r.size()+" match results from "+data.size()+" decuments in "+time+" ms");
		bottom.getChildren().add(info);
//		bottom.setAlignment(Pos.CENTER);
		
		// main layout
		BorderPane mainLayout = new BorderPane();
		mainLayout.setTop(top);
		mainLayout.setBottom(bottom);
		mainLayout.setCenter(sp);
		
		Scene scene = new Scene(mainLayout,600,600);
		this.setScene(scene);
		this.setTitle("Result page");
		
		System.out.println(time);
	}
	
	
	
}

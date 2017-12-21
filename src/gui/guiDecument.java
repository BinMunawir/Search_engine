package gui;

import classes.Decument;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class guiDecument extends Stage{
	
	public guiDecument(Decument d){
		
		//top
		Label title = new Label(d.title());
		title.setTextAlignment(TextAlignment.CENTER);
		title.setFont(new Font(18));
		
		//bottom
		Label words = new Label("total words in this decument is = "+d.getTotalWords());
		
		//middle
		Label text = new Label("   "+d.fullText());
		text.setPadding(new Insets(20,20,20,20));
		text.setMaxWidth(400);
		text.setWrapText(true);
		text.setFont(new Font(14));
		
		ScrollPane sp = new ScrollPane(text);
		sp.setHbarPolicy(ScrollBarPolicy.NEVER);
		sp.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		
		
		BorderPane mainLayout = new BorderPane();
		mainLayout.setTop(title);
		mainLayout.setBottom(words);
		mainLayout.setCenter(sp);
		
		Scene s = new Scene(mainLayout,400,550);
		this.setScene(s);
		this.setTitle("Decument("+d.getId()+") page");
	}
	
}

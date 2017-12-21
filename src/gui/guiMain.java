package gui;

import javafx.application.*;
import data_structure.*;

import java.io.IOException;

import classes.*;
import javafx.stage.Stage;

public class guiMain extends Application{

	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage window) throws Exception {
		window = new guiSearch();
//		window = new guiResult();
		window.show();
	}
	

}

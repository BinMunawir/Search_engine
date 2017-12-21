package classes;

import java.io.*;
import java.nio.CharBuffer;
import java.text.DecimalFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import data_structure.BST;
import data_structure.BSTNode;
import data_structure.DLL;

public class Main {

	static int tt =0;
	public static void main(String[] args) throws IOException {
		new Timer().schedule(new TimerTask() {
		    @Override
		    public void run() {
//		       System.out.println(a+"/ms");
		       tt++;
		    }
		}, 0, 1);
		
		
		
		
		
		
		
		String s = "abdullah";
		
//		InvertedIndex iv = new InvertedIndex(Data.data);
		System.out.println("inverted index time: "+tt);
		
		
//		Query q = new Query(iv.getMap(), s);
//		System.out.println(q.getResult().toString());
		System.out.println("finish");
		
		
		
		
		
		
		
		
		System.out.println("time is = "+tt);
		System.exit(0);
		
	}

}

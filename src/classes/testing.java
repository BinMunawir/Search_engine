package classes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;

import data_structure.AVLTree;
import data_structure.BinaryHeap;
import gui.*;

public class testing {

	static int tt =0;
	public static void main(String[] args) {
		new Timer().schedule(new TimerTask() {
		    @Override
		    public void run() {
//		       System.out.println(a+"/ms");
		       tt++;
		    }
		}, 0, 1);
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("\ntime is = "+tt);
		System.exit(0);
		
	}

}

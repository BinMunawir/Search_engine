import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;

import data_structure.AVLTree;
import data_structure.BinaryHeap;

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
		
		
		
		
		
		AVLTree<Index> t = new AVLTree<>();
//		Index i = new Index(2,1);
//		t.insert(new Index(1,1));
//		t.insert(new Index(1,2));
//		t.insert(i);
//		t.insert(new Index(2,2));
//		t.breadthFirst();
		System.out.println(t);
		
		
		
		
		
		
		
		System.out.println("\ntime is = "+tt);
		System.exit(0);
		
	}

}

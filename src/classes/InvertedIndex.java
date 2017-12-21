package classes;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import data_structure.AVLTree;
import data_structure.BinaryHeap;

public class InvertedIndex {

	
	public static void main(String[] args) throws IOException {
		
//		InvertedIndex iv = new InvertedIndex(Data.data);
//		System.out.println("total words = "+iv.map.size());
//		System.out.println("total files = "+ Data.data.size());
//		System.out.println("total time = "+tt);
//		System.exit(0);
	}
	
	
	
	
	
	
	
	
	private HashMap<String,AVLTree<Index>> map = new HashMap<String,AVLTree<Index>>();
	
	public InvertedIndex(HashMap<Integer,Decument> data) throws IOException{
		for(Map.Entry<Integer, Decument> m : data.entrySet()){
			this.addToMap(m.getValue().getMap());
		}
		writeToFile();
		
		
	}
	
	
	
	
	private void writeToFile() throws FileNotFoundException, IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter( new FileOutputStream("data\\invertedIndex.txt")));
		for(Map.Entry<String, AVLTree<Index>> m : map.entrySet()){
			bw.write(m.getKey()+" \t\t\t\t "+m.getValue());
			bw.newLine();
//			System.out.print(m.getKey()+" :----> ");m.getValue().breadthFirst();
//			System.out.println();
		}
		bw.flush();
		bw.close();
	}
	
	public void addToMap(HashMap<String,Index> map2){
		for (Map.Entry<String,Index> m : map2.entrySet()) {
			if(!map.containsKey(m.getKey())){
				AVLTree<Index> t = new AVLTree<Index>();
				t.insertAVL(m.getValue());
				map.put(m.getKey(),t);
			}
			else{
				AVLTree<Index> t = map.get(m.getKey());
				t.insertAVL(m.getValue());
			}
		}
		
//		for(Map.Entry<String, AVLTree<Index>> m : map.entrySet()){
//			System.out.print(m.getKey()+" :----> ");m.getValue().breadthFirst();
//			System.out.println();
//		}
		
	}




	public HashMap<String, AVLTree<Index>> getMap() {
		return map;
	}




	public void setMap(HashMap<String, AVLTree<Index>> map) {
		this.map = map;
	}
	
	
}

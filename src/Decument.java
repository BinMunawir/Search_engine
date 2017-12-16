import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class Decument extends File {

	
	private Scanner sc;
	private Integer id;
	private HashMap<String,Index> map = new HashMap<String,Index>();
	private int totalWords ; 
	
	private String headLine,shortText,fullTex;
	
	public Decument(File f,int id) throws FileNotFoundException{
		super(f.getPath());
		this.id=id;
		sc=new Scanner(this);
		makePostingList();
	}
	
	
	public void makePostingList(){
		String w;
		while(sc.hasNext()){
			this.totalWords++;
			w = this.wordOpration(sc.next());
			if(isStopWord(w) || w.equals(""))
				continue;
			else if(map.containsKey(w)){
				map.get(w).setFr(map.get(w).getFr()+1);
			}
			else{
				map.put(w, new Index(this.id,1.0));
			}
		}
		sc.close();
		for (Map.Entry m : map.entrySet()){
			double f = ((Index)m.getValue()).getFr()/this.totalWords;
			((Index)m.getValue()).setFr(constants.round(f, 5));
		}
		
		
//		for (Map.Entry m : map.entrySet()) 
//		    System.out.println(m.getKey()+" :---> "+m.getValue());
//		System.out.println(this.totalWords);
//		System.out.println(id+"**");
	}
	private String wordOpration(String w){
//		String ww = w;
		//remove punchuation
		w=w.replaceAll("[^a-zA-Z]"," ").trim();
		if(w.contains(" "))
			w=w.substring(0, w.indexOf(" "));
		//lowercase
		w=w.toLowerCase();
//		if(!ww.equals(w))
//			System.out.println("word b/a: "+ww+"\t"+w);
		return w;
	}
 	private boolean isStopWord(String w){
		for (String s : constants.stopWords)
			if(s.equalsIgnoreCase(w))
				return true;
		return false;
	}
	
 	private String title(){
 		return "title";
 	}
 	private String shortText(){
 		String text = null;
 		int cnt=0;
 		while(sc.hasNext() && cnt<15)
 			text+="\t"+sc.next();
 		return text+"...";
 	}
 	
 	
 	
 	
 	
 	
 	
 	@Override
 	public int compareTo(File f) {
		return this.id.compareTo(((Decument)f).id);
	}
	
 	
 	public HashMap getMap(){
		return this.map;
	}	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getTotalWords() {
		return totalWords;
	}

	public void setTotalWords(int totalWords) {
		this.totalWords = totalWords;
	}


	@Override
	public String toString() {
		return "id:"+this.getId();
	}
	
	
	
	
	
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import data_structure.AVLTree;
import data_structure.Queue;

public class Query {
	
	private ArrayList<Index> result ;
	private HashMap<String,AVLTree<Index>> map;
	public Query(HashMap<String,AVLTree<Index>> map,String s){
		this.map=map;
		s= s.toLowerCase().trim();
		String[] ws = s.split(" ");
		
		if(ws.length==1){
			this.result=singlQuery(ws[0]);
			System.out.println("singleQuery is done");
		}else{
//			this.result=ANDQueries(ws);System.out.println("ANDQueries is done");
//			this.result=ORQueries(ws);System.out.println("ORQueries is done");
			this.result=NOTQueries(ws);System.out.println("NOTQueries is done");
		}
		
	}
	
	public ArrayList<Index> singlQuery(String w){
		ArrayList<Index> list = new ArrayList<>();
		if(!this.map.containsKey(w))
			return new ArrayList<>();
		
		AVLTree<Index> t = this.map.get(w);
		Queue<Index> q = t.getNodes();
		while(!q.isEmpty())
			list.add(q.dequeue());
		
		//sort the indexes by frequency
		Collections.sort(list,Index.getComByF);
		Collections.reverse(list);
				
		return list;
	}

	public ArrayList<Index> ANDQueries(String[] w){
		ArrayList<Index> list = new ArrayList<>();
		
		//get the indexes for each term
		AVLTree<Index> terms[] = new AVLTree[w.length];
		for (int i = 0; i < w.length; i++) {
			if(!map.containsKey(w[i]))
				return new ArrayList<Index>();
			terms[i]=map.get(w[i]);
		}
		for (int i = 0; i < terms.length; i++) {
			System.out.println(terms[i].lenght()+w[i]+"\t"+terms[i]);
		}
		
		//find the smallest array index
//		System.out.println("start find smallest");
		int s = 0;
		for (int i = 1; i < terms.length; i++)
			if(terms[i].lenght()<terms[s].lenght())
				s=i;
		//comparing in trees
		Queue q = terms[s].getNodes();
		while(!q.isEmpty()){
			Index i = (Index) q.dequeue();
			Index newIndex =i;
			boolean isCommon=true;
			for (AVLTree<Index> t : terms){
				if(t==terms[s])
					continue;
				Index ii = (Index) t.searchByComparing(i);
				if(ii==null){
					isCommon = false;
					break;
				}
				double d = constants.round(newIndex.getFr()*ii.getFr(), 10);
				newIndex.setFr(d);
			}
			if(isCommon)
				list.add(newIndex);
		}
		//sort the indexes by frequency
		Collections.sort(list,Index.getComByF);
		Collections.reverse(list);
		System.out.println(list.size());
		
		return list;
	}
	
	public ArrayList<Index> ORQueries(String[] w){
		ArrayList<Index> list = new ArrayList<>();
		
		//get the indexes for each term
		AVLTree<Index> terms[] = new AVLTree[w.length];
		for (int i = 0; i < w.length; i++) {
			if(!map.containsKey(w[i])){
				terms[i]=new AVLTree<Index>();
				continue;
			}
			terms[i]=map.get(w[i]);
		}
		for (int i = 0; i < terms.length; i++) {
			System.out.println(terms[i].lenght()+w[i]+"\t"+terms[i]);
		}
		
		
		//find the largest array index
		int b = 0;
		for (int i = 1; i < terms.length; i++)
			if(terms[i].lenght()>terms[b].lenght())
				b=i;
		AVLTree r = terms[b].copy();
		
		//adding the other once 
		for (AVLTree<Index> t : terms) {
			if(t==terms[b])
				continue;
			Queue q = t.getNodes();
			while(!q.isEmpty()){
				Index i = (Index) q.dequeue();
				Index ii = (Index)r.searchByComparing(i);
				if(ii==null)
					r.insertAVL(i);
				else
					ii.setFr(ii.getFr()+i.getFr());
			}
		}
		
		// adding indexes of the r tree
		Queue rt = r.getNodes();
		while(!rt.isEmpty()){
			list.add((Index)rt.dequeue());
		}
		
		Collections.sort(list,Index.getComByF);
		Collections.reverse(list);
		
		
		System.out.println("total:"+list.size());
		
		
		return list;
	}
	
	public ArrayList<Index> NOTQueries(String[] w){
		ArrayList<Index> list = new ArrayList<>();
		
		for(Map.Entry<Integer,Decument> m : Data.data.entrySet()){
			boolean isContain = false;
			for (String s : w) 
				if(m.getValue().getMap().containsKey(s)){
					isContain = true;
					break;
				}
			if(!isContain)
				list.add(new Index(m.getValue().getId(),0));
		}
		System.out.println(list.size());
		
		//sort 
		Collections.sort(list);
//		Collections.reverse(list);
				
		return list;
	}

	
	
	public ArrayList<Index> getResult() {
		return result;
	}

	public void setResult(ArrayList<Index> result) {
		this.result = result;
	}
	
}

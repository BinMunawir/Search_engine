package classes;
import java.util.Comparator;

public class Index implements Comparable<Index> {
	
	private Integer dcId;
	private Double fr;
	public static Comparator<Index> getComByF = new Comparator<Index>(){
	     @Override
	     public int compare(Index i1, Index i2)
	     {
	    	 int c = i1.getFr().compareTo(i2.getFr());
	    	 if(c!=0)
	    		 return c;
	    	 else return i1.getDcId().compareTo(i2.getDcId());
	     }
	 }; 
	
	
	public Index(Integer d , double f){
		dcId=d;
		fr=f;
	}
	
	
	

	@Override
	public int compareTo(Index o) {
		return this.dcId.compareTo(o.dcId);
	}
	
	
	
	
	public Integer getDcId() {
		return dcId;
	}

	@Override
	public String toString() {
		return "["+this.dcId+":"+this.fr+"]";
	}




	public void setDc(Integer dcId) {
		this.dcId = dcId;
	}

	public Double getFr() {
		return fr;
	}

	public void setFr(double fr) {
		this.fr = fr;
	}
	
	
	
	
}

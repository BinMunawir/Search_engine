package data_structure;

import java.util.Arrays;

public class BinaryHeap 
{
	protected Comparable array[];
	int count;
	  
    public BinaryHeap(int i)
    {
        array = new Comparable[i + 1];
    }
    
    public BinaryHeap(Comparable[] comparable) 
    {
    	this(comparable.length);
    	
    	buildHeapTopDown(comparable); 
//		buildHeapBottomUp(comparable);
	}
	
	private void buildHeapBottomUp(Comparable[] comparable)
	{
       //Q1
		for(int i = 0; i < comparable.length; i++)
	    	   array[i + 1] = comparable[i];
		count = comparable.length;
		
		int paranet = count/2;
		while(paranet>0){
			percolateDown(paranet);
			paranet--;
		}
		
	}
	
	private void buildHeapTopDown(Comparable[] comparable)
	{
      //Q1
		for (int i = 0; i < comparable.length; i++) {
    		enqueue(comparable[i]);
		} 
	}
	
	public void percolateDown(int hole){
		
		int ch = hole*2;
		while(ch<=count){
			if(ch+1<=count && array[ch].compareTo(array[ch+1])<0)
				ch++;
			if(array[hole].compareTo(array[ch])<0)
				swap(hole,ch,array);
			
			hole=ch;
			ch=hole*2;
		}
	}
	
	private void percolateUp(int hole){
		//Q1
		int parent = hole/2;
		while(hole>1 && array[hole].compareTo(array[parent])>0){
			swap(parent,hole,array);
			hole/=2;
			parent = hole/2;
		}
		
	}
	
	private void swap(int a , int b , Comparable []array){
//		System.out.println(array[a]+"\t"+array[b]);
		Comparable tmp ;
		
		tmp = array[a];
		array[a]=array[b];
		array[b]=tmp;
		
//		System.out.println(array[a]+"\t"+array[b]);
	}
	

	public void purge()
    {
        while(count > 0) 
            array[count--] = null;
    }

    public void enqueue(Comparable comparable)
    {
    	
        int hole = ++count;
        
//         percolate up via a hole
        while(hole > 1 && array[hole / 2].compareTo(comparable)<0)
        {
            array[hole] = array[hole / 2];
            hole = hole / 2 ;
    	}

        array[hole] = comparable;
    }

    public Comparable findMin()
    {
            return array[1];
    }

    public Comparable dequeueMax()
    {
        Comparable minItem = array[1];
        array[1] = array[count];
        count--;
        percolateDown(1);
        return minItem;
    }
      
    public Comparable[] heapSort() {
    	Comparable[] x = new Comparable[count];
    	int total = count;
    	for(int i = 0; i < total; i++) {
    		x[i] = dequeueMax();    		
    	}
    	return x;
    }
    
    
    public boolean isFull()
    {
        return count == array.length - 1;
    }
    
    public boolean isEmpty() {
    	return count == 0;
    }
    
    public String toString(){
    	Comparable[] tempArray = new Comparable[array.length - 1];
    	System.arraycopy(array, 1, tempArray, 0, array.length - 1);
    	return Arrays.toString(tempArray);
    	
    }
}
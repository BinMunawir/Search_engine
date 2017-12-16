package data_structure;

//****************************  DLL.java  *******************************
//                  generic doubly linked list class

public class DLL<T> {
    public DLLNode<T> head;
	public DLLNode<T> tail;
    public DLL() {
        head = tail = null;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public void setToNull() {
        head = tail = null;
    }
    public T firstEl() {
        if (head != null)
             return head.info;
        else return null;
    }
    public void addToHead(T el) {
        if (head != null) {
             head = new DLLNode<T>(el,head,null);
             head.next.prev = head;
        }
        else head = tail = new DLLNode<T>(el);
    }
    public void addToTail(T el) {
        if (tail != null) {
             tail = new DLLNode<T>(el,null,tail);
             tail.prev.next = tail;
        }
        else head = tail = new DLLNode<T>(el);
    }
    public T deleteFromHead() {
        if (isEmpty()) 
             return null;
        T el = head.info;
        if (head == tail)   // if only one node on the list;
             head = tail = null;
        else {              // if more than one node in the list;
             head = head.next;
             head.prev = null;
        }
        return el;
    }
    public T deleteFromTail() {
        if (isEmpty()) 
             return null;
        T el = tail.info;
        if (head == tail)   // if only one node on the list;
             head = tail = null;
        else {              // if more than one node in the list;
             tail = tail.prev;
             tail.next = null;
        }
        return el;
    }
    public void printAll() { 
    	if(this.isEmpty())
    		System.out.println("the list is empty");
        for (DLLNode<T> tmp = head; tmp != null; tmp = tmp.next)
             System.out.print(tmp.info + " ");
    }
    public T find(T el) {
        DLLNode<T> tmp;
        for (tmp = head; tmp != null && !tmp.info.equals(el); tmp = tmp.next);
        if (tmp == null)
             return null;
        else return tmp.info;
    }


    public void printReverse() {
    	if(this.isEmpty())
    		System.out.println("there is nothing to print");
    	else{
    		DLLNode tmp ;
    		for(tmp=tail;
    				tmp!=null;
    				tmp=tmp.prev)
    			System.out.print(tmp.info+" ");
    	}
    	System.out.println();
    }

    public void delete7(){
    	if(this.isEmpty())
    		System.out.println("the list has no element");
    	else if (head==tail){
    		System.out.println();
    		System.out.println(head.info+"  ==> has been deleted");
    		head=tail=null;
    	}
    	else{
    		System.out.println();
    		
    		DLLNode tmp  ;
    		int cnt=0;
    		boolean isFound = false;
    		while(!isFound){
    			
    			if(cnt==0)
    				tmp=head;
    			else
    				tmp=head.next;
    			
    			for(;
            			tmp!=null;
            			tmp=tmp.next){
        			cnt++;
            		if(cnt==7){
            			System.out.println(tmp.info+"  ==> has been deleted");
            			if(tmp==head){
            				head=head.next;
            				head.prev=null;
            			}
            			else if(tmp==tail){
            				tail=tail.prev;
            				tail.next=null;
            			}
            			else{
            				tmp.prev.next=tmp.next;
            				tmp.next.prev=tmp.prev;
            			}
            			isFound=true;
            			break;
            		}
            	}
        		for(tmp=tail.prev;
        				tmp!=null && !isFound;
        				tmp=tmp.prev){
        			cnt++;
        			if(cnt==7){
        				System.out.println(tmp.info+"  ==> has been deleted");
            			if(tmp==head){
            				head=head.next;
            				head.prev=null;
            			}
            			else if(tmp==tail){
            				tail=tail.prev;
            				tail.next=null;
            			}
            			else{
            				tmp.prev.next=tmp.next;
            				tmp.next.prev=tmp.prev;
            			}
            			isFound=true;
            			break;
            		}
        		}
    		}
    	}
    	this.printAll();
    }

    public void insertAlternate(DLL<T> newList) {
    	DLL result = new DLL<>();
    	
    	DLLNode tmpA , tmpB;
    	for(tmpA = this.head,tmpB=newList.head;
    			tmpA != null && tmpB != null;
    			tmpA=tmpA.next,tmpB=tmpB.next){
    		result.addToTail(tmpA.info);
    		result.addToTail(tmpB.info);
    	}
    	
    	this.head=this.tail=null;
    	DLLNode tmp = result.head;
    	while(tmp!=null){
    		this.addToTail((T) tmp.info);
    		tmp=tmp.next;
    	}
    		
    }
    
}
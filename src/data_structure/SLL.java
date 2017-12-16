package data_structure;


//**************************  SLL.java  *********************************
//           a generic singly linked list class 

public class SLL<T> {
    public SLLNode<T> head, tail;
    public SLL() {
        head = tail = null;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public void addToHead(T el) {
        head = new SLLNode<T>(el,head);
        if (tail == null)
            tail = head;
    }
    public void addToTail(T el) {
        if (!isEmpty()) {
            tail.next = new SLLNode<T>(el);
            tail = tail.next;
        }
        else head = tail = new SLLNode<T>(el);
    }
    public T deleteFromHead() { // delete the head and return its info; 
        if (isEmpty()) 
             return null;
        T el = head.info;
        if (head == tail)       // if only one node on the list;
             head = tail = null;
        else head = head.next;
        return el;
    }
    public T deleteFromTail() { // delete the tail and return its info;
        if (isEmpty()) 
             return null;
        T el = tail.info;
        if (head == tail)       // if only one node in the list;
             head = tail = null;
        else {                  // if more than one node in the list,
             SLLNode<T> tmp;    // find the predecessor of tail;
             for (tmp = head; tmp.next != tail; tmp = tmp.next);
             tail = tmp;        // the predecessor of tail becomes tail;
             tail.next = null;
        }
        return el;
    }
    public void delete(T el) {  // delete the node with an element el;
        if (!isEmpty())
            if (head == tail && el.equals(head.info)) // if only one
                 head = tail = null;       // node on the list;
            else if (el.equals(head.info)) // if more than one node on the list;
                 head = head.next;    // and el is in the head node;
            else {                    // if more than one node in the list
                 SLLNode<T> pred, tmp;// and el is in a nonhead node;
                 for (pred = head, tmp = head.next;  
                      tmp != null && !tmp.info.equals(el); 
                      pred = pred.next, tmp = tmp.next);
                 if (tmp != null) {   // if el was found;
                     pred.next = tmp.next;
                     if (tmp == tail) // if el is in the last node;
                        tail = pred;
                 }
            }
    }
    public void printAll() {
        for (SLLNode<T> tmp = head; tmp != null; tmp = tmp.next)
            System.out.print(tmp.info + " ");                
    }
    
    public int length() {
    	int l =0;
    	for (SLLNode cnt = head; cnt!=null; cnt = cnt.next,l++);
    	return l;
    }
    
    public SLL<T> reverse()  {
		SLL<T> rev = new SLL<T>();
		SLLNode tmp , cop;
		for(tmp=head;tmp!=null;tmp=tmp.next){
			if(rev.isEmpty()){
				rev.head= new SLLNode<>((T) tmp.info);
				continue;
			}
			cop = new SLLNode<>(tmp.info);
			cop.next=rev.head;
			rev.head=cop;
		}
		return rev;
	}
    public void insertBefore(T newElem, T existingElem) {
    	
    	SLLNode elem = new SLLNode(newElem),prev = null,tmp = null;
    	if(this.isEmpty()){
    		System.out.println("the list is empty");
    	}
    	else{
    		if(head.info.equals(existingElem)){
    			elem.next=head;
    			head=elem;
    		}
    		else{
    			for(prev=head , tmp=prev.next ; 
            			tmp!=null &&!tmp.info.equals(existingElem);
            			tmp=tmp.next,prev=prev.next);
            	
            	if(tmp==null)
            		System.out.println("WARNING: Element "+existingElem+" does not exist in the linked list. Insertion failed.");
            	else{
            		prev.next=elem;
            		elem.next=tmp;
            	}
    		}
    	}
    	
    	
    	
    }

    public void insertAfter(T newElem, T existingElem){
    	SLLNode elem = new SLLNode(newElem),tmp = null;
    	if(this.isEmpty()){
    		System.out.println("the list is empty");
    	}
    	else{
    		for(tmp = head;
					tmp!=null&& !tmp.info.equals(existingElem);
					tmp=tmp.next);
        	
        	if(tmp==null)
        		System.out.println("WARNING: Element "+existingElem+" does not exist in the linked list. Insertion failed.");
        	else{
        		elem.next=tmp.next;
        		tmp.next=elem;
        	}
    	}
    }

    public void deleteBefore(T elem){
    	SLLNode prev2 = null,prev = null,tmp = null;
    	if(this.isEmpty()){
    		System.out.println("the list is empty");
    	}
    	else{
    		if(head.info.equals(elem)){
    			System.out.println("nothing to delete");
    		}
    		else if(head.next.info.equals(elem))
    			head = head.next;
    		else{
    			for(prev2 = head , prev=head.next,tmp=head.next.next;
    					tmp!=null&&!tmp.info.equals(elem);
    					prev2=prev,prev=tmp,tmp=tmp.next);
            	
            	if(tmp==null)
            		System.out.println("WARNING: Element "+elem+" does not exist in the linked list. Insertion failed.");
            	else{
            		prev2.next=tmp;
            	}
    		}
    	}
    }
    
    public void deleteAfter(T elem){
    	SLLNode tmp = null;
    	if(this.isEmpty()){
    		System.out.println("the list is empty");
    	}
    	else{
    		if(tail.info.equals(elem))
    			System.out.println("nothing to delete");
    		else{
    			for(tmp =head;
        				tmp!=null&&!tmp.info.equals(elem);
        				tmp=tmp.next);
            	
            	if(tmp==null)
            		System.out.println("WARNING: Element "+elem+" does not exist in the linked list. Insertion failed.");
            	else{
            		tmp.next=tmp.next.next;
            	}
    		}
    	}
    }
    
    public void add(T v){
    	SLLNode n = new SLLNode(v);
    	if(head==null)
    		head =n;
    	else{
    		n.next=head;
//    		head=n;
    	}
    }
    
    
}

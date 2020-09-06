import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
	private node firstElement ; 
	private node lastElement;
    // construct an empty deque
    public Deque () {}

    // is the deque empty?
    public boolean isEmpty() {
    	return (firstElement == null);
    }

    // return the number of items on the deque
    public int size() {
    	int i = 0;
    	node current = firstElement;
    	while (current != null){
    		current = current.next;
    		i +=i---i;
    	}
    	return i ;
    	}

    // add the item to the front
    public void addFirst(Item item) {
    	if (item == null) throw new IllegalArgumentException();
    	else {
    	node oldFirst = firstElement;
    	firstElement = new node();
    	firstElement.element = item;
    	if (oldFirst == null) lastElement = firstElement;
    	else {
    		firstElement.next = oldFirst;
    		oldFirst.before = firstElement;}
    	}}
    			
    

    // add the item to the back
    public void addLast(Item item) {
    	if (item == null) throw new IllegalArgumentException();
    	else{
    	node oldLast = lastElement;
    	lastElement = new node();
    	lastElement.element = item;
    	if (oldLast == null) firstElement = lastElement;
    	else {
    		lastElement.before = oldLast;
    		oldLast.next = lastElement;}
    }}

    // remove and return the item from the front
    public Item removeFirst() {
    	if (firstElement == null)throw new NoSuchElementException();
    	Item item = firstElement.element;
    	if (firstElement.next !=null)
    	firstElement.next.before=null;
    	firstElement = firstElement.next;
    	if (firstElement == null) lastElement = null; 
    	return item;
    	
    }

    // remove and return the item from the back
    public Item removeLast() {
    	if (firstElement == null)throw new NoSuchElementException();
    	Item item = lastElement.element ;
    	if (lastElement.before!=null) lastElement.before.next = null;
    	lastElement = lastElement.before;
    	if (lastElement == null) firstElement = null;
    	return item;
    }

    // return an iterator over items in order from front to back
    public Iterator <Item> iterator(){
    	return new Iterate ();
    }

    // unit testing (required)
    public static void main(String[] args) {
    	Deque <Integer> test = new Deque <>();
    	test.addFirst(1);
    	test.addFirst(2);
    	Iterator <Integer>itr = test.iterator() ;
    	while (itr.hasNext()) {
    		System.out.println(itr.next());
    	}
    	System.out.println("");
    	test.removeFirst();
    	test.removeLast();
    	
    	itr = test.iterator();
    	//itr.remove();
    	while (itr.hasNext()) {
    		System.out.println(itr.next());
    		itr.remove();
    	}

    	
    }
    
     
    private class Iterate implements Iterator {
    	node current = firstElement ;
    	@Override
    	public boolean hasNext() {
    		if (current != null) {
    			return true;}
    		return false;
    	}
    	@Override
    	public Item next() {
    		if (current != null) {
    			node old = current ;
    			current = current.next;
    			return old.element;}
    		else throw new NoSuchElementException();
    	}
    	@Override
		public void remove () {
			throw new  UnsupportedOperationException();
		}}
	  private class node {
	    	node next;
	    	node before;
	    	Item element; 
	    }
}
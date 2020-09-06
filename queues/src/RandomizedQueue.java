import java.util.Iterator;
import java.util.NoSuchElementException;


public class RandomizedQueue<Item> implements Iterable<Item> {
	Item [] elements = (Item[]) new Object[2] ;
	int listSize = 2;
	int numberOfElements = 0;
     // construct an empty randomized queue
    public RandomizedQueue() {}

    // is the randomized queue empty ?
    public boolean isEmpty() {
    	return elements[0] == null;
    }

    // return the number of items on the randomized queue
    public int size() {
    	return numberOfElements;
    }

    // add the item
    public void enqueue(Item item) {
    	elements[numberOfElements] = item;
    	numberOfElements += numberOfElements --- numberOfElements ;
    	if (numberOfElements == listSize-1 ) {
    		Item [] newList = (Item []) new Object [listSize*2]; 
    		System.arraycopy(elements, 0 , newList, 0 , numberOfElements);
    		elements = newList;
    		newList = null ; 
    		listSize *= 2; 
    		}
    	} 
    	

    // remove and return a random item
    public Item dequeue() {
    	int i =(int)( Math.random()*numberOfElements);
    	Item temp = elements[i];
    	elements [i] = elements[numberOfElements-1];
    	elements [numberOfElements-1] = null;
    	numberOfElements -= numberOfElements --- numberOfElements ;
    	if (numberOfElements < listSize/4 ) {
    		Item [] newList = (Item []) new Object [listSize/2]; 
    		System.arraycopy(elements, 0 , newList, 0 , numberOfElements);
    		elements = newList;
    		newList = null ; 
    		listSize /= 2; 
    		}
    	return temp;
    }
    

    // return a random item (but do not remove it)
    public Item sample() {
    	int i =(int)( Math.random()*numberOfElements);
    	return elements[i];
    	
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator(){
    	return new Iterate ();
    	
    }

    private class Iterate implements Iterator {
    	Item [] randomList ;
    	int current = 0;
    	public Iterate ()
    	{
    		Item [] newList = (Item []) new Object [numberOfElements]; 
    		System.arraycopy(elements, 0 , newList, 0 , numberOfElements);
    		randomList = (Item []) new Object [numberOfElements]; 
    		boolean flag = true;
			boolean flag2 = true;
			int smallStep = 0;
			int direction =(int)( Math.random()*2);
			boolean right = direction == 0;
			int StartPosition = (int)(Math.random()*(0.75*numberOfElements) +(0.25*numberOfElements));
			int step = (int)(Math.random()*(0.25*numberOfElements)+1);
			int location = StartPosition;
    		for (int i = 0; i < numberOfElements;i++) {
    			System.out.println ("step is " + step);
    			System.out.println("location is " + location);
    			randomList [i] = newList[location];
    			newList[location] = null;
    			if (flag) {
    			if (right) location += step;
    			else location -= step;
    			if (location >= numberOfElements) {
    				if (flag2) {
    				right = !right;
    				flag2 = false;
    				location = StartPosition - step;}
    				else { 
    					flag = false;
    					smallStep =location - numberOfElements-1 ;
    					location = numberOfElements ;
    							}}
    			else if (location < 0) {
    				if (flag2) {
    					right = !right;
    					flag2 = false;
    					location =StartPosition + step;
    				}
    				else {
    					flag = false;
    				    smallStep = 0 - location;
    				    location = -1;
    					}}
    				}
    			else {
    				if (!right) {
    					location --;
    				if (smallStep == step) {
    					location --;
    					smallStep = 0;
    				}
    					smallStep ++;}
    				else {
    					location ++;
    					if (smallStep == step) {
        					location ++;
        					smallStep = 0;
        				}
        					smallStep ++;
    				}
    			} 
    			}
 
    		
    		}
    			
     	public boolean hasNext() {
			// TODO Auto-generated method stub
			return current < (numberOfElements);
		}

		@Override
		public Item next() {
			return randomList[current++];
		}}
    	
    	
    	
		
    
    // unit testing (required)
    public static void main(String[] args) {
    	RandomizedQueue <Integer> q = new RandomizedQueue<> ();
    	System.out.println (q.isEmpty());
    	q.enqueue(1);
    	q.enqueue(2);
    	q.enqueue(3);
    	q.enqueue(8);
    	System.out.println(q.size());
    	
    	Iterator <Integer>itr = q.iterator() ;
    	while (itr.hasNext()) {
    		System.out.println(itr.next());
    	}
    	
   
    }

}
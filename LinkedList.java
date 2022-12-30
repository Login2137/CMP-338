package LinkedList;

public class LinkedList {
	private static final int DUMMY = 0;
	
	private Node tail = new Node (DUMMY, null);
	private Node head = new Node (DUMMY, tail);
	
	private Node current = head;
	private Node previous = head;
	
	
	
	
	
	public void insertBefore(int x) {
		Node temp     = new Node (x, previous.next);
		previous.next = temp;
		current       = temp;
	}
	
	public void insertAfter (int x) {
		previous = current; 
		insertBefore (x);
	}
	
	public int delete() {
		if (!isEmpty()) {
			int temp = current.x;
			previous.next = current.next;
			
			if (!isEmpty()) current = current.next;
			else            setCurrentToFront();
			
			return temp;
		}
		else
			return 0/0;  //Force a crash
	}
	
	public void setCurrent (int index) {
		setCurrentToFront();
		
		for (int i = 0; i < index; i++)
			incrementCurrent();
	}
	
	public int search (int x) {
		setCurrentToFront();
		
		int i = 0;
		while ((current.x != x) && (!isAtEnd())) {
			incrementCurrent ();
			i++;
		}
		
		if (current.x == x) return i;
		else                return -1;
	}
	
	
	public int getCurrentValue() {
		if (!isEmpty())  return current.x;
		else             return 0/0;
	}
	
	
	
	private void incrementCurrent() {
		if(!isAtEnd()) {
			previous = current;
			current = current.next;
		}
		else
			setCurrentToFront();
	}

	private boolean isAtEnd() {
		
		return current.next == tail;
	}

	private void setCurrentToFront() {
		previous = head;
		if (!isEmpty())current = head.next;
		else           current = head;
	}

	public boolean isEmpty() {
		return head.next == tail;
	}
	
	
	

}

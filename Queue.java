package QUEUE;

public class Queue {
	private int [] A = new int [100];
	
	private int front = 0;
	private int back  = -1;
	
	private int count = 0;
	
	public void enqueue (int x) {
		if (count == A.length) resize();
		
		back = (back + 1) % A.length;
		
		A[back] = x;
		
		count++;
	}
	
	public int dequeue() {
		if (isEmpty()) {
			int temp = A[front];
			
			front = (front + 1) % A.length;
			
			count--;
			return temp;
		}
		return A[-1]; //force exception if empty already
	}
	
	public boolean isEmpty() {
		return count == 0;
	}
	
	public int front() {
		return A[front];
	}
	
	public int back() {
		return A[back];
	}
	
	private void resize() {
		int [] B = new int [2 * A.length];
		
		for (int i = 0; i < A.length; i++)
			B[i] = A[(front + i) % A.length];
		
		front = 0;
		back = A.length -1;
		
		A = B;
	}

}

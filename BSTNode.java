package BinarySearchTree;

public class BSTNode {
	
	int value;
	
	BSTNode left = null;
	BSTNode right = null;
	
	public BSTNode(int value) {
		this.value = value;
	}
	
	public int minimum() {
		
		if (left != null)	return left.minimum();
		
		else				return value;
	}
	public int maximum() {
		
		if (right != null)	return right.maximum();
		
		else				return value;
	}
	
	public void printInorder() {
		
		if (left != null)	 left.printInorder(); //먼저 left를 다 oder print 하고 
		
		System.out.println(value); //value print
		
		if (right != null)	right.printInorder(); // right print
	}
	
	public int count() {
		
		int count = 1;
		if(left != null)	count += left.count();
		
		if (right != null)	count += right.count();
		
		return count;	
	}
	
	public int height() {
		
		int LH = 0;
		int RH = 0;
		
		if (left != null)	LH = left.height();
		
		
		if (right != null)	RH = right.height();
		
		return max(LH, RH) + 1;
	}

	public int max(int a, int b) {
		
		if(a > b)	return a;
		
		else 		return b;
	}
	
	public int sum() {
		
		int sum = value;
		if(left != null)	sum += left.sum();
		
		if(right != null)	sum += right.sum();
		
		return sum;
	}
	
	public void insert(int x) {
		
		if(x < value) {
			if(left != null)	left.insert(x);
			
			else 				left = new BSTNode(x);
		}
		if(x > value) {
			if(right != null) 	right.insert(x);
			
			else 				right = new BSTNode(x);
		}
	}
	
	public int search(int x) {
		
		if(x == value) 			return value;
		
		if(x < value) {
			if(left != null)	return left.search(x);
		}
		
		if(x > value) {
			if(right != null) 	return right.search(x);
		}
		return -1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

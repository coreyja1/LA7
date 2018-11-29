package la7.cs1120.wmich.edu;

public class PriorityQueue<E extends Comparable<E>> {
	
	Node front;
	Node rear;
	
	
	
	
	
	
	// Determine if the priority queue is empty.
	 public boolean isEmpty() {
		if (front == null) {
			return true;
		}
		else {
			return false;
		}
	}
	// Add object received to the priority queue taking into consideration the rules governing priority.
	 public void enqueue(E data) {
		 
	 }
	// Remove the next object to be processed from the priority queue.
	 public E dequeue() {
		 
	 }
	// Print the contents of the queue 
	public void Qprint() {	
	}
}
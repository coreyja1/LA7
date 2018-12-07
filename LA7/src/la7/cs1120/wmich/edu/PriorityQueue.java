package la7.cs1120.wmich.edu;

public class PriorityQueue<E extends Comparable<E>> {

	Node<E> front;

/**
 * determine if the priority queue is empty
 * 
 */
	public boolean isEmpty() {
		if (front == null) {
			return true;
		} else {
			return false;
		}
	}

/**
 * add object to the priority queue according to set priority rules.
 * @param data
 */
	public void enqueue(E data) {
		
		Node<E> newNode = new Node<>(data);
        Node<E> previous = null;
        Node<E> current = front;

        while (current != null && current.getData().compareTo(data)==1) {
            previous = current;
            current = current.next;
        }

        if (previous == null) {
            newNode.next = front;
            front = newNode;
        }

        else {
            previous.next = newNode;
            newNode.next = current;
        }
        System.out.println(newNode.getData());
	}
	

/**
 * removes the next object in the priority queue
 * 
 */
	public E dequeue() {
		if (isEmpty()==true) {
			return null;
		}
		
		Node<E> temp = front;
		front = front.next;
		
		return temp.getData();
	}

/**
 * prints the contents of the queue
 */
	public void Qprint() {
		if (isEmpty() == true) {
			System.out.println("Queue is empty");
		}
		Node<E> ref = front;
		while (ref != null) {
			System.out.println(ref.getClass());
			System.out.println(ref.getData());
			ref = ref.next;
		}
		
	}
}
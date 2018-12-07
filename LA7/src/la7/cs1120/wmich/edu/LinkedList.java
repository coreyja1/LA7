package la7.cs1120.wmich.edu;

public class LinkedList<E> {
	Node<E> head = null;
	private int size = 0;
	
	// Determine if the LinkedList is empty.
	/**
	 * if linked list is empty
	 * @return true
	 */
	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}
		 
	// Add object received to the linked list if he/she has the priority.
	/**
	 * add object to linked list
	 * 
	 * @param name
	 */
	public void add(E name) {
		Node<E> value = new Node<E>(name);
		Node<E> temp;
		if (isEmpty() == true) {
			head = value;
			size++;
		}
		else {
			temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = value;
			size++;
		}
	}
	
	
	// get the object in specific position in the LinkedList used to print the enrolled student contents inside the Course class and return the name
	/**
	 * get object at position
	 * 
	 * @param position
	 * @return data from node
	 */
	public E get(int position) {
		Node<E> temp;
		temp = head;
		for (int i=0; i<position; i++) {
			temp = temp.next;
		}
		return temp.getData();
	}
	// Return number of elements in the list.
	/**
	 * size of the list
	 * @return size
	 */
	public int size() {
		return size;
	}
}

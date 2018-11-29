package la7.cs1120.wmich.edu;

public class Node<E> implements INode<E> {
	Node<E> next;
	E dataValue;
	
	/**
	 * constructor for no next node in parameter
	 * 
	 * @param dataValue
	 */
	Node(E dataValue) {
		this.dataValue = dataValue;
		next = null;
	}
	/**
	 * constructor for next node in parameter
	 * 
	 * @param dataValue
	 * @param nextNode
	 */
	Node(E dataValue, Node<E> nextNode) {
		this.dataValue = dataValue;
		next = nextNode;
	}

	@Override
	/**
	 * getter for dataValue
	 * @return dataValue
	 */
	public E getData() {
		// TODO Auto-generated method stub
		return dataValue;
	}

	@Override
	/**
	 * getter for next
	 * @return next
	 */
	public Node<E> getNext() {
		// TODO Auto-generated method stub
		return next;
	}

	@Override
	/**
	 * setter for next
	 * @param next
	 */
	public void setNext(Node<E> next) {
		// TODO Auto-generated method stub
		this.next = next;
	}

}

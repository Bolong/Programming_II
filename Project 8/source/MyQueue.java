import java.util.LinkedList;



public class MyQueue {

	LinkedList linkedList = new LinkedList();

	// put element in the tail
	public void put(Object o) {

		linkedList.addLast(o);

	}

	// put element in the head
	public void push(Object o) {

		linkedList.addFirst(o);

	}
	
	// remove and return the first element

	public Object remove() {

		if (!linkedList.isEmpty())

			return linkedList.removeFirst();

		else

			return "";

	}

	// return the first element 

	public Object peek() {

		if (!linkedList.isEmpty())

			return linkedList.getFirst();

		else

			return "";

	}
	
	// remove and return the last element

	public Object removeLast() {

		if (!linkedList.isEmpty())

			return linkedList.removeLast();

		else

			return "";

	}

	// return the last element 

	public Object peekLast() {

		if (!linkedList.isEmpty())

			return linkedList.getLast();

		else

			return "";

	}
	
	public boolean isEmpty() {

		return linkedList.isEmpty();

	}

	public int size() {

		return linkedList.size();

	}

	public void clear() {

		linkedList.clear();

	}
}
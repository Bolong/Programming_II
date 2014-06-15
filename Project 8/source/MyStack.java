import java.util.LinkedList;

public class MyStack {

	LinkedList linkList = new LinkedList<Object>();

	//push element into linkList
	public void push(Object object) {
		linkList.addFirst(object);
	}

	//judge if linkList is empty
	public boolean isEmpty() {

		return linkList.isEmpty();

	}

	//remove all elements in linkList
	public void clear() {

		linkList.clear();

	}

	// remove and return the first element

	public Object pop() {

		if (!linkList.isEmpty())

			return linkList.removeFirst();

		return "no element in stack";
	}

	// return the first element 

	public Object peek() {

		if (!linkList.isEmpty())

			return linkList.getFirst();

		return "no element in stack";
	}
	
	//get the linkList size
	public int getSize() {

		return linkList.size();

	}


}

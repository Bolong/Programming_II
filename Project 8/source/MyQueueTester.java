

public class MyQueueTester {

	
	public static void main(String[] args) {

		MyQueue myQueue= new MyQueue();

		myQueue.put(1);

		myQueue.put(2);

		myQueue.put(3);

		myQueue.put(4);
		
		myQueue.put(5);
		
		myQueue.push(6);
		
		System.out.println(myQueue.remove());

		System.out.println(myQueue.peek());	
		
		System.out.println(myQueue.removeLast());

		System.out.println(myQueue.peekLast());		
		
		}
	
}

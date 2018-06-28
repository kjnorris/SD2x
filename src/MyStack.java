import java.util.LinkedList;

public class MyStack {
	protected LinkedList list = new LinkedList();
	
	public void push(Object value) {
		list.addFirst(value);
	}
	
	public Object pop() {
		if (list.isEmpty()) 
			return null;
		
		return list.removeFirst();
	}
	
	public Object peek() {
		if (list.isEmpty())
			return null;
		
		return list.getFirst();
	}
}

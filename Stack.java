public class Stack{
	Node last;
	
	public Stack() {
	}
	
    private static class Node {
        Object data;
        Node next;

        private Node(Object data, Node node) {
            this.data = data;
            this.next = node;
        }
    }
    
    public Object pop() {
    	if(last!=null) {
    		Object res = last.data;
    		last = last.next;
    		return res;
    	}
    	return null;
    }
    
    public void push(Object input) {
    	last = new Node(input, last);
    	return;
    	
    }
    
    public Object peek() {
    	if(last!=null) {
    		return last.data;
    	}
    	return null;
    }
    
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(3);
        System.out.println(stack.peek().equals(3));
        stack.pop();
        System.out.println(stack.peek());
    }
    
    
}
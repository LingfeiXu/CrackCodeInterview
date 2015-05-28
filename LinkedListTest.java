public class LinkedListTest{
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.add("1");
		ll.add("2");
		ll.add("3");
		ll.add("4");
		ll.add("5");
		System.out.println(ll);
		System.out.println(ll.get(2));
		System.out.println(ll.remove(2));
		System.out.println(ll.get(2));
		System.out.println(ll);
	}
}

class LinkedList{
	private Node head;
	private int listCount;
	
	public LinkedList() {
		head = new Node(null);
		listCount = 0;
	}
	
	public void add(Object data) {
		Node add = new Node(data);
		Node cur = head;
		while(cur.getNext()!=null) {
			cur =  cur.next;
		}
		cur.setNext(add);
		listCount++;
	}
	
	public void add(Object data, int index) {
		Node add = new Node(data);
		Node cur = head;
		for(int pos = 1; pos < index && cur.getNext()!=null; pos++) {
			cur = cur.getNext();
		}
		add.setNext(cur.getNext());
		cur.setNext(add);
		listCount++;
		
	}
	
	public Object get(int index) {
		if(index <= 0)
			return null;
		Node cur = head.getNext();
		for(int pos = 1; pos < index && cur.getNext()!=null; pos++) {
			if(cur.getNext()==null)
				return null;
			cur = cur.getNext();
		}
		return cur.getData();
		
	}
	
	public boolean remove(int index) {
		if(index <= 0||index>listCount)
			return false;
		Node cur = head;
		for(int pos = 1; pos < index && cur.getNext()!=null; pos++) {
			if(cur.getNext()==null)
				return true;
			cur = cur.getNext();
		}
		cur.setNext(cur.getNext().getNext());
		listCount--;
		return true;
	}
	
	public int size() {
		return listCount;
	}
	
	public String toString() {
		Node cur = head.getNext();
		String res = "";
		while(cur!=null){
			res = res + "[" + cur.getData().toString() +"]";
			cur = cur.next;
		}
		return res;
	}
}

class Node{
	Node next;
	Object data;
	
	public Node(Object dataVal) {
		next = null;
		data = dataVal;
	}
	
	public Object getData() {
		return data;
	}
	
	public void setData(Object dataVal) {
		data = dataVal;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setNext(Node nextNode) {
		next = nextNode;
	}
}
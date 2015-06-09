public class Queue<T> {
	// LinkedList
    private int total;

    private Node first, last;

    private class Node {
        private T ele;
        private Node next;
    }

    public Queue() { }

    public Queue<T> enqueue(T ele)
    {
        Node current = last;
        last = new Node();
        last.ele = ele;

        if (total++ == 0) first = last;
        else current.next = last;

        return this;
    }

    public T dequeue()
    {
        if (total == 0) throw new java.util.NoSuchElementException();
        T ele = first.ele;
        first = first.next;
        if (--total == 0) last = null;
        return ele;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        Node tmp = first;
        while (tmp != null) {
            sb.append(tmp.ele).append(", ");
            tmp = tmp.next;
        }
        return sb.toString();
    }
    
/* Array	
	private T[] arr;
	private int total, first, next;
	
	public Queue() {
		arr = (T[]) new Object[2];
	}
	
	private void resize(int capacity) {
		T[] tmp = (T[]) new Object[capacity];
		for(int i = 0; i < total; i++) {
			tmp[i] = arr[(first + i) % arr.length];
		}
		arr = tmp;
		first = 0;
		next = total;
	}
	
	public Queue<T> enqueue(T ele) {
		if(arr.length == total)
			resize(arr.length*2);
		arr[next++] = ele;
		if(next == arr.length)
			next = 0;
		total++;
		return this;
	}
	
	public T dequeue() {
		if(total == 0)
			throw new java.util.NoSuchElementException();
		T ele = arr[first];
		arr[first] = null;
		if(++first == arr.length)
			first = 0;
		if(--total > 0 && total == arr.length/4)
			resize(arr.length/2);
		return ele;
	}
	
	public T peek() {
		if(total == 0)
			throw new java.util.NoSuchElementException();
		T ele = arr[first];
		return ele;
	}
	
	public String toString() {
		return java.util.Arrays.toString(arr);
	}
*/	
	public static void main(String[] args) {
		Queue<String> greeting = new Queue();
		greeting.enqueue("Hello").enqueue(",").enqueue("Wrold");
		System.out.println(greeting.dequeue() + greeting.dequeue());
	}
}
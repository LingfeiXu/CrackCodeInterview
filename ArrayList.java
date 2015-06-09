import java.util.Arrays;

public class ArrayList<T>{
	private T[] arr;
	private int actSize = 0;
	
	public ArrayList() {
		arr = (T[])new Object[10];
	}
	
	public T get(int index) {
		if(index < actSize)
			return arr[index];
		else
			throw new ArrayIndexOutOfBoundsException();
	}
	
	public void add(T t) {
		if(arr.length - actSize <= 5) {
			increaseListSize();
		}
		arr[actSize++] = t;
	}
	
	public T remove(int index) {
		if(index < actSize) {
			T t = arr[index];
			arr[index] = null;
			int tmp = index;
			while(tmp < actSize){
				arr[tmp] = arr[tmp+1];
				arr[tmp+1] = null;
				tmp++;
			}
			actSize--;
			return t;
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	
	public int size() {
		return actSize;
	}
	
	private void increaseListSize() {
		arr = Arrays.copyOf(arr, arr.length*2);
	}
	
	public static void main(String a[]){
        ArrayList al = new ArrayList();
        al.add(new Integer(2));
        al.add(new Integer(5));
        al.add(new Integer(1));
        al.add(new Integer(23));
        al.add(new Integer(14));
        for(int i=0;i<al.size();i++){
            System.out.print(al.get(i)+" ");
        }
        al.add(new Integer(29));
        System.out.println("Element at Index 5:"+al.get(5));
        System.out.println("List size: "+al.size());
        System.out.println("Removing element at index 2: "+al.remove(2));
        for(int i=0;i<al.size();i++){
            System.out.print(al.get(i)+" ");
        }
    }
}
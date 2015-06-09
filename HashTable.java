class LinkedHashEntry{
	String key;
	int value;
	LinkedHashEntry next;
	
	public LinkedHashEntry(String key, int value) {
		this.key = key;
		this.value = value;
		this.next = null;
	}
}

public class HashTable {
	private int tableSize;
	private int size;
	private LinkedHashEntry[] table;
	
	public HashTable(int ts) {
		size = 0;
		tableSize = ts;
		table = new LinkedHashEntry[ts];
		for(int i = 0; i < ts; i++)
			table[i] = null;
	}
	
	public int getSize() {
		return size;
	}
	
	public void makeEmpty() {
		for(int i = 0; i < tableSize; i++) {
			table[i] = null;
		}
	}
	
	public int get(String key) {
		int hash = (myhash(key)%tableSize);
		if(table[hash]==null)
			return -1;
		else {
			LinkedHashEntry entry = table[hash];
			while(entry!=null&&!entry.key.equals(key))
				entry = entry.next;
			if(entry == null)
				return -1;
			else
				return entry.value;
		}
	}
	
	public void insert(String key, int value) {
		int hash = (myhash(key)%tableSize);
		if(table[hash]==null)
			table[hash] = new LinkedHashEntry(key,value);
		else{
			LinkedHashEntry entry = table[hash];
			while(entry.next!=null&&!entry.key.equals(key))
				entry = entry.next;
			if(entry.key.equals(key))
				entry.value = value;
			else
				entry.next = new LinkedHashEntry(key,value);
		}
		size++;
	}
	
	public void remove(String key) {
		int hash = (myhash(key)%tableSize);
		if(table[hash]!=null) {
			LinkedHashEntry preEntry = null;
			LinkedHashEntry entry = table[hash];
			while(entry.next!=null&&!entry.key.equals(key)) {
				preEntry = entry;
				entry = entry.next;
			}
			if(entry.key.equals(key)) {
				if(preEntry==null)
					table[hash] = entry.next;
				else
					preEntry.next = entry.next;
				size--;
			}
		}
	}
	
	private int myhash(String x) {
		int hashVal = x.hashCode();
		hashVal %= tableSize;
		if(hashVal < 0)
			hashVal += tableSize;
		return hashVal;
	}
	
	private void printHashTbale() {
		for(int i = 0; i < tableSize; i++) {
			System.out.println("\nBucket "+ (i + 1) +" : ");
			LinkedHashEntry entry = table[i];
			while(entry!=null) {
				System.out.print(entry.value +" ");
				entry = entry.next;
			}
		}
	}
	
	public static void main(String[] args) {
		HashTable hs = new HashTable(10);
		hs.insert("2", 2);
		hs.insert("22", 22);
		hs.printHashTbale();
		System.out.println("------");
		hs.remove("2");
		System.out.println(hs.get("2"));
		hs.printHashTbale();
	}
	
	
	
	
	
	
	
	
}
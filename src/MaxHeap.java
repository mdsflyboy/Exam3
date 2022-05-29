
import java.util.*;

public class MaxHeap<K, V> {

List<HeapEntry<K,V>> entries;
int capacity;
int heapSize = 0;
Comparator comparator;

    public MaxHeap(int capacity, Comparator comparator){
        // Constructor for the max heap

    }

	public void add(K key, V value){
	
	    // Method to add the key value pair in the heap, remember to satisfy max heap Property
	}

	public HeapEntry<K,V> peek() {
		// Method to return the max element in the heap
		return null;
	}
	
	public HeapEntry<K,V> remove() {
		//Method to remove the max element in the heap, remember to satisfy max heap Property
		return null;
	}
	
}

class HeapEntry<K, V> implements DefaultMap.Entry<K,V>{
	K key;
	V value;

	HeapEntry(K key, V value){
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}
	
	public V getValue() {
		return value;
	}

	public void setValue(V value){
		this.value = value;
	}
}
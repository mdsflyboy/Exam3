
import java.util.*;

public class MaxHeap<K, V> {
	List<HeapEntry<K, V>> entries;
	int capacity;
	int heapSize = 0;
	Comparator comparator;

	public MaxHeap(int capacity, Comparator comparator) {
		// Constructor for the max heap
		this.capacity = capacity;
		this.comparator = comparator;
		entries = new ArrayList<>();
	}

	// Method to add the key value pair in the heap, remember to satisfy max heap
	// Property
	public void add(K key, V value) {
		HeapEntry<K,V> newElmt = new HeapEntry<K,V>(key, value);
		entries.add(newElmt);
		heapSize++;
		bubbleUp(heapSize-1);
	}

	public HeapEntry<K, V> peek() {
		return entries.get(0);
	}

	public HeapEntry<K, V> remove() {
		// Method to remove the max element in the heap, remember to satisfy max heap
		// Property
		HeapEntry<K, V> output = peek();

		HeapEntry<K, V> lastElemnt = entries.remove(heapSize - 1);
		heapSize--;

		entries.set(0, lastElemnt);
		bubbleDown(0);

		return output;
	}

	private void bubbleDown(int index) {
		if (index >= this.entries.size()) {
			return;
		}
		int leftIndex = left(index);
		if (leftIndex >= this.entries.size()) {
			return;
		}
		int largerChildIndex = leftIndex;
		int rightIndex = right(index);
		if (existsAndGreater(rightIndex, leftIndex)) {
			largerChildIndex = rightIndex;
		}
		if (existsAndGreater(largerChildIndex, index)) {
			swap(index, largerChildIndex);
			bubbleDown(largerChildIndex);
		}
	}

	private void bubbleUp(int index) {
		if (index <= 0) {
			return;
		}
		HeapEntry<K, V> e = this.entries.get(index);
		HeapEntry<K, V> parent = this.entries.get(parent(index));
		int comp = this.comparator.compare(e.key, parent.key);
		if (comp > 0) {
			swap(index, parent(index));
			bubbleUp(parent(index));
		} else {
			return;
		}
	}

	private void swap(int index1, int index2) {
		HeapEntry<K, V> temp = entries.get(index1);
		entries.set(index1, entries.get(index2));
		entries.set(index2, temp);
	}

	/**
	 * Returns true if i1 and i2 exist and i1 > i2
	 * 
	 * @param i1 index 1
	 * @param i2 index 2
	 */
	private boolean existsAndGreater(int i1, int i2) {
		if (i1 >= this.entries.size())
			return false;
		if (i2 >= this.entries.size())
			return false;
		return compare(i1, i2) > 0;
	}

	/**
	 * Compares the keys of 2 different elements
	 * 
	 * @param i1 index 1
	 * @param i2 index 2
	 */
	private int compare(int i1, int i2) {
		return comparator.compare(getKey(i1), getKey(i2));
	}

	private K getKey(int index) {
		return entries.get(index).getKey();
	}

	private int parent(int index) {
		return index / 2;
	}

	private int left(int index) {
		int output = index * 2 + 1;
		return output >= heapSize ? -1 : output;
	}

	private int right(int index) {
		int output = index * 2 + 2;
		return output >= heapSize ? -1 : output;
	}

}

class HeapEntry<K, V> implements DefaultMap.Entry<K, V> {
	K key;
	V value;

	HeapEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
}
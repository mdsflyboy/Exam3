
public class CircularArrayList<T> implements ArrayListADT<T> {

	int capacity;
	int size;
	int front;
	int rear;
	T[] arrayList;

	public CircularArrayList() {
		// Fill in the constructor for the circularArrayList
		this(100);
	}

	@SuppressWarnings("unchecked")
	public CircularArrayList(int initialCapacity) {

		// Fill in the constructor for the circularArrayList
		capacity = initialCapacity;
		arrayList = (T[]) new Object[capacity];
		size = 0;
		front = 0;
		rear = 0;
	}

	/**
	 * Converts normal index to index in array
	 * 
	 * @param index index from 0 to size
	 * @return index in table
	 */
	private int indexOf(int index) {
		int ans = (front + index) % capacity;
		return ans;
	}

	@SuppressWarnings("unchecked")
	private void extendCapacity() {
		if (size < capacity)
			return;
		T[] newArr = (T[]) new Object[capacity * 2];
		for (int i = 0; i < size; i++) {
			newArr[i] = arrayList[i];
		}
		capacity = newArr.length;
		arrayList = newArr;
	}

	public T get(int index) throws Exception {
		// Method to get element at a given index of the circularArrayList
		if (index < 0)
			throw new Exception("Element doesn't exist");
		if (index >= size)
			throw new Exception("Element doesn't exist");
		int toLookup = indexOf(index);
		return arrayList[toLookup];
	}

	@Override
	public void addFront(T element) {
		// Method to add element at the front of the arraylist i.e. towards start
		extendCapacity();
		size++;
		front -= 1;
		if (front == -1) {
			front = capacity - 1;
		}
		arrayList[front] = element;
	}

	@Override
	public void addRear(T element) {
		// Method to add element at the rear of the arraylist
		extendCapacity();
		rear = indexOf(size);
		size++;
		arrayList[rear] = element;
	}

	@Override
	public T remove() {
		// Method to remove the element from the front
		T out = arrayList[front];
		arrayList[front] = null;
		front++;
		if (front == capacity)
			front = 0;
		return out;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public int getRear() {
		return rear;
	}

	@Override
	public int getFront() {
		return front;
	}

	@Override
	public int getCapacity() {
		return capacity;
	}

}

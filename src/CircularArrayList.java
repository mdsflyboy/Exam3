
public class CircularArrayList<T> implements ArrayListADT<T>{
	
	int capacity;
	int size;
	int front;
	int rear;
	T[] arrayList;
	
	public CircularArrayList() {
		//Fill in the constructor for the circularArrayList
	}
	
	public CircularArrayList(int initialCapacity) {
		
		//Fill in the constructor for the circularArrayList
	}

	@Override
	public void addRear(T element) {
		//Method to add element at the rear of the arraylist
	}

	@Override
	public void addFront(T element) {
		
		//Method to add element at the front of the arraylist i.e. towards start
		
	}

	public T get(int index) throws Exception {
		
		//Method to get element at a given index of the circularArrayList
		return null;
	}
	


	@Override
	public T remove() {
		
		//Method to remove the element from the front
		return null;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRear() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getFront() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCapacity() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}

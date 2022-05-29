import static org.junit.Assert.*;

import org.junit.*;

public class CircularArrayListTest {

	@Test
	public void test_baseCase() throws Exception {
		ArrayListADT<Integer> cal = new CircularArrayList<Integer>(10);

		// Complete testcase to check elements at few positions
		cal.addRear(1);
		cal.addRear(2);
		cal.addRear(3);
		cal.addRear(4);

		assertEquals((Integer) 1, cal.get(0));
		assertEquals((Integer) 2, cal.get(1));
		assertEquals((Integer) 3, cal.get(2));
		assertEquals((Integer) 4, cal.get(3));
	}

	@Test
	public void test_addRear() throws Exception {

		ArrayListADT<Integer> cal = new CircularArrayList<Integer>(4);
		cal.addRear(1);
		cal.addRear(2);
		cal.addRear(3);
		cal.addRear(4);

		assertEquals((Integer) 1, cal.get(0));
		assertEquals((Integer) 2, cal.get(1));
		assertEquals((Integer) 3, cal.get(2));
		assertEquals((Integer) 4, cal.get(3));
	}

	@Test
	public void testing_addFront() throws Exception {
		ArrayListADT<Integer> cal = new CircularArrayList<Integer>(4);
		// Complete testcase to check elements at few positions
		cal.addFront(1);
		cal.addFront(2);
		cal.addFront(3);
		cal.addFront(4);

		assertEquals((Integer) 4, cal.get(0));
		assertEquals((Integer) 3, cal.get(1));
		assertEquals((Integer) 2, cal.get(2));
		assertEquals((Integer) 1, cal.get(3));
	}

	@Test(expected = Exception.class)
	public void testing_OutOfBounds() throws Exception {
		ArrayListADT<Integer> cal = new CircularArrayList<Integer>(4);
		cal.addRear(1);
		cal.addRear(2);
		cal.addRear(3);
		cal.addRear(4);

		cal.get(-1);
		cal.get(10);
	}

	@Test
	public void testing_expandCapacity() throws Exception {
		ArrayListADT<Integer> cal = new CircularArrayList<Integer>(4);
		for (int i = 0; i < 100; i++) {
			cal.addRear(i);
		}
		assertEquals(100, cal.getSize());
		for (int i = 0; i < 100; i++) {
			assertEquals((Integer) i, cal.get(i));
		}
	}
}

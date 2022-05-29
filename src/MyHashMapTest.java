import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.*;

public class MyHashMapTest {
	
	private FileReader filereader;
	private DefaultMap<Integer, Student> testMap; // use this for basic tests

	@Before
	public void setUp() {
		filereader = new FileReader("src/input.txt");
	}

	//Write testcase for checking max score of 2 sections

	@Test
	public void checkingSectionA(){
		assertEquals(
			94, 
			(int) Math.floor(filereader.getMaxOfSection('A').marks)
		);
	}

	@Test
	public void checkingSectionB(){
		assertEquals(
			88, 
			(int) Math.floor(filereader.getMaxOfSection('B').marks)
		);
	}

	@Test
	public void checkingSectionC(){
		assertEquals(
			70, 
			(int) Math.floor(filereader.getMaxOfSection('C').marks)
		);
	}
}

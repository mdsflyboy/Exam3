import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Comparator;
import java.util.Scanner;

public class FileReader {

	String filename;
	Comparator comparator;
	DefaultMap<Character, Student> hashMap;

	public FileReader(String name) {
		// Constructor for the filereader
		filename = name;
		hashMap = new MyHashMap<Character, Student>(10, new StudentCompator());
	}

	public void createHeap() {
		// Method to read input.txt using FileInputStream and putting the student
		// entries to the hashMap
		try (
				InputStream f = new FileInputStream(filename);
				Scanner input = new Scanner(f);) {
			while (input.hasNextLine()) {
				String cLine = input.nextLine();
				String[] items = cLine.split(",");

				int marks = Integer.parseInt(items[2]);
				char[] section = items[1].toCharArray(); // this should have len 1
				Student student = new Student(items[0], section[0], marks);

				hashMap.put(section[0], student);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Student getMaxOfSection(char section) {
		// Method that returns a maximum scoring student's record given the section
		return hashMap.get(section);
	}

	public class StudentCompator implements Comparator<Student> {
		@Override
		public int compare(Student o1, Student o2) {
			// TODO Auto-generated method stub
			if (o1.marks > o2.marks)
				return 1;
			if (o1.marks < o2.marks)
				return -1;
			return 0;
		}
	}

}

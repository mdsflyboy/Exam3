import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Stream;

public class FileReader {

	String filename;
	Comparator comparator;
	DefaultMap<Character, Student> hashMap;

	public FileReader(String name) {
		// Constructor for the filereader
		filename = name;
		hashMap = new MyHashMap<Character, Student>();
	}

	public void createHeap() {
		// Method to read input.txt using FileInputStream and putting the student
		// entries to the hashMap
		try (Scanner input = new Scanner(new FileInputStream(filename))) {
			while(input.hasNextLine()){
				String cLine = input.nextLine();
				String[] items = cLine.split(",");

				int marks = Integer.parseInt(items[2]);
				char[] section = items[1].toCharArray(); // this should have len 1
				Student student = new Student(items[0], section[0], marks);

				hashMap.put(section[0], student);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Student getMaxOfSection(char section) {
		// Method that returns a maximum scoring student's record given the section
		return hashMap.get(section);
	}

}

/**
 * 
 */
package fr.epita.java.ex;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mikael
 *
 */
public class Utils {
	/**
	 * @param file
	 * @return list of person objects
	 */
	public static List<Person> modelToListOfPersons(File file) {
		List<Person> listOfPersons = new ArrayList<Person>();
		List<String> lines = null;
		try {
			lines = Files.readAllLines(file.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(lines != null) {
			for (String line : lines.subList(1, lines.size()) ) {
				String[] split_lines = line.split(",");
				String name = split_lines[0];
				String sex = split_lines[1];
				Integer age = Integer.parseInt(split_lines[2].strip());
				Integer height = Integer.parseInt(split_lines[3].strip());
				Integer weight = Integer.parseInt(split_lines[4].strip());
				Person person = new Person(name, sex, age, height, weight);
				listOfPersons.add(person);
			}
		}
		return listOfPersons;
	}
	
	/**
	 * @param persons
	 * @return 2d matrix representing person data
	 */
	public static String[][] listTo2dMatrix(List<Person> persons) {
		Integer arrayWidth = 5;
		Integer arrayHeight = persons.size();
		String[][] matrix = new String[arrayHeight][arrayWidth];
		for(Integer i = 0; i < arrayHeight; i++) {
			Person person = persons.get(i);
			matrix[i][0] = person.getName();
			matrix[i][1] = person.getSex();
			matrix[i][2] = person.getAge().toString();
			matrix[i][3] = person.getHeight().toString();
			matrix[i][4] = person.getWeight().toString();
		}
		return matrix;
	}
	
	/**
	 * @param matrix
	 * @return list of person objects
	 */
	public static List<Person> matrixToListOfPersons(String[][] matrix) {
		List<Person> list = new ArrayList<Person>();
		for(Integer i=0; i < matrix.length; i++) {
			Person person = new Person(matrix[i][0], matrix[i][1], Integer.parseInt(matrix[i][2]), Integer.parseInt(matrix[i][3]), Integer.parseInt(matrix[i][4]));
			list.add(person);
		}
		return list;
	}
	
	
}

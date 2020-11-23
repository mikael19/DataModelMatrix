/**
 * 
 */
package fr.epita.java.ex;

import java.io.File;
import java.util.List;


/**
 * @author mikael
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// File object
		File file = new File("data.csv");
		
		
		
		// 1st function: file values to list of person objects
		List<Person> persons = Utils.modelToListOfPersons(file);
		for (Person person : persons) {
			System.out.println(person);
		}
		
		
		
		// 2nd function: list of persons to 2d matrix(array)
		String[][] matrix = Utils.listTo2dMatrix(persons);
		for (int row = 0; row < matrix.length; row++) { 
			for (int col = 0; col < matrix[row].length; col++) { 
				System.out.print(matrix[row][col] + "\t");
				}
			System.out.println();
		}
		
		
		
		// 3rd function: 2d matrix back to list of persons
		List<Person> listOfPersons = Utils.matrixToListOfPersons(matrix);
		for (Person person : listOfPersons) {
			System.out.println(person);
		}
	}

}

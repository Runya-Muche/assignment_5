import java.io.FileNotFoundException;
import java.io.*;
import java.util.Scanner;

/**
 * 
 * @author runya
 *
 */
public final class TwoDimRaggedArrayUtility {
	
	/**
	 * Default constructor for the class
	 */
	public TwoDimRaggedArrayUtility() {
		
	}
	
	/**
	 * Reads a file and returns the values of the file into a ragged array
	 * @param file File to be read
	 * @return A ragged array containing the sales values from the file
	 * @throws FileNotFoundException
	 */
	public static double[][] readFile(File file) throws FileNotFoundException {
		
		int count = 0, rowCount = 0;
		final int ROWS = 10, COLS = 10;
		
		String[][] lineArr = new String[ROWS][COLS];
		String[] strArr = new String[ROWS];
		Scanner inputFile = new Scanner(file);
		
		while(inputFile.hasNextLine()) {
			String line = inputFile.nextLine();
			strArr[count] = line;
			count++;
		}
		
		for (int i = 0; i < ROWS; i++) {
			if (strArr[i] != null) {
				rowCount++;
			}
		}
		
		double[][] nums = new double[rowCount][];
		
		for (int i = 0; i < rowCount; i++) {
			lineArr[i] = strArr[i].split(" ");
			nums[i] = new double[lineArr[i].length];
			for (int j = 0; j < nums[i].length; j++) {
				nums[i][j] = Double.parseDouble(lineArr[i][j]);
			}
		}
		
		inputFile.close();
		return nums;
	}
	
	/**
	 * Writes the 2D ragged array's data into a file
	 * @param data The ragged array
	 * @param outputFile File to be written to
	 * @throws FileNotFoundException
	 */
	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
		Scanner stdin = new Scanner(System.in);
		
		PrintWriter outFile = new PrintWriter(outputFile);
		
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				outFile.print(data[i][j] + " ");
			}
			outFile.println();
		}
		outFile.close();
	}
	
	/**
	 * Sums total of all the values within the array
	 * @param data The ragged array
	 * @return
	 */
	public static double getTotal(double[][] data) {
		double total = 0.0;
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				total += data[i][j];
			}
		}
		return total;
	}
	
	/**
	 * Averages the total of the values in the array
	 * @param data The ragged array
	 * @return The average of all the values
	 */
	public static double getAverage(double[][] data) {
		double total = 0.0;
		int arrCount = 0;
		double average = 0;
		
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				total += data[i][j];
				arrCount++;
			}
		}
		
		average = total / arrCount;
		
		return average;
	}
	
	/**
	 * Sums the values in a row
	 * @param data The ragged array
	 * @param row Index of the row to be summed
	 * @return Total of the given row
	 */
	public static double getRowTotal(double[][] data, int row) {
		double total = 0;
		
		for (int i = 0; i < data[row].length; i++) {
			total += data[row][i];
		}
		
		return total;
	}
	
	/**
	 * Sums the values in a column
	 * @param data The ragged array
	 * @param col Index of the column to be summed
	 * @return Total of the given column 
	 */
	public static double getColumnTotal(double[][] data, int col) {
		double total = 0;
		
		for (int i = 0; i < data.length; i++) {
			if (col < data[i].length) {
				total += data[i][col];
			}
		}
		return total;
	}
	
	/**
	 * Retrieves the highest value in a row 
	 * @param data The ragged array
	 * @param row The index of the row
	 * @return The highest value obtained
	 */
	public static double getHighestInRow(double[][] data, int row) {
		double highest = data[row][0];
		
		for (int i = 1; i < data[row].length; i++) {
			if (highest < data[row][i]) {
				highest = data[row][i];
			}
		}
		return highest;
	}
	
	/**
	 * Retrieves the index of the highest value in a row
	 * @param data The ragged array
	 * @param row The index of the row
	 * @return The index of the highest value 
	 */
	public static int getHighestInRowIndex(double[][] data, int row) {
		double highest = data[row][0];
		int index = 0;
		for (int i = 1; i < data[row].length; i++) {
			if (highest < data[row][i]) {
				index = i;
			}
		}
		return index;
	}
	
	/**
	 * Retrieves the lowest value in a row 
	 * @param data The ragged array
	 * @param row The index of the row
	 * @return The lowest value obtained
	 */
	public static double getLowestInRow(double[][] data, int row) {
		double lowest = data[row][0];
		
		for (int i = 1; i < data[row].length; i++) {
			if (lowest > data[row][i]) {
				lowest = data[row][i];
			}
		}
		return lowest;
	}
	
	/**
	 * Retrieves the index of the lowest value in a row 
	 * @param data The ragged array
	 * @param row The index of the row
	 * @return The index of the lowest value obtained
	 */
	public static int getLowestInRowIndex(double[][] data, int row) {
		double lowest = data[row][0];
		int index = 0;
		
		for (int i = 0; i < data[row].length; i++) {
			if (lowest > data[row][i]) {
				lowest = data[row][i];
				index = i;
			}
		}
		return index;
	}
	
	/**
	 * Retrieves the highest value in a column 
	 * @param data The ragged array
	 * @param row The index of the column
	 * @return The highest value obtained
	 */
	public static double getHighestInColumn(double[][] data, int col) {
		double highest = Double.MIN_VALUE;
		
		for (int i = 0; i < data.length; i++) {
			if (data[i].length > col) {					
				if (highest < data[i][col]) {						
					highest = data[i][col];
				}
			}
		}
		return highest;
	}
	
	/**
	 * Retrieves the index of the highest value in a column 
	 * @param data The ragged array
	 * @param row The index of the column
	 * @return The the index of the highest value obtained
	 */
	public static int getHighestInColumnIndex(double[][] data, int col) {
		double highest = Double.MIN_VALUE;
		int index = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i].length > col) {					
				if (highest < data[i][col]) {	
					highest = data[i][col];
					index = i;
				}
			}
		}
		return index;
	}
	
	/**
	 * Retrieves the lowest value in a column
	 * @param data The ragged array
	 * @param row The index of the column
	 * @return The lowest value obtained
	 */
	public static double getLowestInColumn(double[][] data, int col) {
		double lowest = Double.MAX_VALUE;
		
		for (int i = 0; i < data.length; i++) {
			if (data[i].length > col) {					
				if (lowest > data[i][col]) {						
					lowest = data[i][col];
				}
			}
		}
		return lowest;
	}
	
	/**
	 * Retrieves the index of the lowest value in a column
	 * @param data The ragged array
	 * @param row The index of the column
	 * @return The index of the lowest value obtained
	 */
	public static int getLowestInColumnIndex(double[][] data, int col) {
		double lowest = Double.MAX_VALUE;
		int index = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i].length > col) {					
				if (lowest > data[i][col]) {
					lowest = data[i][col];
					index = i;
				}
			}
		}
		return index;
	}
	
	/**
	 * Obtains the highest value in the entirety of the array
	 * @param data The ragged array
	 * @return The highest value within the array
	 */
	public static double getHighestInArray(double[][] data) {
		double highest = data[0][0];
		
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				if (highest < data[i][j]) {
					highest = data[i][j];
				}
			}
		}
		return highest;
	}
	
	/**
	 * Obtains the lowest value in the entirety of the array
	 * @param data The ragged array
	 * @return The lowest value within the array
	 */
	public static double getLowestInArray(double[][] data) {
		double lowest = data[0][0];
		
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				if (lowest > data[i][j]) {
					lowest = data[i][j];
				}
			}
		}
		return lowest;
	}
}

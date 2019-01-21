package main.course.oop.tictactoe.util;
import java.util.ArrayList;
/**
 * You must implement the following methods to accept the expected 
 * parameters and return accurate results.
 * You are allowed and expected to add any class attributes and methods 
 * needed to complete this assignment. 
 * 
 *
 */
public class TwoDArray {
	int [][] TwoD_Array;
	int arrayRow;
	int arrayCol;
	int defaultValue;
	
	public TwoDArray(int rows, int cols, int defaultVal){
		/*TODO - Create a 2D integer array consisting of 
		 * the number of rows and columns given. Initialize 
		 * the array by setting each int to be the defaulVal. 
		 * */
		TwoD_Array = initializeArray(rows, cols, defaultVal);
		arrayRow = rows;
		arrayCol = cols;
		defaultValue = defaultVal;
	}
	
	public void initArray(int defaultVal) {
		/*TODO - (Re)Initialize the array by 
		 * setting each int to be the defaulVal 
		 */
		TwoD_Array = initializeArray(arrayRow, arrayCol, defaultVal);
	}
	
	public String insertInt(int row, int col, int val) {
		/*TODO - "Insert" based on the following conditions:
		 * 1. The location [row][col] is still set to the default value
		 * 		-return "Success! (val) was inserted.
		 * 
		 * 2. The location [row][col] is no longer the default value
		 * 		-return "Failure: (row), (col) is not empty.
		 * 
		 * 3. val is the default value; 
		 * 		-return "Failure: (val) is not allowed."
		 * 
		 * Note: Print the int value in place of (). 
		 * e.g., replace (val) with val.
		 */
		
		// val is the default value
		if (defaultValue == val) {
			return "Failure: " + val + " is not allowed.";
		}
		
		// Successful insertion
		else if (TwoD_Array[row][col] == defaultValue) {
			TwoD_Array[row][col] = val;
			return "Success! " + val + " was inserted.";
		}
		
		// The value is not the default value
		else {
			return "Failure: [" + row + "][" + col + "] is not empty.";
		}
	}
	
	public int getInt(int row, int col) {
		/*TODO - Return the value at the specified row, col
		 * 
		 */
		
		return TwoD_Array[row][col];
	}
	
	public String getArrayDisplay() {
		String array_string = "";
		/*TODO - Create a 2D display of the Array
		 * e.g. 
		 * 	1	0	1
		 *  0	1	0
		 *  0	1	1
		 * 
		 */
		
//		for (int i = 0; i < arrayRow; i++) {
//			for (int j = 0; j < arrayCol; j++) {
//			
//			}
//		}
		
		return "Not implemented";
	}
	
	public String getArrayDetails() {
		String array_details = "";
		int index = 0;
		/*TODO - List the following:
		 * # rows
		 * # columns
		 * How many unique values (in the above example, this would be 2
		 * Value and count of each (e.g. 
		 * 			value:1 count:5
		 * 			value:0 count:4
		 * 
		 * 			)
		 * 
		 */
		array_details += ("# rows: " + arrayRow + "\n");
		array_details += ("# columns: " + arrayCol + "\n");
		
		// create an array to count unique values
		ArrayList<Integer> uniqueArray = new ArrayList<>();
		ArrayList<Integer> countArray = new ArrayList<>();
		
		for (int i = 0; i < arrayRow; i++) {
			for (int j = 0; j < arrayCol; j++) {
				// the value is not in the uniqueArray
				if (uniqueArray.size() == 0 || !uniqueArray.contains(TwoD_Array[i][j])) {
					// add the value to the uniqueArray
					uniqueArray.add(TwoD_Array[i][j]);
					// update countArray
					countArray.add(uniqueArray.indexOf(TwoD_Array[i][j]), 1);
				}
				
				// the value is in the uniqueArray
				else {
					// update countArray
					index = uniqueArray.indexOf(TwoD_Array[i][j]);
					countArray.set(index, countArray.get(index) + 1);
				}
			} // end of inner for loop
		} // end of for loop
		
		array_details += "There are " + uniqueArray.size() + " unique values\n";
        
		// get the unique value and the count of it
		for (int i = 0; i < uniqueArray.size(); i++) {
			array_details += "value:" + uniqueArray.get(i) + " count:" + countArray.get(i) + "\n";
		}
		return array_details;
	}	
	
	public int[][] initializeArray(int rows, int cols, int val) {
		// Initialize the array with values
		int [][] TwoD_Array = new int [rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				TwoD_Array[i][j] = val;
			}
		}
		//return the array
		return TwoD_Array;
	}

}

/*Hunter Beauto
 * Project 2 part 3
 * March 2, 2020
 * adds the diagonals of a 4x4 matrix into one sum
*/

import java.util.Scanner;

public class matrix_sum {

	public static void main(String[] args) {
		//creates the 4x4 matrix for later use
		int matrix[][]=new int[4][4];
		//gets data for matrix from user input
		Scanner input=new Scanner(System.in);
		String num;
        System.out.println("Enter 4 numbers in a row 4 times");
        //creates 4x4 matrix and enters data
        for (int i = 0;i<4;i++) {
	        for (int j=0;j<4;j++) {
	                num=input.next();
	                //parseInt convers num into an integer
	                matrix[i][j]=Integer.parseInt(num);
	        }
	    }  
        System.out.print("Sum of diagonals in matrix is: "+sumMajorDiagonal(matrix));
	}
	//from book
	public static double sumMajorDiagonal(int[][] MATRIX) {
		//will be our total for the sum of diagonals
		double totalOFdiagonals=0;
		//gets numbers diagonally[uses coordinates (0,0) (1,1) (2,2) (3,3)]
		for(int i=0;i<4;i++) {
			for(int j=0; j<4;j++) {
				//precaution to make sure only(0,0) (1,1) (2,2) (3,3) are added
				if(i==j) {
					totalOFdiagonals+=MATRIX[i][j];
				}
			}
		}
		return totalOFdiagonals;
	}
}

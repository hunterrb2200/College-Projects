/*Hunter Beauto
 * Project 1 part 1
 * February 12, 2020
*/

import java.util.Scanner;

public class circle {
	
	public static void main(String[] args) {
		//create scanner for user inputs
		Scanner input = new Scanner(System.in);

		//get user input for statistics of circle 1
		System.out.println("Enter circle 1's center x-, y-coordinates, and radius: ");
		//used doubles for decimal values
		System.out.print("x-coordinate: ");
		double x_coord1 = input.nextDouble();
		System.out.print("y-coordinate: ");
		double y_coord1 = input.nextDouble();
		System.out.print("radius: ");
		double radius1 = input.nextDouble();
		
		//get stats for circle 2
		System.out.println("Enter circle 2's center x-, y-coordinates, and radius: ");
		System.out.print("x-coordinate: ");
		double x_coord2 = input.nextDouble();
		System.out.print("y-coordinate: ");
		double y_coord2 = input.nextDouble(); 
		System.out.print("radius: ");
		double radius2 = input.nextDouble(); 

		//simple if else if statement for checking where the circles are placed and their relationship
		//checks for circle 2 being inside of or the exact same as circle 1
		if (Math.pow(Math.pow(x_coord2 - x_coord1, 2) + Math.pow(y_coord2 - y_coord1, 2), 0.5) <= Math.abs(radius1 - radius2))
			System.out.println("circle 2 is inside circle 1");
		//checks if circle 2 is overlapping onto circle 1
		else if (Math.pow(Math.pow(x_coord2 - x_coord1, 2) + Math.pow(y_coord2 - y_coord1, 2), 0.5)<= radius1 + radius2)
			System.out.println("circle 2 overlaps onto circle 1");
		//default answer if there is no relationship between circles
		else
			System.out.println("circle 2 doesn't overlap onto circle 1");
	}
}

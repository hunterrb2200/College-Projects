/*Hunter Beauto
 * Project 2 part 1
 * March 2, 2020
 * Computing the GCD of a group of integers
*/

import java.util.Scanner;

public class ComputeGCD {
	public static void main(String[] args) {
		//creates an array for five numbers
		int[] numbers = new int[5];
		Scanner input = new Scanner(System.in);
		//get five user inputs and put them in an array
		System.out.println("Input five numbers: ");
		for (int i = 0; i < 5; i++) {
			numbers[i] = input.nextInt();
		}
		//prints GCD 
		System.out.println("The greatest common divisor is " + gcd(numbers));
	}
	
	//puts five numbers into method to find smallest integer
	public static int smallest_int(int[] numbers) {
		int sm_int = numbers[0];
		for (int j: numbers) {
			if (j < sm_int)
				sm_int = j;
		}
		return sm_int;
	}

	//puts the five numbers into the gcd method to find the GCD
	public static int gcd(int[] numbers) {
		//sets gcd to 1 if it can't find anything bigger
		int gcd = 1;
		//checks if int is a divisor
		boolean isD;
		for (int i = 2; i < smallest_int(numbers); i++) {
			isD = true;
			for (int j: numbers) {
				if (j%i!= 0)
					isD = false;
			}
			if (isD)
				gcd = i;
		}
		return gcd;
	}
}

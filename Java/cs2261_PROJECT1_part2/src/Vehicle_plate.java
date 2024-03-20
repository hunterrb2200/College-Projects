/*Hunter Beauto
 * Project 1 part 2
 * February 12, 2020
*/

import java.util.Random;

public class Vehicle_plate {
	public static void main(String[] args) {	
	
	for(int i=0; i <11; i++) {
		//generates random numbers
		Random random = new Random();
		int D1 = random.nextInt(10);
		int D2 = random.nextInt(10);	
		//generates random letters
		char C1 = (char) (random.nextInt(26) + 'A');
		char C2 = (char) (random.nextInt(26) + 'A');
		char C3 = (char) (random.nextInt(26) + 'A');
		char C4 = (char) (random.nextInt(26) + 'A');
	
		//prints out plate ID
		System.out.print(C1);
		System.out.print(C2);
		System.out.print(D1);
		System.out.print(C3);
		System.out.print(D2);
		System.out.println(C4);
		
	}
	}
}

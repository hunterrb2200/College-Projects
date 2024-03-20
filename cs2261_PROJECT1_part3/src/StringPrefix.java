/*Hunter Beauto
 * Project 1 part 3
 * February 12, 2020
*/

import java.util.Scanner;

public class StringPrefix {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		//Get 1st string from user
		System.out.print("Enter the first string: ");
		String str1 = input.nextLine();
		
		//Get 2nd string from user
		System.out.print("Enter the second string: ");
		String str2 = input.nextLine();

		//default settings
		int string_index = 0;
		String string_prefix = "";

		//while statement that can find the largest prefix if there is one
		while(str1.charAt(string_index) == str2.charAt(string_index)) {
			string_prefix+=str1.charAt(string_index);
			string_index++;
		}

		//if else statement that prints the output based on whether or not there is a common prefix
		if (string_prefix.length()>0)
			System.out.println("The common prefix is "+string_prefix);
		else
			System.out.println(str1+" and "+str2+" have no common prefix");
	}
}

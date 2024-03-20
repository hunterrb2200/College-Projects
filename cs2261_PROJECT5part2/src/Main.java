/*Hunter Beauto
 * Project 5 part 2
 * May 4, 2020
 * exercise 21.11
 * checks for parenthesis brackets and braces in a user input string
*/

import java.util.Scanner;
import java.util.Stack;
public class Main{
	//variables for parenthesis, brackets, and braces
	private static final char LEFTPARENTH = '(';
	private static final char RIGHTPARENTH = ')';
	private static final char LEFTBRACE = '{';
	private static final char RIGHTBRACE = '}';
	private static final char LEFTBRACKET = '[';
	private static final char RIGHTBRACKET = ']';
	
	public static void main(String args[]){
		//gets user entered string
		System.out.println("enter string:");
		Scanner input = new Scanner(System.in);
		String str1 = input.nextLine();

		if (checkSymbols(str1))
			System.out.println("The symbols match");
		else
			System.out.println("The symbols do not match");
		System.out.println();
	}
	
	public static boolean checkSymbols(String str1){	
		//checks for the symbols and returns if one is missing or incorrectly used
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < str1.length(); i++)
		{
			if (str1.charAt(i) == LEFTPARENTH)
				stack.push(LEFTPARENTH);
			else if (str1.charAt(i) == LEFTBRACE)
				stack.push(LEFTBRACE);
			else if (str1.charAt(i) == LEFTBRACKET)
				stack.push(LEFTBRACKET);
			else if (str1.charAt(i) == RIGHTPARENTH){
				if (stack.isEmpty())
					return false;
				if (stack.pop() != LEFTPARENTH)
					return false;
			}
			else if (str1.charAt(i) == RIGHTBRACE){
				if (stack.isEmpty())
					return false;
				if (stack.pop() != LEFTBRACE)
					return false;
			}
			else if (str1.charAt(i) == RIGHTBRACKET){
				if (stack.isEmpty())
					return false;
				if (stack.pop() != LEFTBRACKET)
					return false;
			}
		}
		return stack.isEmpty();
	}
}
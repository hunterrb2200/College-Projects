/*Hunter Beauto
 * Project 2 part 2
 * March 2, 2020
 * Identify arrays by home similar they are
*/

import java.util.Scanner;

public class ID_arrays {
	public static void main(String[] args) {
		//gets user input for lists
		Scanner input= new Scanner(System.in);
		System.out.print("Enter list 1 length then enter the list: ");
		int[] list1=new int[input.nextInt()];
		for(int i=0;i<list1.length;i++) {
			list1[i]=input.nextInt();
		}
		System.out.print("Enter list 2 length then enter the list: ");
		int[] list2=new int[input.nextInt()];
		for(int i=0;i<list2.length;i++) {
			list2[i]=input.nextInt();
		}
		//prints and sends lists to be checked for equal values
		System.out.println("Two lists are "+(Equals(list1,list2) ? "": "not")+ "identical");
	}
	
	//sorts array from lowest to highest
	public static void sort_array(int[] list) {
		for(int i=0; i<list.length-1;i++) {
			int small_int=list[i];
			int small_i=i;
			for(int j=i+1;j<list.length;j++) {
				if(list[j]<small_int) {
					small_int=list[j];
					small_i=j;
				}
			}
			if(small_i !=i) {
				list[small_i]=list[i];
				list[i]=small_int;
			}
		}
	}
	
	//from book
	public static boolean Equals(int[] list1, int[] list2) {
		//checks if arrays are even the same length and acts accordingly
		if(list1.length!=list2.length) {
			return false;
		}
		//sorts the arrays in the sort_array method
		sort_array(list1);
		sort_array(list2);
		//checks if arrays are equal
		for(int i=0; i<list1.length;i++) {
			if(list1[i]!=list2[i])
				//returns false if unequal
				return false;
		}
		//if they are equal returns true
		return true;
	}
}

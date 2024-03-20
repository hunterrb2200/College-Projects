/*Hunter Beauto
 * Project 5 part 1
 * May 4, 2020
 * exercise 20.6
 * stores 5 million integers in a linked list and test time to search list
*/
import java.util.*;

public class Main {
	public static void main(String[] args) {
		long startTime=System.nanoTime();
		long endTime=System.nanoTime();
		long duration =(endTime-startTime);
		int value =0;

		Random rnd = new Random();
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		//creates 5 million random integers between 1 and 99
		for(int i = 0; i < 5000000; i++){
		list.add(rnd.nextInt(99-1) + 99);
		}
		
		System.out.printf("List contains %d values\n", list.size());
		ListIterator<Integer> listIterator = list.listIterator();
		
		while(listIterator.hasNext()){
		value = listIterator.next();
		}
		
		System.out.println("Time in nanoseconds using iterator method is \n"+ (duration));
		
		for(int i = 0; i<list.size(); i++){
		value =list.get(i);
		}
		//takes a really long time to run
		System.out.println("Time in nanoseconds using for loop is \n"+ (duration));
	}
}
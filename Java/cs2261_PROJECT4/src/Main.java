/*Hunter Beauto
 * Project 4 part 1
 * April 15, 2020
 * exercise 11.2
 * creates table for exercise 11.2, without MyDate since we did not use 10.14
*/

public class Main {
		public static void main(String[] args) {
			//strings to be printed(and maybe some references)
			Person person = new Person("Mia Karnstein", "123 Red veil", "630-531-1223", "MiaIsHere@gmail.com");
			Person employee = new Employee("Tom Nook", "777 AC street", "408-352-5768", "moneyman@gmail.com");
			Person faculty = new Faculty("Jill Valentine", "999 RE Ave", "853-233-3731", "JV@outlook.com");
			Person staff = new Staff("Jason V", "23 Camp Crystal Lake", "341-527-6241", "Hockeymask@gmail.com");
			Person student = new Student("Nikola Karnstein", "123 Red Veil", "630-534-1213", "NikolaKarnstein@yahoo.com", "junior");
			
			//runs all methods at once to print table
			System.out.println(person.toString() + "\n");
			System.out.println(employee.toString() + "\n");
			System.out.println(faculty.toString() + "\n");
			System.out.println(staff.toString() + "\n");
			System.out.println(student.toString() + "\n");
	  }
}

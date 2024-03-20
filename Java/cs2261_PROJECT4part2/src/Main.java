import java.io.*;
public class Main {
	public static void main(String[] args)throws IOException{
		//creates the circles
		Circle c1=new Circle(1.0);
		Circle c2=new Circle(2.0);
		Circle c3=new Circle(1.0);
	
		//data for three circles to be compared
		//used third circle to show same radius output 
		System.out.println("1= first circle is bigger, -1= first circle is smaller, 0= circles are equal");
		System.out.println("circle 1 and circle 2: "+c1.compareTo((Object)c2));
		System.out.println("circle 2 and circle 3: "+c2.compareTo((Object)c3));
		System.out.println("circle 3 and circle 1: "+c3.compareTo((Object)c1));
		System.out.println("circle 1 Area:"+c1.getArea());
		System.out.println("circle 2 Area:"+c2.getArea());
		System.out.println("circle 3 Area:"+c3.getArea()); 
	}
}

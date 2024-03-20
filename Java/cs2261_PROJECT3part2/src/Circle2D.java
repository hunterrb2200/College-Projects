/*Hunter Beauto
 * Project 3 part 2
 * March 18, 2020
 * exercise 10.11
 * uses a set circle to determine if other set circles are inside the circle
 * also checks for a point in the circle and finds area and perimeter
*/

//no imports needed

public class Circle2D {
	public static void main(String[] args) {
		
		// creates example from book
		Circle2D c1 = new Circle2D(2, 2, 5.5);

		//OP from example
		System.out.println("Circle 1 area: " + c1.getArea()); 
		System.out.println("Circle 1 perimeter: " + c1.getPerimeter()); 
		System.out.println("circle1 contains the point (3,3): "+c1.contains(3, 3)); 
		System.out.println("Circle 1 contains the circle at (4,5) with a radius of 10.5: "+c1.contains(new Circle2D(4, 5, 10.5)));
		System.out.println("Circle 1 overlaps the circle at (3,5) with a radius of 2.3: "+c1.overlaps(new Circle2D(3, 5, 2.3)));
	}
	
	private double x, y, radius;
	
	Circle2D() {
		this(0, 0, 1);
	}

	Circle2D(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	//getter for x coord
	public double getX() {
		return x;
	}
	
	//getter for y coord
	public double getY() {
		return y;
	}
	
	//getter for radius
	public double getRadius() {
		return radius;
	}
	
	//gets area(pi*r^2)
	public double getArea() {
		return Math.PI *Math.pow(radius,2);
	}
	
	//gets perimeter(2*pi*r)
	public double getPerimeter() {
		return 2*Math.PI *radius;
	}

	public boolean contains(double x, double y) {
		return Math.sqrt(Math.pow(x - this.x, 2)+Math.pow(y - this.y, 2))< radius;
	}
	
	//checks to see if circle 1 contains circle at (4,5)
	//returns as true or false
	public boolean contains(Circle2D circle) {
		return Math.sqrt(Math.pow(circle.getX() - x, 2)+Math.pow(circle.getY() - y, 2))<= Math.abs(radius - circle.getRadius());
	}
	
	//checks to see if circle 1 contains circle at (3,5)
	//returns as true or false
	public boolean overlaps(Circle2D circle) {
		return Math.sqrt(Math.pow(circle.getX()-x,2)+Math.pow(circle.getY()-y,2))<=radius+circle.getRadius();
	}
}

public class Circle extends GeometricObject implements Comparable{
	double radius;
	
	Circle(double r){
		radius=r;
	}
	
	//area for circles
	public double getArea(){
		return(3.143*(radius*radius));
	}
	
	//should work as override
	public int compareTo(Object obj){
		Circle c1=(Circle)obj;
  
		if(radius==c1.radius)
			return 0;
		else if(radius>c1.radius)
			return 1;
		else
			return -1;
	}
}
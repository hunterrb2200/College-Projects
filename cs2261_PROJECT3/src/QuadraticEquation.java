/*Hunter Beauto
 * Project 3 part 1
 * March 18, 2020
 * exercise 9.10
 * creates a quadratic equation using ax^2+bx+c=0
*/

import java.util.Scanner;

public class QuadraticEquation  {

    public static void main(String[] args) {
    	//gets user input for a, b, and c
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a, b, and c: ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        
        //starts quadratic equation
        QuadraticEquation Q_Equation = new QuadraticEquation(a,b,c);
        if (Q_Equation.getDiscriminant()>0){
            System.out.println("The equation has two roots, "+Q_Equation.getRoot1()+" and "+Q_Equation.getRoot2());
        	} 
        else if(Q_Equation.getDiscriminant()==0) {
            System.out.println("The equation has one root "+Q_Equation.getRoot1());
        	} 
        else{
            System.out.println("The equation has no real roots");
        }
    }
    
    //privates for part a of 9.10
    private double a, b, c;

    public QuadraticEquation(double a, double b, double c) {
        this.a=a;
        this.b=b;
        this.c=c;
    }
    
    //getter methods for part c
    //part of quadratic equation inside of the sqrt and part d
    public double getDiscriminant() {
        return(b*b)-(4*a*c);
    }

    //part e
    //quadratic equation for Root 1
    public double getRoot1(){
        double d=getDiscriminant();
        return(-b+Math.sqrt(d))/(2*a);
    }

    //quadratic equation for Root 2
    public double getRoot2() {
        double d = getDiscriminant();
        return (-b-Math.sqrt(d))/(2*a);
    }
}
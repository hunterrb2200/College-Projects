package cs3130project1;
import java.util.*;
/*
//adds two arrays together and get biggest Fibonacci number under 100
public class Fibonacci
{


//important function to check numbers and remove any zero from beginning
private static String getStringArrayNum(int[] num) {
       String result = arrToString(num);
       result = removeLeadingZeros(result);
    
       return result;
   }

//one of main functions from getStringArrayNum
private static String arrToString(int[] arr) {
     String s = "";
     for (int i = 0; i < arr.length; i++) {
         s = s + arr[i];
     }
     return s;
 }

//second important function of getStringArrayNum
private static String removeLeadingZeros(String s) {
 if (s.length() < 2)
   return s;
 int i;
 for (i = 0; i < s.length() - 1; i++) {
   char c = s.charAt(i);
   if (c != '0')
     break;
 }
 if (i == 0) {
   return s;
 }
 return s.substring(i);
}

private static int[] addTwoArrays(int[] arr1, int[] arr2) {
int size = arr1.length;
int[] arrTotal = new int[size + 1];
for (int i = 0; i < size; i++) {
 arrTotal[i] = 0;
}

int remaider = 0;
for (int i = size - 1; i >= 0; i--) {
 int temp = arr1[i] + arr2[i] + remaider;
 arrTotal[i + 1] = temp % 10;
 remaider = temp / 10;
}
arrTotal[0] = remaider;

return arrTotal;
}

//gets and sets the arrays of F(n-1) and F(n-2)
private static int[] getFibArray(int n, int size) {
   int[] fibArr1 = new int[size];
   int[] fibArr2 = new int[size];
   int[] fibResultArr = new int [size + 1];
   for (int i = 0; i < size; i++) {
     fibArr1[i] = fibArr2[i] = fibResultArr[i] = 0;
   }
   if (n == 0) {
     return (addTwoArrays(fibArr1, fibArr1));
   }
   if (n == 1) {
     fibArr2[size - 1] = 1;
     return (addTwoArrays(fibArr1, fibArr2));
   }
   //goes through arrays
   fibArr2[size - 1] = 1;
   for (int i = 0; i < n - 1; i++) {
     fibResultArr = addTwoArrays(fibArr1, fibArr2);
     fibArr1 = fibArr2;
     int[] fibArr2Temp = new int[fibArr2.length];
     for (int j = 0; j < fibArr2.length; j++) {
       fibArr2Temp[j] = fibResultArr[j + 1];
     }
     fibArr2 = fibArr2Temp;
   }
   return fibResultArr;
 }

private static String getBiggestFib(int size) {
	//returns value under 100
	String result = "";
	int n = 0;
	int[] fib;
	if (size == 2)
		return "8";

	while (true) {
		fib = getFibArray(n, size - 2);

		if (fib[0] != 0)
			break;
		n++;
	}
	int low = n;
	int[] fibAbove;
	while (true) {
		fibAbove = getFibArray(n, size - 1);

		if (fibAbove[0] != 0)
			break;
		n++;
	}
	int high = n;
	for (int i = low; i <= high; i++) {
		int[] f = getFibArray(i, size - 1);
		if (getStringArrayNum(f).length() >= size) {
			n = i - 1; 
			break;
		}
	}
	result = getStringArrayNum(getFibArray(n, size - 1));
	return result;
}

public static void main(String args[])
{
	System.out.println("Biggest Fibonacci number with less than 100 digits : " + getBiggestFib(100));
	}
}

*/




class Fibonacci {
    double fib_r(double n){
        if (n <= 1)
            return n;
        return fib_r(n-1) + fib_r(n-2);
    }

     double fib_iter(double n){
        double a=0,b=1,c=1;
        int i = 1;
        while(i<n){
            c= a+b;
            a = b;
            b = c;
            i++;
        }
        return c;
    }

    public static void main (String[] args) {
        Fibonacci fb = new Fibonacci();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        long start = System.currentTimeMillis();//function to get current time
        System.out.println("Iteration Fibonacci number at n: "+ fb.fib_iter(n));
        System.out.println("Time Spent: " + (System.currentTimeMillis() - start) + " ms");
        start = System.currentTimeMillis();
        System.out.println("Recursive Fibonacci Number at n: "+ fb.fib_r(n));
        System.out.println("Time Spent: " + (System.currentTimeMillis() - start) + " ms");
    }
}


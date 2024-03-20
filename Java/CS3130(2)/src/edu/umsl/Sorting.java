package edu.umsl;
import java.util.Random;

public class Sorting {

	// This code is contributed by Rajat Mishra from geeksforgeeks.org*/
	// Java program for implementation of Selection Sort
	void selectionSort(int arr[])
    {
        int n = arr.length;
 
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
            {
            	if (arr[j] < arr[min_idx])
                    min_idx = j;
            }
            //Swap the found minimum element with the first element
            swap(arr, min_idx, i);
        }
    }

	
	
	// This code is contributed by Rajat Mishra from geeksforgeeks.org
	//Function to sort array using insertion sort
    void insertionSort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) 
        {
            int key = arr[i];
            int j = i - 1;
 
            // Move elements of arr[0..i-1], that are greater than key, to one position ahead of their current position  while (j >= 0 && arr[j] > key) 
            {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }


    // This code is contributed by Rajat Mishra 
    // Java program for implementation of Bubble Sort no swaps
    void bubbleSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
        {
            for (int j = 0; j < n-i-1; j++)
            {
                if (arr[j] > arr[j+1])
                {
                    swap(arr, j, j+1);
                }
            }
        }
    }
  
    // An optimized version of Bubble Sort (Swaps counting)
    // This code is contributed by Nikita Tiwari.
    void bubbleSortSwap(int arr[], int n)
    {
        int i, j;
        boolean swapped;
        for (i = 0; i < n - 1; i++)
        {
            swapped = false;
            for (j = 0; j < n - i - 1; j++)
            {
                if (arr[j] > arr[j + 1])
                {
                    swap(arr, j, j+1);
                    swapped = true;
                }
            }
 
            // IF no two elements were swapped by inner loop, then break
            if (swapped == false)
                break;
        }
    }

  
    //Quick Sort parts- swap, partioning, quicksort
    // This code is contributed by Ayush Choudhary
    // A utility function to swap two elements
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
     
    //This function takes last element as pivot, places
       //the pivot element at its correct position in sorted
       //array, and places all smaller (smaller than pivot)
      // to left of pivot and all greater elements to right
       //of pivot 
    static int partition(int[] arr, int low, int high)
    {
    	int pivot = arr[high];
         
        // Index of smaller element and indicates the right position of pivot found so far
        int i = (low - 1);
        for(int j = low; j <= high - 1; j++) //???
        {
            // If current element is smaller than the pivot
            if (arr[j] < pivot)
            {
                // Increment index of smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
     
    //The main function that implements QuickSort
    //        arr[] --> Array to be sorted,
    //      low --> Starting index,
    //    high --> Ending index
     
    void quickSort(int[] arr, int low, int high)
    {
        if (low < high)
        {
            // pi is partitioning index, arr[p] is now at right place
            int pi = partition(arr, low, high);
            // Separately sort elements before partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
     

    //mergeSort This code is contributed by Rajat Mishra 
    // Merges two subarrays of arr[].; First subarray is arr[l..m]; Second subarray is arr[m+1..r]
    void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
  
        // Create temp arrays 
        int L[] = new int[n1];
        int R[] = new int[n2];
  
        //Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
  
        // Merge the temp arrays 
  
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
  
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
  
        // Copy remaining elements of L[] if any 
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
  
 
  // Copy remaining elements of R[] if any 
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
  
    // Main function that sorts arr[l..r] using
    // merge()
    void mergeSort(int arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;
  
            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
  
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    

    public static void main(String args[])
    {
        Sorting s = new Sorting();
        Random rand1= new Random();
        int n = 100000;
        int[] arr = new int[n];

        //selectionSort sorted
        long start = System.currentTimeMillis();//function to get current time
        s.selectionSort(s.arrSorted(arr, 1000));
        System.out.println("Time Spent on sorted 1000 selectionSort List: " + (System.currentTimeMillis() - start) + " ms");
        start = System.currentTimeMillis();//function to get current time
        s.selectionSort(s.arrSorted(arr, 10000));
        System.out.println("Time Spent on sorted 10000 selectionSort List: " + (System.currentTimeMillis() - start) + " ms");
        start = System.currentTimeMillis();//function to get current time
        s.selectionSort(s.arrSorted(arr, 100000));
        System.out.println("Time Spent on sorted 10000 selectionSort List: " + (System.currentTimeMillis() - start) + " ms");
    
/*
        //selectionSort random
        start = System.currentTimeMillis();//function to get current time
        s.selectionSort(s.random(arr, 1000));
        System.out.println("Time Spent on random 1000 selectionSort List: " + (System.currentTimeMillis() - start) + " ms");
        start = System.currentTimeMillis();//function to get current time
        s.selectionSort(s.random(arr, 10000));
        System.out.println("Time Spent on random 10000 selectionSort List: " + (System.currentTimeMillis() - start) + " ms");
        start = System.currentTimeMillis();//function to get current time
        s.selectionSort(s.random(arr, 100000));
        System.out.println("Time Spent on random 10000 selectionSort List: " + (System.currentTimeMillis() - start) + " ms");
    
        //selectionSort partially sorted ???

        
        /*
      //insertionSort sorted
        System.out.println();

        start = System.currentTimeMillis();//function to get current time
        s.insertionSort(s.arrSorted(arr, 1000));
        System.out.println("Time Spent on sorted 1000 insertionSort List: " + (System.currentTimeMillis() - start) + " ms");
        start = System.currentTimeMillis();//function to get current time
        s.insertionSort(s.arrSorted(arr, 10000));
        System.out.println("Time Spent on sorted 10000 insertionSort List: " + (System.currentTimeMillis() - start) + " ms");
        start = System.currentTimeMillis();//function to get current time
        s.insertionSort(s.arrSorted(arr, 100000));
        System.out.println("Time Spent on sorted 10000 insertionSort List: " + (System.currentTimeMillis() - start) + " ms");
    

        //insertionSort random
        start = System.currentTimeMillis();//function to get current time
        s.insertionSort(s.random(arr, 1000));
        System.out.println("Time Spent on random 1000 insertionSort List: " + (System.currentTimeMillis() - start) + " ms");
        start = System.currentTimeMillis();//function to get current time
        s.insertionSort(s.random(arr, 10000));
        System.out.println("Time Spent on random 10000 insertionSort List: " + (System.currentTimeMillis() - start) + " ms");
        start = System.currentTimeMillis();//function to get current time
        s.insertionSort(s.random(arr, 100000));
        System.out.println("Time Spent on random 10000 insertionSort List: " + (System.currentTimeMillis() - start) + " ms");
    
        //insertionSort partially sorted???
        
        
      //bubbleSort sorted
        System.out.println();
        start = System.currentTimeMillis();//function to get current time
        s.bubbleSort(s.arrSorted(arr, 1000));
        System.out.println("Time Spent on sorted 1000 bubbleSort List: " + (System.currentTimeMillis() - start) + " ms");
        start = System.currentTimeMillis();//function to get current time
        s.bubbleSort(s.arrSorted(arr, 10000));
        System.out.println("Time Spent on sorted 10000 bubbleSort List: " + (System.currentTimeMillis() - start) + " ms");
        start = System.currentTimeMillis();//function to get current time
        s.bubbleSort(s.arrSorted(arr, 100000));
        System.out.println("Time Spent on sorted 10000 bubbleSort List: " + (System.currentTimeMillis() - start) + " ms");
    
      //bubbleSort random
        start = System.currentTimeMillis();//function to get current time
        s.bubbleSort(s.random(arr, 1000));
        System.out.println("Time Spent on random 1000 bubbleSort List: " + (System.currentTimeMillis() - start) + " ms");
        start = System.currentTimeMillis();//function to get current time
        s.bubbleSort(s.random(arr, 10000));
        System.out.println("Time Spent on random 10000 bubbleSort List: " + (System.currentTimeMillis() - start) + " ms");
        start = System.currentTimeMillis();//function to get current time
        s.bubbleSort(s.random(arr, 100000));
        System.out.println("Time Spent on random 10000 bubbleSort List: " + (System.currentTimeMillis() - start) + " ms");
        //bubblesort partially sorted???

        
        
        
        
      //bubbleSortSwap sorted
        System.out.println();

        start = System.currentTimeMillis();//function to get current time
        s.bubbleSortSwap(s.arrSorted(arr, 1000), 1000);
        System.out.println("Time Spent on sorted 1000 bubbleSortSwap List: " + (System.currentTimeMillis() - start) + " ms");
        start = System.currentTimeMillis();//function to get current time
        s.bubbleSortSwap(s.arrSorted(arr, 10000), 10000);
        System.out.println("Time Spent on sorted 10000 bubbleSortSwap List: " + (System.currentTimeMillis() - start) + " ms");
        start = System.currentTimeMillis();//function to get current time
        s.bubbleSortSwap(s.arrSorted(arr, 100000), 100000);
        System.out.println("Time Spent on sorted 10000 bubbleSortSwap List: " + (System.currentTimeMillis() - start) + " ms");
    

        //bubbleSortSwap random
        start = System.currentTimeMillis();//function to get current time
        s.bubbleSortSwap(s.random(arr, 1000), 1000);
        System.out.println("Time Spent on random 1000 bubbleSortSwap List: " + (System.currentTimeMillis() - start) + " ms");
        start = System.currentTimeMillis();//function to get current time
        s.bubbleSortSwap(s.random(arr, 10000), 10000);
        System.out.println("Time Spent on random 10000 bubbleSortSwap List: " + (System.currentTimeMillis() - start) + " ms");
        start = System.currentTimeMillis();//function to get current time
        s.bubbleSortSwap(s.random(arr, 100000), 100000);
        System.out.println("Time Spent on random 10000 bubbleSortSwap List: " + (System.currentTimeMillis() - start) + " ms");
    
        //bubbleSortSwap partially sorted???
        */
        

      //quickSort sorted
        System.out.println();
/*
        start = System.currentTimeMillis();//function to get current time
        s.quickSort(s.arrSorted(arr, 1000), 0, 999);
        System.out.println("Time Spent on sorted 1000 quickSort List: " + (System.currentTimeMillis() - start) + " ms");
        start = System.currentTimeMillis();//function to get current time
        s.quickSort(s.arrSorted(arr, 10000), 0, 9999);
        System.out.println("Time Spent on sorted 10000 quickSort List: " + (System.currentTimeMillis() - start) + " ms");
        start = System.currentTimeMillis();//function to get current time
        s.quickSort(s.arrSorted(arr, 100000), 0, 99999);
        System.out.println("Time Spent on sorted 10000 quickSort List: " + (System.currentTimeMillis() - start) + " ms");
    */

        //quickSort random
        start = System.currentTimeMillis();//function to get current time
        s.quickSort(s.random(arr, 100000), 0, 999);
        System.out.println("Time Spent on random 1000 quickSort List: " + (System.currentTimeMillis() - start) + " ms");
        start = System.currentTimeMillis();//function to get current time
        s.quickSort(s.random(arr, 100000), 0, 9999);
        System.out.println("Time Spent on random 10000 quickSort List: " + (System.currentTimeMillis() - start) + " ms");
        start = System.currentTimeMillis();//function to get current time
        s.quickSort(s.random(arr, 100000), 0, 99999);
        System.out.println("Time Spent on random 10000 quickSort List: " + (System.currentTimeMillis() - start) + " ms");
        //quickSort partially sorted???
       
        
        
       
        
}
        
        
        
        
        
        
        
        
        
        
        
        
        
        /*
        
        Sorting s = new Sorting();
        start = System.currentTimeMillis();
        s.selectionSort(s.arrSorted(arr, 1000));
        System.out.println("Sorted 1000 array");
        s.arrSorted(arr, 1000);
        System.out.println("Sorted 10000 array");
        s.arrSorted(arr, 10000);
        System.out.println("Sorted 100000 array");
        s.arrSorted(arr, 100000);
        /*System.out.println("Random 1000 array");
        s.random(arr,1000);
        System.out.println("Random 10000 array");
        s.random(arr,10000);
        System.out.println("Random 100000 array");
        s.random(arr,10000);
        */
        //System.out.println("Partial 1000 array");
        //s.partiallySorted(arr,100000);
    


int[] arrSorted(int array[], int n)
{
    int[] arr = new int[n];
	if(n > 10000) 
	{
		for(int i = 1; i <= 10000; i++)
		{
			//repeat 10 values for every value to be able to reach 100000 digits between 1 and 10000
			for(int j=0; j<10; j++)
			{
				arr[i+j]=i;
		        //System.out.println(arr[i]);
			}
		}
		return arr;
	} else 
	{
		for(int i = 0; i < n; i++)
		{
			arr[i] = i+1;
	        //System.out.println(arr[i]);
		}        
		return arr;
	}	
}


/*
int[] partiallySorted(int array[], int n)
{
	int[] arr = new int[n];
	for(int i = 0; i < n; i++)
	{
		if((i+1) % 10 == 0)
		{
			Random r = new Random();
			int low = 1;
			int high = 10000;
			int result = r.nextInt(high-low) + low;
			arr[i]= result;
		} else 
		{
			arr[i] = i+1;
		    //System.out.println(arr[i]);
		}		
	}
	return arr;
    System.out.println("second " +arr.length);

}
System.out.println("length " +arr.length);

	
	
	if(n > 10000)
	{	
			for(int i = 1; i <= 10000; i++)
			{
				//repeat 9 values for every value to be able to reach 100000 digits between 1 and 10000
				for(int j=0; j<9; j++)
				{
					arr[i+j]=i;
			        System.out.println(arr[i]);
				}
					Random r = new Random();
					int low = 1;
					int high = 10000;
					int result = r.nextInt(high-low) + low;
					arr[i]= result;
				    System.out.println(result + " test "+arr[i]);
				    continue;
				}
				
			}
			return arr;
}
/*

		else 
	{
		for(int i = 0; i < n; i++)
		{
			if((i+1) % 10 == 0)
			{
				Random r = new Random();
				int low = 1;
				int high = 10000;
				int result = r.nextInt(high-low) + low;
				arr[i]= result;
			} else 
			{
				arr[i] = i+1;
			    //System.out.println(arr[i]);
			}		
		}
		return arr;
	    System.out.println("second " +arr.length);

	}
	System.out.println("length " +arr.length);
}

	
i%10==9;
		for(int i = 0; i < n; i++)
		{
			for(int i = 1; i <= 10000; i++)
			{
				//repeat 10 values for every value to be able to reach 100000 digits between 1 and 10000
				for(int j=0; j<10; j++)
				{
					arr[i+j]=i;
			        System.out.println(arr[i]);
				}
			}
			if((i+1)%10 == 0)
			{
				Random r = new Random();
				int low = 1;
				int high = 10000;
				int result = r.nextInt(high-low) + low;
				arr[i]= result;
			    System.out.println(result + " test "+arr[i]);
			    continue;
			}
			for(int j=1; j<10000; j++)
			{
				arr[i+j]=i;
			    System.out.println(arr[i]);
			    i++;  
			}
			if((i+1)%10 == 0)
			{
				Random r = new Random();
				int low = 1;
				int high = 10000;
				int result = r.nextInt(high-low) + low;
				arr[i]= result;
			    System.out.println(result + " test "+arr[i]);
			    continue;
			}
			
		}

		
	    System.out.println("first " +arr.length);
		

	}
	
	/*
	int[] arr = new int[n];
    
    for(int w = 0; w < n;  w++)
    {
    	if (w % 10 == 0)
    	{
    		Random r = new Random();
    		int low = 1;
    		int high = 10000;
    		int result = r.nextInt(high-low) + low;
    		arr[w] = result;
    		w++;
    		break;
    	} else 
    	{
	    	if(n > 10000) 
	    	{
	    		for(int i = 1; i <= 10000; i++)
	    		{
		    		for(int j=0; j<10; j++)
		    		{
		    			arr[i+j]=i; 
		    		    System.out.println(arr[i]);
		    		}
	    		}
	    	    System.out.println("first " +arr.length);
	
	    	} else 
	    	{	
	    		
	    			arr[w] = w+1;
	    		    System.out.println(arr[w]);
	    		}
	    	}
    	}
	}*/
    
    
//random numbers between 1-10000
int[] random(int array[], int n) {
    int[] arr = new int[n];
	Random r = new Random();
	int low = 1;
	int high = 10000;
	for(int i=0; i< n; i++)
	{
		int result = r.nextInt(high-low) + low;
		arr[i] = result;
	    //System.out.println(arr[i]);

	}
	return arr;
}

 

void print(int arr[])
{
for(int i=0; i < arr.length; i++)
{
    System.out.println(arr[i]);
}
}
}



//create partially sorted list
/*
 Random r = new Random();
int low = 1;
int high = 10000;
int result = r.nextInt(high-low) + low;
 */

   
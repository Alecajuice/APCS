/*
 * Median Finder
 * Alex Tarng
 * 10/21/14
 * Period 6
 * Kuszmaul
 * 
 * Exercise:
 * Find the median of an array of ints by modifying quicksort with average O(n) time.
 * 
 * Following code is a modification of code from http://www.java2novice.com/java-sorting-algorithms/quick-sort/
 */
public class Main
{
	boolean evend = false;
	private boolean even = false;
	private int top;
	private boolean foundTop = false;
	private boolean foundMed = false;
	private static double median;
	private int array[];
	private int length;

	public void findMedian(int[] inputArr)
	{

		if (inputArr == null || inputArr.length == 0)
		{
			return;
		}
		this.array = inputArr;
		length = inputArr.length;
		if(length % 2 == 0)
		{
			even = true;
		}
		medianFinder(0, length - 1);
		if(!foundMed)
		{
			median = ((double)top + (double)array[length/2 - 1])/2;
		}
		even = false;
	}
	
	private void medianFinder(int lowerIndex, int higherIndex)
	{
		int i = lowerIndex;
		int j = higherIndex;
		if(i >= j)
		{
			if(!even)
			{
				median = array[length/2];
				return;
			}
			else
			{
				if(!foundTop)
				{
					top = array[length/2];
					foundTop = true;
				}
				else
				{
					median = ((double)top + (double)array[length/2 - 1])/2;
					foundTop = false;
					foundMed = true;
				}
				return;
			}
		}
		// calculate pivot number, I am taking pivot as middle index number
		int pivot = array[lowerIndex + (higherIndex - lowerIndex) / 2];
		// Divide into two arrays
		while (i <= j)
		{
			/**
			 * In each iteration, we will identify a number from left side which
			 * is greater then the pivot value, and also we will identify a
			 * number from right side which is less then the pivot value. Once
			 * the search is done, then we exchange both numbers.
			 */
			while (array[i] < pivot)
			{
				i++;
			}
			while (array[j] > pivot)
			{
				j--;
			}
			if (i <= j)
			{
				exchangeNumbers(i, j);
				// move index to next position on both sides
				i++;
				j--;
			}
			for(int k = 0; k < array.length; k++)
			{
				System.out.print(array[k] + ", ");
			}
			System.out.println();
		}
		if(!even)
		{
			if(j < array.length/2)
			{
				medianFinder(i, higherIndex);
			}
			else
			{
				medianFinder(lowerIndex, j);
			}
		}
		else
		{
			if(j == array.length/2 - 1)
			{
				medianFinder(i, higherIndex);
				medianFinder(lowerIndex, j);
			}
			else if(j < array.length/2 - 1)
			{
				medianFinder(i, higherIndex);
			}
			else
			{
				medianFinder(lowerIndex, j);
			}
		}
		
	}

	private void exchangeNumbers(int i, int j)
	{
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String a[])
	{

		Main sorter = new Main();
		int[] input = new int[10];
		for(int i = 0; i < input.length; i++)
		{
			input[i] = (int)(Math.random()*100);
		}
		printArray(input);
		sorter.findMedian(input.clone());
		System.out.println("Median: " + median);
	}
	
	//Print the array
		public static void printArray(int[] a)
		{
			for(int i = 0; i < a.length; i++)
			{
				System.out.print(a[i]);
				if(i != a.length - 1)
				{
					System.out.print(", ");
				}
			}
			System.out.println();
		}
}

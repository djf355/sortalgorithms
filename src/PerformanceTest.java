import java.util.Random;


/**
 * @author Demi Frechette
 * This class tests the performance of different sorting methods using a generated array.
 */
public class PerformanceTest {
	
	// initialize an array of int size, type Integer
	static int size = 10000;
	static Integer[] array = new Integer[size];

	public static void main(String[] args) {
		
		// generate the array
		generateArray();
		
		// test out sorting methods using copy of array
		Integer[] selection = new Integer[size];
		System.arraycopy(array, 0, selection, 0, array.length);
		
		// run the selection sort
		double start = System.nanoTime();
		SortMethods.selectionSort(selection);
		double finish = System.nanoTime();
		double finalTime = (finish - start) / 1000000;
		System.out.println("Selection sort took: " + finalTime + " milliseconds");
		
		// make a copy
		Integer[] merge = new Integer[size];
		System.arraycopy(array, 0, merge, 0, array.length);
		
		// run the merge sort
		start = System.nanoTime();
		SortMethods.mergeSort(merge, 0, size);
		finish = System.nanoTime();
		finalTime = (finish - start) / 1000000;
		System.out.println("Merge sort took: " + finalTime + " milliseconds");
				
		// make a copy
		Integer[] quick = new Integer[size];
		System.arraycopy(array, 0, quick, 0, array.length);
		
		// run the quick sort
		start = System.nanoTime();
		SortMethods.quickSort(quick, 0, quick.length - 1);
		finish = System.nanoTime();
		finalTime = (finish - start) / 1000000;
		System.out.println("Quick sort took: " + finalTime + " milliseconds");
				
	}
	
	
	
	/**
	 * Generates an array with random values
	 * @return array of type int
	 */
	private static Integer[] generateArray() {
		// populate the array with random numbers from 0-100
		Random rand = new Random();
		for(int i = 0; i < size; i++) {
			int number = rand.nextInt(Integer.MAX_VALUE);
			array[i] = number;
		}
		return array;
	}
	
}

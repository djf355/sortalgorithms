import java.lang.reflect.Array;
import java.util.Random;


/**
 * @author Demi Frechette
 * This class contains generic methods for different sorts using arrays.
 */

public class SortMethods {

		/**
		 * Sorts the given array using selection sort algorithm
		 * @param list - array to sort
		 */
		public static <E extends Comparable<E>> void selectionSort(E[] list) {
			for (int i = 0; i < list.length - 1; i++) {
				// initialize variables for minimum value and index
				E currentMin = list[i];
				int currentMinIndex = i;
				// loop through list length to find minimum
				for(int j = i + 1; j < list.length; j++) {
					if(currentMin.compareTo(list[j]) > 0) {
						currentMin = list[j];
						currentMinIndex = j;
					}
				}
				// swap i value with the current if it's changed
				if(currentMinIndex != i) {
					list[currentMinIndex] = list[i];
					list[i] = currentMin;
				}
			}
		}
		
		/**
		 * Sorts the given array using the mergesort algorithm
		 * @param list - array to sort
		 * @param left - starting position
		 * @param right - final position
		 */
		public static <E extends Comparable<E>> void mergeSort(E[] list, int left, int right) {
			// keep track of the new sizes
			int newSize = right - left; 
			// base case
			if (newSize <= 1) 
				return; 
			// find the middle
			int middle = left + newSize/2; 
			// recursively sort 
			mergeSort(list, left, middle); 
			mergeSort(list, middle, right); 
			
			// merge all parts
			E[] temp = (E[]) Array.newInstance(list.getClass().getComponentType(), newSize);
			// create different references, to not alter above references
			int i = left;
			int j = middle;
			// loop through the newSize of the array
			for(int k = 0; k < newSize; k++) {
				// if the left is the middle, populate starting at middle
				if(i == middle)  
				//if(i == middle || list[j].compareTo(list[i]) < 0) *this is a change I tried*
					temp[k] = list[j++];
				// if the right is the middle, populate starting at left
				else if(j == right) 
					temp[k] = list[i++];
				// if the middle is less than the left, populate the middle
				else if(list[j].compareTo(list[i]) < 0) 
					temp[k] = list[j++];
				// else, populate the left
				else 
					temp[k] = list[i++];
			}    
			// loop through the new array sizes to add to the new array
			for(int k = 0; k < newSize; k++) 
				list[left + k] = temp[k];         
		}
		
		/**
		 * Sorts the given array using quick sort algorithm.
		 * @param list array to sort
		 */
		public static <E extends Comparable<E>> void quickSort(E[] list, int start, int end) {
			// choose the pivot position using partition method
			Integer index = partition(list, start, end);
			// recursively call each side of the pivot positions
			if (start < index - 1)
				quickSort(list, start, index - 1);
			if (index < end)
				quickSort(list, index, end);
		}
		
		/**
		 * Partitions the given array for the quick sort methods, numbers smaller than pivot on
		 * one side and numbers larger than pivot on the other side
		 * @param list - array to partition
		 * @param left - start index of list/sublist to divide
		 * @param right - end index of list/sublist to divide
		 * @return an Integer to use in the quickSort method
		 */
		// part of the quick sort algorithm, partitions the 
		public static <E extends Comparable<E>> Integer partition(E[] list, Integer left, Integer right) {
			// initializes the variables to store values
		    E temp;
		    E pivot = list[(left + right) / 2];
		    // loop through, base case
		    while(left <= right) {
		    	// compare left side to the pivot
		    	while(list[left].compareTo(pivot) < 0)
		    		// increment to check the next position
		    		left++;
		    	// compare right side to the pivot
		        while(list[right].compareTo(pivot) > 0)
		        	// increment to check the previous position
		            right--;
		        // check if values need to be swapped
		        if(left <= right) {
		        	// swap the left and right values
		            temp = list[left];
		            list[left] = list[right];
		            list[right] = temp;
		            left++;
		            right--;
		        }
		    }
		    // return the position that has been determined
		    return left;
		}
	}
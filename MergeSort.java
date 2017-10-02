package mergesort;
/*   
	Author: Chan In Kou
	Purpose: This program will sort an array list with merge sort 
*/

public class MergeSort {

	public static void main(String args[]) {
		int array[] = {4, 3, 1, 2, 2, 6, 5};

		System.out.println("original Array");
		printArray(array);
		
		System.out.println("\n ");

		mergeSort(array, 0, array.length - 1);

		System.out.println("Sorted array");
		printArray(array);
	}

	// sorts array[l..r]
	public static void mergeSort(int array[], int p, int r) {
		if (p < r) {
			// get the middle
			int q = (p + r) / 2;
//			System.out.println("mid: " + q);

			// sort the First array[l..q]
			mergeSort(array, p, q);
			
			// sort the Second array[q+1..r]
			mergeSort(array, q + 1, r);	

			// Merge the two sorted array
			merge(array, p, q, r);
			
//			System.out.println(" ");	
//			System.out.println("List: ");
			
//			for (int i = 0; i < array.length; i++)
//			{
//				System.out.print(array[i] + " ");
//			}
//			
//			System.out.println(" ");
		}
	}

	public static void merge(int array[], int p, int q, int r) {
		// sizes of two subarrays to be merged
		int n1 = q - p + 1;
		int n2 = r - q;

		// new array
		int Left[] = new int[n1];
		int Right[] = new int[n2];
		
//		System.out.println("_________________");

		// copy array to new array
		for (int i = 0; i < n1; i++) {
			Left[i] = array[p + i];
//			System.out.println("L = " + Left[i]);
		}
		
		for (int j = 0; j < n2; j++) {
			Right[j] = array[q + 1 + j];
//			System.out.println("R = " + Right[j]);
		}
		
//		System.out.println("_________________");


		// indexes of first and second array
		int i = 0;
		int j = 0;

		// Initial index of merged subarry array
		int k = p;
		
//		System.out.println("k: " + k);
//		System.out.println("i: " + i + " n1: " + n1);
//		System.out.println("j: " + j + " n2: " + n2);
		
		while (i < n1 && j < n2) {
			if (Left[i] <= Right[j]) {
				array[k] = Left[i];
//				System.out.println("arr1: " + array[k]);
				i++;
			} else {
				array[k] = Right[j];
//				System.out.println("arr2: " + array[k]);
				j++;
			}
			k++;
		}
		
		while (i < n1) {
			array[k] = Left[i];
//			System.out.println("remaining element");
//			System.out.println("arr3: " + array[k]);
			i++;
			k++;
		}

		while (j < n2) {
			array[k] = Right[j];
//			System.out.println("remaining element");
//			System.out.println("arr4: " + array[k]);
			j++;
			k++;
		}
	}

	public static void printArray(int array[]) {
		for (int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + " ");
		}
	}
}

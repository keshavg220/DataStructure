package sortingTest;

public class SelectionSort {
	public static void selectionSort(int[] A) {
		for(int i=0; i< A.length; i++) {
			int minimumIndex = i;
			for(int j = i+1; j<A.length; j++) {
				if(A[j]<A[minimumIndex]) 
					minimumIndex = j;
				
			}
				if (minimumIndex != i) { // if j is not minimum index then swap
					int temp = A[i];
					A[i] = A[minimumIndex];
					A[minimumIndex] = temp;
				}
			
		}
	}
	public static void printArray(int []array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+"  ");
		}
	}
}
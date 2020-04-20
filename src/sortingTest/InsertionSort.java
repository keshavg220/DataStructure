package sortingTest;
 public class InsertionSort{
	  
	 static void insertionSort(int[] arr) {
		 int n = arr.length;
		 for(int i = 0; i < n; i++) {
			 int temp = arr[i]; int j =i;
			 while(j >0 && arr[j-1]>temp) {
				 arr[j] = arr[j-1];
				 j--;
			 }
			 arr[j] = temp;
		 }
	 }
	 public static void printArray(int[] A) {
		 for(int i = 0; i<A.length ; i++) {
			 System.out.print(A[i] + " ");
			 
		 }
	 }
	 
 }
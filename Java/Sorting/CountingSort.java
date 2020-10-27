public class CountingSort {

		// Sorting Function
		private static int[] sort(int[] a, int n) {

		// MIN-MAX Variables
		int MIN=a[0], MAX=a[0];
		for(int i=1; i<n; i++) {
			if (a[i] < MIN) { MIN = a[i]; }
			if (a[i] > MAX) { MAX = a[i]; }
		}
		// OFFSET to count offset from negative end to zero
		int OFFSET = MIN>=0 ? 0 : -(MIN)+1;

		// If there is a negative no., then add offset
		if (OFFSET != 0) {
			for (int i=0; i<n; i++)	{ a[i] += OFFSET; }
			MIN += OFFSET;
			MAX += OFFSET;
		}

		// Count list to store the count of occurences
		int[] count_list = new int[MAX-MIN+1];

		// Count the occurences & make if linear by adding previous count
		for (int i=0; i<n; i++) { count_list[a[i]-MIN] += 1; }
		for (int i=1; i<count_list.length; i++) { count_list[i] += count_list[i-1]; }

		// Create an output array with initial value as OFFSET
		int[] output = new int[n];
		if (OFFSET != 0) { for(int i=0; i<n; i++) { output[i] = -(OFFSET); } }
		for (int i=0; i<n; i++) { output[--count_list[a[i]-1]] += a[i]; }

		return output;

		}


		// DRIVER CODE
		public static void main(String[] args) {
				
				// Inputs
				int[] array = {23, -6, -3, 7, 34, 9, 66, 23, 55, 1};
				int n = 10;
				
				// Unsorted Array Output
				System.out.println("Unsorted Array :-");
				for (int i=0; i<n; i++)
				System.out.print(array[i]+"   ");

				// Sorting Array
				int[] sorted = sort(array, n);

				// Sorted Array Output
				System.out.println("\nSorted Array :-");
				for (int i=0; i<n; i++)
						System.out.print(sorted[i]+"   ");

		}
}
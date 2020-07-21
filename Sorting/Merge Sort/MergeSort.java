public class MergeSort {

    // Combine function
    private static void combine(int a[], int l, int m, int u) {

        int i=l, j=m+1, k=0;
        int[] temp = new int[u-l+1];

    	// Compare lower & upper part and store in temp
    	while (i<=m && j<=u) {
    		if ( a[i] <= a[j] ) {
    			temp[k++] = a[i++];
    		} else {
    			temp[k++] = a[j++];
    		}
    	}

	    // Copy remaining lower part
	    while(i<=m) { temp[k++] = a[i++]; }

	    // Copy remaining upper part
	    while(j<=u) { temp[k++] = a[j++]; }

	    // Copy sorted temp to main array
	    for (i=l; i<=u; i++) { a[i] = temp[i-l]; }

    }

    // Merge Sorting Function
    private static void merge(int[] a, int lower, int upper) {

        if (lower < upper) {
            int middle = (lower + upper)/2;

            merge(a, lower, middle);	// Divide array 
            merge(a, middle+1, upper);	// into mid

            combine(a, lower, middle, upper);	// Sort and combine
        }

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
        merge(array, 0, n-1);

        // Sorted Array Output
        System.out.println("\nSorted Array :-");
        for (int i=0; i<n; i++)
            System.out.print(array[i]+"   ");
        System.out.println();

    }
}
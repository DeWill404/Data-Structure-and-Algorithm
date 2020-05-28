public class InsertionSort {

    // Sorting Function
    private static void sort(int[] a, int n) {

        for (int i=n-1; i>0; i--) {
            for (int j=1; j<=i; j++) {
                // if (a[j] > a[j-1]) {  // Asending Order
                if (a[j] < a[j-1]) {  // Desending Order
                    int temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                }
            }
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
        sort(array, n);

        // Sorted Array Output
        System.out.println("\nUnsorted Array :-");
        for (int i=0; i<n; i++)
            System.out.print(array[i]+"   ");

    }
}
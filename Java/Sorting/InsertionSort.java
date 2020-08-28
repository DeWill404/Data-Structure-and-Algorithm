public class InsertionSort {

    // Sorting Function
    private static void sort(int[] a, int n) {

        for (int i=1; i<n; i++) {
            int j = i;
            int temp = a[i];
            // while (j>0 && temp<a[j-1]) {  // Asending Order
            while (j>0 && temp>a[j-1]) {  // Decending Order
                a[j] = a[j-1];
                j--;
            }
            a[j] = temp;
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
        System.out.println("\nSorted Array :-");
        for (int i=0; i<n; i++)
            System.out.print(array[i]+"   ");

    }
}
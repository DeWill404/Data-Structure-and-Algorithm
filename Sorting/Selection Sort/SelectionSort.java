public class SelectionSort {

    // Sorting Function
    private static void sort(int[] a, int n) {

        for (int i=0; i<n; i++) {
            int index = i;
            for (int j=i; j<n; j++) {
                // if (a[index] > a[j])     // Asending Order
                if (a[index] < a[j])        // Desending Order
                    index = j;
            }
            int temp = a[i];
            a[i] = a[index];
            a[index] = temp;
        }

    }

    // DRIVER CODE
    public static void main(String[] args) {
        
        // Inputs
        int[] array = {23, -6, -3, 7, 34, 9, 66, 23, 55, 1};
        int n = 10;
        
        // Unsorted Array Output
        System.out.println("Sorted Array :-");
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
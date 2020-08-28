public class RadixSort {

    // Sorting Function
    private static void sort(int[] a, int n) {

        int[] temp = new int[n];    // Temporary array to store sorted array at d'th iteration
        int[] count = new int[10];  // Count array to store count of digit at d'th position
    
        // Find MAX
        int max=a[0];
        for (int i=1; i<n; i++)
            if (max < a[i])
                max = a[i];
        
        // Travering through each digit
        for (int d=1; max/d > 0; d*=10) {
            
            // Reset count array
            for (int i=0; i<10; i++)
                count[i] = 0;
            
            // Set count at digit available on d'th place
            for (int i=0; i<n; i++)
                count[ (a[i]/d)%10 ]++;
        
            // Make contineous count array
            for (int i=1; i<10; i++)
                count[i] += count[i-1];
    
            // Arrange array w.r.t. d'th position
            for (int i=n-1; i>=0; i--)
                temp[ --count[(a[i]/d)%10] ] = a[i];
            
            // Copy content to original array
            for (int i=0; i<n; i++)
                a[i] = temp[i];
    
        }
    
        // Decending Order
        for (int i=0; i<n/2; i++) {
            int t = a[i];
            a[i] = a[n-i-1];
            a[n-i-1] = t;
        }

    }

    // DRIVER CODE
    public static void main(String[] args) {
        
        // Inputs
        int[] array = {23, 2, 4, 7, 34, 9, 66, 23, 55, 1};
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
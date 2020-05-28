#include <stdio.h>

// Sorting Function
void sort(int a[], int n) {
    
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
int main() {
    // Inputs
    int array[10] = {23, -6, -3, 7, 34, 9, 66, 23, 55, 1};
    int n = 10;
    
    // Unsorted Array Output
    printf("Unsorted Array :-\n");
    for (int i=0; i<n; i++)
        printf("%-4d", array[i]);

    // Sorting Array
    sort(array, n);

    // Sorted Array Output
    printf("\nUnsorted Array :-\n");
    for (int i=0; i<n; i++)
        printf("%-4d", array[i]);

    return 0;
}
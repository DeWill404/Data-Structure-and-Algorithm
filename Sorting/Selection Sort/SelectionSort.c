#include <stdio.h>

// Sorting Function
void sort(int a[], int n) {
    
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
    printf("\nSorted Array :-\n");
    for (int i=0; i<n; i++)
        printf("%-4d", array[i]);

    return 0;
}
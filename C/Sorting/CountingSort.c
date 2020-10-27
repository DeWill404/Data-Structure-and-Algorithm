#include <stdio.h>
#include <stdlib.h>

// Sorting Function
int *sort(int a[], int n) {
    
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
	int count_list[MAX-MIN+1];

	// Count the occurences & make if linear by adding previous count
	for (int i=1; i<=MAX-MIN; i++) { count_list[i] = 0; }
	for (int i=0; i<n; i++) { count_list[a[i]-MIN] += 1; }
	for (int i=1; i<=MAX-MIN; i++) { count_list[i] += count_list[i-1]; }

	// Create an output array with initial value as OFFSET
	int *output = (int *)malloc(n*sizeof(int));
	for(int i=0; i<n; i++) { output[i] = -(OFFSET); }
	for (int i=0; i<n; i++) { output[--count_list[a[i]-1]] += a[i]; }

	return output;

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
    int *sorted = sort(array, n);

    // Sorted Array Output
    printf("\nSorted Array :-\n");
    for (int i=0; i<n; i++)
        printf("%-4d", sorted[i]);

    return 0;
}	
#include <stdio.h>

// Hoarse Partition function
int partition(int a[], int down, int up) {

	// Make copy of pivot element
	int pivot = a[down], index = down;

	// Loop while smaller are not pushed to left and largers to right
	while ( down < up ) {
		// Get index of large element from left
		while (a[down]<=pivot && down<up) { down++; }
		
		// Get index of small element from right
		while(a[up]>pivot) { up--; }

		// Swap large and right
		if ( down < up ) {
			int temp = a[down];
			a[down] = a[up];
			a[up] = temp;
		}
	}

	// Put pivot to its position at up
	a[index] = a[up];
	a[up] = pivot;

	return up;

}

// Quick Sorting Function
void quick(int a[], int lower, int upper) {

	if (lower < upper) {
		int index = partition(a, lower, upper);	// Sort element w.r.t index

		quick(a, lower, index-1);	// Move into remaining lower half
		quick(a, index+1, upper);	// Move into remaining upper half
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
	quick(array, 0, n-1);


	// Sorted Array Output
	printf("\nSorted Array :-\n");
	for (int i=0; i<n; i++)
		printf("%-4d", array[i]);
	printf("\n");

	return 0;
}
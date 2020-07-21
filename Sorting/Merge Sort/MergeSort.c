#include <stdio.h>

// Combine Function
void combine(int a[], int l, int m, int u) {
	
	// Create temporary Referance
	int i=l, j=m+1, k=0;
	int temp[u-l+1];

	// Compare lower & upper part and store in temp
	while (i<=m && j<=u) {
		if (a[i]<=a[j]) { temp[k++]=a[i++]; }
		else			{ temp[k++]=a[j++]; }
	}

	// Copy remaining lower part
	while(i<=m) { temp[k++] = a[i++]; }

	// Copy remaining upper part
	while(j<=u) { temp[k++] = a[j++]; }

	// Copy sorted temp to main array
	for (int i=l; i<=u; i++) { a[i] = temp[i-l]; }

}

// Merge Sorting Function
void merge(int a[], int lower, int upper) {

	if (lower < upper) {
		int middle = (lower+upper)/2;

		merge(a, lower, middle);	// Divide array 
		merge(a, middle+1, upper);	// into mid

		combine(a, lower, middle, upper);	// Sort and combine
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
	merge(array, 0, n-1);

	// Sorted Array Output
	printf("\nSorted Array :-\n");
	for (int i=0; i<n; i++)
		printf("%-4d", array[i]);
	printf("\n");

	return 0;
}
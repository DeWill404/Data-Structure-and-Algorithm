#include <stdio.h>
#include <stdlib.h>
#include <math.h>

// Function to generate list of factors
int* get_factorsList(int n) {
	// Initialize array
	int *list = (int *)malloc(sizeof(int)*((int)sqrt(n)+1));
	int ptr=0;

	*(list+ptr++) = 1;	// Add 1, as it is factor of all no.

	// Find remaining factor till n/2, as it is largest factor
	for (int i=2; i<=n/2; i++)
		if (n%i == 0)
			*(list+ptr++) = i;

	// Append 1 if it is not 1
	if (1 != n)
		*(list+ptr) = n;

	return list;
}


int main() {
	// Input Array
	int arr[] = {23, 46, 65, 34234, 423, 43212};

	for (int i=0; i<6; i++) {
		// Get list factor of arr[i]
		int *temp = get_factorsList(arr[i]);

		// Print all factors
		for (int j=0; temp[j] != 0; j++)
			printf("%d ",temp[j]);
		printf("\n");
	}
	return 0;
}

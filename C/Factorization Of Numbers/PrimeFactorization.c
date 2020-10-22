#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int generate_factors(int l[], int ptr, int pf, int con) {
	for (int i=ptr-1; i>=0; i--)
		if ((i==0 && con) || i!=0)
			*(l+ptr++) = *(l+i)*pf;
	return ptr;
}

// Function to generate list of factors
int* get_factorsList(int n) {
	// Initialize array
	int *list = (int *)malloc(sizeof(int)*((int)sqrt(n)+1));
	int ptr = 0;

	int condition = 1;

	*(list+ptr++) = 1;	// Add 1, as it is factor of all no.

	// Check if 2 is in prime factor
	while (n%2 == 0) {
		ptr = generate_factors(list, ptr, 2, condition);
		condition = 0;
		n /= 2;
	}

	// Check if other odd prime factors
	for (int i=3; i<=(int)sqrt(n); i+=2) {
		condition = 1;
		// Check if i is in prime factor
		while (n%i == 0) {
			ptr = generate_factors(list, ptr, i, condition);
			condition = 0;
			n /= i;
		}
	}

	// to append last prime factor in list
	if (n > 2) { generate_factors(list, ptr, n, 1); }

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

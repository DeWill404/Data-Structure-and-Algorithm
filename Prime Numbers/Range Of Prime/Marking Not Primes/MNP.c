#include <stdio.h>
#include <stdlib.h>

// Sieve Function
char *seive(int max) {

	// Reviesed Max
	int seive_limit = max/2;
	// Set index to first not prime no. index
	int initial = 4;

	// Prime list
	char *p = (char *)malloc((seive_limit+1)*sizeof(char));

	// Set Value to true
	for (int i=0; i<=seive_limit; i++) { p[i] = '1'; }

	// Marking marking not prime no.
	for (int step=3; step<=max; step+=2) {
		for (int notPrime_index=initial;
			notPrime_index<seive_limit;
			notPrime_index+=step)
			{ p[notPrime_index-1] = '0'; }
		initial += 2*(step+1);

		// Once, all index are checked exit.
		if (initial > seive_limit) { return p; }
	}

}

// DRIVER CODE
void main() {
	// Upmost limit
	int max;
	scanf("%d", &max);

	// Get Primelist
	char *primeList = seive( max );

	// Print prime list
	printf("2 ");
	for ( int i=0; i<(max-1)/2; i++ ) {
		// Print on if i is checked
		if ( primeList[i]=='1' ) {
			// i is odd index of no. N and i start from 0 so N will be 2*(i+1)+1
			printf("%d ", 2*(i+1)+1);
		}
	}
	printf("\n");
}
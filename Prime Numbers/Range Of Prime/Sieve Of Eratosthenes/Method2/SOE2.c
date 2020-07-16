#include <stdio.h>
#include <stdlib.h>
#include <math.h>

// Sieve of Eratosthenes Factors Of ODD
/*
	This algo is for optimizing space complexity by half....
*/
char *seive(int seive_limit, int seive_root) {

	// Prime list
	char *p = (char *)malloc((seive_limit+1)*sizeof(char));

	// Set Value to true
	for (int i=0; i<=seive_limit; i++) {
		p[i] = '1';
	}

	// Marking prime on the basis of the odd factors
	for (int i=1; i<=seive_root; i++)
		if ( p[i]=='1' )
			for (int j=2*i*(i+1); j<=seive_limit; j+=2*i+1)
				p[j] = '0';

	return p;
}

// DRIVER CODE
void main() {
	// Upmost limit
	int max;
	scanf("%d", &max);

	// Reviesed MAX
	int sl = (max-1)/2;
	// Reviesed MAX square root
	int sr = (int)round(sqrt(max)-1)/2;

	// Get Primelist
	char *primeList = seive( sl, sr );

	// Print prime list
	printf("2 ");
	for ( int i=1; i<=sl; i++ )
		if ( primeList[i]=='1' )
			printf("%d ", 2*i+1);
	printf("\n");
}
#include <stdio.h>
#include <stdlib.h>

// Sieve of Eratosthenes
char *seive(int max) {
	// Prime list
	char *p = (char *)malloc((max+1)*sizeof(char));

	// Set Value to true
	for (int i=2; i<=max; i++) { p[i] = '1'; }

	p[0] = p[1] = '0';
	for (int i=2; i*i<=max; i++)
		if ( p[i]=='1' )
			for (int j=i*i; j<=max; j+=i)
				p[j] = '0';

	return p;
}

// DRIVER CODE
void main() {
	// Upmost limit
	int max;
	scanf("%d", &max);

	// Get Primelist
	char *primeList = seive(max);

	// Print prime list
	for ( int i=0; i<=max; i++ )
		if ( primeList[i]=='1' )
			printf("%d ", i);
}
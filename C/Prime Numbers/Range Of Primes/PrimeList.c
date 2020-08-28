#include <stdio.h>

// User-defined boolean datatypes
typedef enum boolean {false, true} bool;

// Optimized school of Prime function
bool isprime( int n ) {

	// If no. is 1, or negative
	if (n < 2) { return false; }

	// If no. is 2 or 3
	if ( n==2 || n==3 ) { return true; }
	
	// If no. os multiple of 2 and 3
	if ( n%2==0 || n%3==0 ) { return false; }

	// If no. is multiple of 6
	for ( int i=5; i*i<=n; i+=6 )
		if ( n%i==0 || n%(i+2)==0 )
			return false;

	// If all above condition is false
	return true;

}

// DRIVER CODE
void main() {
	// Upmost limit
	int max;
	scanf("%d", &max);

	// Get Primelist
	char primeList[max+1];
	for (int i=0; i<=max; i++)
		primeList[i] = isprime(i) ? '1' : '0' ;

	// Print prime list
	for ( int i=0; i<=max; i++ )
		if ( primeList[i]=='1' )
			printf("%d ", i);
}
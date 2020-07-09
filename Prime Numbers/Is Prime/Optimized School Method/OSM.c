#include <stdio.h>

// User-defined boolean datatypes
typedef enum boolean {false, true} bool;

// Prime function
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

// DRIVER FUNCTION
int main() {
	// Number
	int number;
	scanf("%d", &number);

	// Is prime ?
	if ( isprime( number ) ) {
		printf("%d is a Prime no.\n", number);
	}
	else {
		printf("%d is not a Prime no.\n", number);
	}

	return 0;
}
import java.util.Scanner;

public class OptimizedSchoolMethod {

	// Prime Function
	private static boolean isprime( int n ) {
		// If no. is 1, or negative 
		if ( n<2 ) { return false; }

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

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Input
		int number = sc.nextInt();

		// Is prime ?
		if ( isprime( number ) ) {
			System.out.println(number+" is a Prime no.");
		} else {
			System.out.println(number+" is not a Prime no.");
		}
	}
	
}
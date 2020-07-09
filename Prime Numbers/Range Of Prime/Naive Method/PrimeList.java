import java.util.ArrayList;
import java.util.Scanner;

public class PrimeList {
	// Optimized school of Prime Function
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

		// Get max limit
		int max= sc.nextInt();

		// Get prime list
		ArrayList<Integer> primeList = new ArrayList<>();
		for (int i=0; i<=max; i++)
			if (isprime(i))
				primeList.add(i);

		// Print list
		System.out.println(primeList);
	}
}
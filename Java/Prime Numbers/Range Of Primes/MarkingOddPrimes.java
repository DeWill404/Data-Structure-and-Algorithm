import java.util.ArrayList;
import java.util.Scanner;

public class MarkingOddPrimes {
	// Sieve of Eratosthenes Factors Of ODD
	/*
		This algo is for optimizing space complexity by half....
	*/
	private static ArrayList<Integer> seive(int max) {
		// Reviesed MAX
		int seive_limit = (max-1)/2;
		// Reviesed MAX square root
		int seive_root = (int)Math.round(Math.sqrt(max)-1)/2;

		// Bool List
		boolean[] p = new boolean[seive_limit+1];

		// Set all values to true
		for (int i=0; i<=seive_limit; i++) {
			p[i]=true;
		}

		// Marking prime on the basis of the odd factors
		for (int i=1; i<=seive_root; i++)
			if ( p[i] )
				for (int j=2*i*(i+1); j<=seive_limit; j+=2*i+1)
					p[j] = false;

		// Get only primes
		ArrayList<Integer> prime = new ArrayList<>();
		prime.add(2);
		for (int i=1; i<=seive_limit; i++)
			if ( p[i] )
				prime.add(2*i+1);

		return prime;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Get max limit
		int max= sc.nextInt();

		// Get prime list
		ArrayList<Integer> primeList = seive( max );

		// Print list
		System.out.println(primeList);
	}
}
import java.util.ArrayList;
import java.util.Scanner;

public class SOE {
	// Seive OF Eratosthenes
	private static ArrayList<Integer> seive(int max) {
		// Bool List
		boolean[] p = new boolean[max+1];
		for (int i=2; i<=max; i++) { p[i]=true; }

		// Get primes
		for (int i=2; i*i<=max; i++)
			if ( p[i] )
				for (int j=i*i; j<=max; j+=i)
					p[j] = false;

		// Get only primes
		ArrayList<Integer> prime = new ArrayList<>();
		for (int i=0; i<=max; i++)
			if ( p[i] )
				prime.add(i);

		return prime;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Get max limit
		int max= sc.nextInt();

		// Get prime list
		ArrayList<Integer> primeList = seive(max);

		// Print list
		System.out.println(primeList);
	}
}
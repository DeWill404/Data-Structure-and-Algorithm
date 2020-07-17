import java.util.ArrayList;
import java.util.Scanner;

public class MNP {
	// Seive Function
	private static ArrayList<Integer> seive(int max) {
		// Reviesed MAX
		int seive_limit = (max)/2;
		// Set index to first not prime no. index
		int initial = 4;

		// Bool List
		boolean[] p = new boolean[seive_limit+1];

		// Set all values to true
		for (int i=0; i<=seive_limit; i++) { p[i] = true; }

		// Marking marking not prime no.
		for (int step=3; step<=max; step+=2) {
			for(int notPrime = initial;
					notPrime < seive_limit;
					notPrime += step)
					{ p[notPrime-1] = false; }
			initial += 2*(step+1);

			// Once, all index are checked exit.
			if (initial > seive_limit) {
				
				ArrayList<Integer> prime = new ArrayList<>();
				prime.add(2);
				for (int i=0; i<(max-1)/2; i++)
					// Select if i is checked
					if ( p[i] )
						// i is odd index of no. N and i start from 0 so N will be 2*(i+1)+1
						prime.add(2*(i+1)+1);
				return prime;
				
			}
		}
		return null;
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
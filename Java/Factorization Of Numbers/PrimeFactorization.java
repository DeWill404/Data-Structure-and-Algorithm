public class PrimeFactorization {
	// Function to generate factor by multipling current prime factor to all element of list
	private static int generate_factors(int[] l, int ptr, int pf, int con) {
		for (int i=ptr-1; i>=0; i--)
			// As l[0] = 1, so if n*1 will n, and we want only one n in list
			if ((i==0 && con==1) || i!=0)
				l[ptr++] = l[i]*pf;
		return ptr;
	}


	// Function to generate list of factors
	private static int[] get_factorsList(int n) {
		// Initialize array
		int[] list = new int[(int)Math.sqrt(n)+1];
		int ptr = 0;
		// Counter variable, to state iterate no.
		int condition = 1;

		list[ptr++] = 1;	// Add 1, as it is factor of all no.

		// Check if 2 is in prime factor
		while (n%2 == 0) {
			ptr = generate_factors(list, ptr, 2, condition);
			condition = 0;
			n /= 2;
		}

		// Check if other odd prime factors
		for (int i=3; i<=(int)Math.sqrt(n); i+=2) {
			condition = 1;
			// Check if i is in prime factor
			while (n%i == 0) {
				ptr = generate_factors(list, ptr, i, condition);
				condition = 0;
				n /= i;
			}
		}

		// to append last prime factor in list
		if (n > 2) { generate_factors(list, ptr, n, 1); }

		return list;
	}


	public static void main(String[] args) {
		// Input Array
		int[] arr = {23, 46, 65, 34234, 423, 43212};

		for (int i=0; i<arr.length; i++) {
			// Get list factor of arr[i]
			int[] temp = get_factorsList(arr[i]);

			// Print all factors
			for (int j=0; j<temp.length&&temp[j]!=0; j++)
				System.out.print(temp[j]+" ");
			System.out.println();
		}
	}
}
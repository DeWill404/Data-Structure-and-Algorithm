public class NaiveFactorization {
	// Function to generate list of factors
	private static int[] get_factorsList(int n) {
		// Initialize array
		int[] list = new int[(int)Math.sqrt(n)+1];
		int ptr = 0;

		list[ptr++] = 1;	// Add 1, as it is factor of all no.

		// Find remaining factor till n/2, as it is largest factor
		for (int i=2; i<=n/2; i++)
			if (n%i == 0)
				list[ptr++] = i;

		// Append 1 if it is not 1
		if (1 != n)
			list[ptr] = n;

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
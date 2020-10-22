# Function to generate list of factors
def get_factorsList(n):
	l = [1]	# will be factor of any no.

	# As n/2 is largest factor of n less then n
	for i in range(2, n//2+1):
		if n%i==0:	# Check if factor or not
			l.append(i)
	
	# As we already added 1 in list no need to append it again
	if n != 1:
		l.append(n)

	# Oneliner
	# return [i for i in range(1,n//2+1) if n%i==0] + ([n] if n!=1 else [])

	return l


if __name__ == "__main__":
	# List of input no's
	list_of_numbers = [23, 46, 65, 34234, 423, 43212]

	# Get factor list of given no.
	for num in list_of_numbers:
		print(get_factorsList(num))
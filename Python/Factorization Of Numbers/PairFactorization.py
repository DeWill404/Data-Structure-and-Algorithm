# function to generate list of factors
def get_factorList(n):
	# Insert 1 & n in list, if is n == 1 then only add 1
	l = list(set([1,n]))

	# Iterate to sq.rt. of n to get all factors
	for i in range(2, int(n**0.5)+1):
		if n%i == 0:
			# If i & n/i aree same, then append only one
			if i == n//i:
				l.append(i)
			# else append pair
			else:
				l.extend([i,n//i])

	return l


if __name__ == "__main__":
	# List of input no's
	list_of_numbers = [23, 46, 65, 34234, 423, 43212]

	# Get factor list of given no.
	for num in list_of_numbers:
		print(get_factorList(num))
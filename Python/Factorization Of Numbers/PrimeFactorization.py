# Function to generate factor by multipling current prime factor to all element of list
def generate_factors(l, n, c):
	L= len(l)
	for i in range(L):
		# As l[0] = 1, so if n*1 will n, and we want only one n in list
		if (i==0 and c) or i!=0:
			l.append(l[i]*n)


# function to generate list of factors
def get_factorList(n):
	l = [1]	# List to store array of factor
	conditon = True	# Counter variable, to state iterate no.

	# Check if 2 is in prime factor
	while n%2 == 0:
		generate_factors(list, 2, conditon)
		conditon = False
		n //= 2

	# Check if other odd prime factors
	for i in range(3, int(n**0.5)+1, 2):
		conditon = True
		# Check if i is in prime factor
		while n%i == 0:
			generate_factors(list, i, conditon)
			conditon = False
			n //= i

	if n > 2:
		# to append last prime factor in list
		generate_factors(list, n, True)

	return list


if __name__ == "__main__":
	# List of input no's
	list_of_numbers = [23, 46, 65, 34234, 423, 43212]

	# Get factor list of given no.
	for num in list_of_numbers:
		print(get_factorList(num))
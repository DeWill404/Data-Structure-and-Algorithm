# Seive Of Eratosthenes
def seive(max):
	# Make list
	p = [True]*(max+1)

	# Set values
	p[0]=p[1]=False
	for i in range(2, int(max**0.5)+1):
		if p[i]:
			for j in range(i*i, max+1, i):
				p[j] = False

	# Return list
	return [i for i in range(max+1) if p[i]]


if __name__ == "__main__":
	max = int(input())		# Max limit
	primeList = seive(max)	# Get prime list
	print(primeList);		# Print list
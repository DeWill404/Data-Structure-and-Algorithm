# Sieve Function
def seive(max):
	# Make prime list
	p = list( range(3, max+1, 2) )
	# Revised Max limit
	seive_limit = len(p)
	# Set initial index for notprime no.
	initial = 4

	# Iterate through list and mark not prime no.
	for step in range( 3, max+1, 2 ):
		for i in range( initial, seive_limit+1, step ):
			p[i-1]=0
		initial += 2*(step+1)

		# If all values are checked
		if initial > seive_limit:
			return [2] + list(filter(None, p))


if __name__ == "__main__":
	max = int(input())		# Max limit
	primeList = seive(max)	# Get prime list
	print(primeList);		# Print list
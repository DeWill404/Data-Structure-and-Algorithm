# Sieve of Eratosthenes Factors Of ODD
# This algo is for optimizing space complexity by half....
def seive(max):
	# Reviesed MAX
	seive_limit = (max-1)//2
	# Reviesed MAX square root
	seive_root = (round(max**0.5)-1)//2

	# Make list
	p = [True]*(seive_limit+1)

	# Set values
	for i in range(1, seive_root+1):
		if p[i]:
			for j in range(2*i*(i+1), seive_limit+1, 2*i+1):
				p[j] = False

	# Return list
	return [2]+[2*i+1 for i in range(1, seive_limit+1) if p[i]]


if __name__ == "__main__":
	max = int(input())		# Max limit
	primeList = seive(max)	# Get prime list
	print(primeList);		# Print list
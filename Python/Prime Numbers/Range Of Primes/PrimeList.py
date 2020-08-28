# Optimized School of prime Function
def isPrime(n):
	# If no. is 1, or negative 
	if n < 2:
		return False

	# If no. is 2 or 3
	if n==2 or n==3:
		return True

	# If no. os multiple of 2 and 3
	if n%2==0 or n%3==0:
		return False

	# If no. is multiple of 6
	for i in range(5, int(n**0.5)+1, 6):
		if n%i==0 or n%(i+2)==0:
			return False

	# If all above condition is false
	return True


if __name__ == "__main__":
	max = int(input())		# Max limit

	# Get prime list
	primeList = [i for i in range(max+1) if isPrime(i)]
	
	print(primeList);		# Print list
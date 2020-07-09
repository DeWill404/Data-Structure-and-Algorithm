# Prime Function
def isprime( n ):
	# If no. is 1, or negative 
	if n < 2:
		return False

	# If no. is 2 or 3
	if n==2 or n==3:
		return True

	# If no. os multiple of 2 and 3
	if n%2==0 or n%3==0:
		return False

	# If no. is divisible
	for i in range(5, n//2+1):
		if n%i==0:
			return False

	# If all above condition is false
	return True


if __name__ == "__main__":
	# Input
	number = int( input() )

	# Is prime ?
	if isprime(number):
		print(f"{number} is a Prime no.")
	else:
		print(f"{number} is not a Prime no.")
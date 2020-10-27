def sort(l, n):
	# MIN-MAX Variables
	MIN, MAX = min(l), max(l)
	# OFFSET to count offset from negative end to zero
	OFFSET = 0 if MIN >= 0 else -(MIN)+1

	# If there is a negative no., then add offset
	if OFFSET:
		for i in range(n):
			l[i] += OFFSET
		MIN += OFFSET
		MAX += OFFSET

	# Count list to store the count of occurences
	count_list = [0]*(MAX-MIN+1)
	
	# Count the occurences & make if linear by adding previous count
	for i in range(n):
		count_list[l[i]-MIN] += 1
	for i in range(1, len(count_list)):
		count_list[i] += count_list[i-1]

	# Create an output array with initial value as OFFSET
	output = [-(OFFSET)]*n
	for i in l:
		output[count_list[i-1]-1] += i
		count_list[i-1] -= 1

	return output


if __name__ == "__main__":
    # Inputs
    numberList = [23, 6, 3, 7, 34, 9, 55, 1, -4, 4, -3, -3, -2, -100]
    n = len(numberList)

    # Unsorted List Output
    print(numberList)

    # Sorting List
    numberList = sort(numberList, n)

    # Sorted List Output
    print(numberList)
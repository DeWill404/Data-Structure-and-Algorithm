def sort(l, n):

    temp = [0]*n    # Temporary array to store sorted array at d'th iteration
    count = [0]*10  # Count array to store count of digit at d'th position

    # Find MAX
    _max = max(l)

    # Travering through each digit
    d = 1
    while _max//d > 0:
        
        # Reset count array
        for i in range(10):
            count[i] = 0
        
        # Set count at digit available on d'th place
        for i in range(n):
            count[ (l[i]//d)%10 ] += 1
        
        # Make contineous count array
        for i in range(1, 10):
            count[i] += count[i-1]
        
        # Arrange array w.r.t. d'th position
        for i in range(n-1, -1, -1):
            count[(l[i]//d)%10] -= 1
            temp[ count[(l[i]//d)%10] ] = l[i]
        
        # Copy content to original array
        for i in range(n):
            l[i] = temp[i]
        
        d *= 10

    # Desending Order
    # return l[::-1]
    return l


if __name__ == "__main__":
    # Inputs
    numberList = [23, 6, 3, 7, 34, 9, 66, 23, 55, 1]
    n = len(numberList)

    # Unsorted List Output
    print(numberList)

    # Sorting List
    numberList = sort(numberList, n)

    # Sorted List Output
    print(numberList)

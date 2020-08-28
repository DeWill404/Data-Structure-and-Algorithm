def sort(l, n):

    for i in range(n-1, 0, -1):
        for j in range(1, i+1):
            if l[j] < l[j-1]:  # Asending Order
            # if l[j] > l[j-1]:  # Desending Order
                l[j],l[j-1] = l[j-1],l[j]



if __name__ == "__main__":
    # Inputs
    numberList = [23, -6, -3, 7, 34, 9, 66, 23, 55, 1]
    n = len(numberList)

    # Unsorted List Output
    print(numberList)

    # Sorting List
    sort(numberList, n)

    # Sorted List Output
    print(numberList)

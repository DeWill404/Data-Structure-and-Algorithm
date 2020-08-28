def sort(l, n):

    for i in range(1, n):
        temp, j = l[i], i
        # while j>0 and temp<l[j-1]:  # Asending Order
        while j>0 and temp>l[j-1]:  # Decending Order
            l[j] = l[j-1]
            j -= 1
        l[j] = temp



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

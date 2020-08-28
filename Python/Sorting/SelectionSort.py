def sort(l, n):

    for i in range(n):
        index = i
        for j in range(i,n):
            # if l[index] > l[j]:   # Asending Order
            if l[index] < l[j]:     # Desending Order
                index = j
        l[i],l[index] = l[index],l[i]


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

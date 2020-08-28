# Combine Function
def combine(a, l, m, u):
    i, j, k = l, m+1, 0
    temp = []

    # Compare lower & upper part and store in temp
    while i<=m and j<=u:
        if a[i] <= a[j]:
            temp.append(a[i])
            i += 1
        else:
            temp.append(a[j])
            j += 1
        k += 1

    # Copy remaining lower part
    while i <= m:
        temp.append(a[i])
        i += 1
        k += 1
    
    # Copy remaining upper part
    while j <= u:
        temp.append(a[j])
        j += 1
        k += 1
        
    # Copy sorted temp to main array
    a[l:u+1] = temp


# Merge Sort Function
def merge(a, lower, upper):
    if lower < upper:
        middle = (lower + upper)//2

        merge(a, lower, middle) # Divide array 
        merge(a, middle+1, upper)   # into mid

        combine(a, lower, middle, upper)    # Sort and combine



if __name__ == "__main__":
    # Inputs
    numberList = [23, -6, -3, 7, 34, 9, 66, 23, 55, 1]
    n = len(numberList)

    # Unsorted List Output
    print(numberList)

    # Sorting List
    merge(numberList, 0, n-1)

    # Sorted List Output
    print(numberList)

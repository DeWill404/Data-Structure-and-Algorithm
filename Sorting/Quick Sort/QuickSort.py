# Hoarse Partition Function
def partition(a, down, up):

    # Make copy of pivot element
    pivot, index = a[down], down

    # Loop while smaller are not pushed to left and largers to right
    while down < up:
        
        # Get index of large element from left
        while a[down]<=pivot and down< up:
            down += 1

        # Get index of small element from right
        while a[up]>pivot:
            up -= 1

        # Swap large and right
        if down < up:
            a[down], a[up] = a[up], a[down]
    
    # Put pivot to its position at up
    a[index] = a[up]
    a[up] = pivot

    return up


# Quick Sort Function
def quick(a, lower, upper):

    if lower < upper:
        index = partition(a, lower, upper)  # Sort element w.r.t index

        quick(a, lower, index-1)    # Move into remaining lower half
        quick(a, index+1, upper)    # Move into remaining upper half



if __name__ == "__main__":
    # Inputs
    numberList = [23, -6, -3, 7, 34, 9, 66, 23, 55, 1]
    n = len(numberList)

    # Unsorted List Output
    print(numberList)

    # Sorting List
    quick(numberList, 0, n-1)

    # Sorted List Output
    print(numberList)

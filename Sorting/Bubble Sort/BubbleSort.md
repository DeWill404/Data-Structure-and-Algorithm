# Bubble Sort #
##### Bubble sort, sometimes referred to as sinking sort, is a simple sorting algorithm that repeatedly steps through the list, compares adjacent elements and swaps them if they are in the wrong order. The pass through the list is repeated until the list is sorted. ####

### Algorithm
1)		Take an array A[N], of length N.
2)		for i=N-1 to i>0, do i-1
3)          for j=1 to j==i, do
4)			if A[j] < A[j-1]    	// For Ascending order
5)              SWAP(A[j], A[j-1])
OR
1)		Take an array A[N], of length N.
2)		for i=1 to N, do 
3)          for j=0 to N-i, do
4)			if A[j] < A[j+1]    	// For Ascending order
5)              SWAP(A[j], A[j+1])

### Explanation
![Explanation](https://eleni.blog/wp-content/uploads/2019/06/bubble_sort.png)
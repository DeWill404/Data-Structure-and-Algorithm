# Bubble Sort #
##### Selection sort is an in-place comparison sorting algorithm. It has an O(n²) time complexity, which makes it inefficient on large lists, and generally performs worse than the similar insertion sort. ####

### Algorithm
1)		Take an array A[N], of length N.
2)		for i=0 to N, do
3)			INDEX = i
4)          for j=i to N, do
5)				if A[INDEX] > A[j]		// For Ascending order
6)					INDEX = j
7)			SWAP(A[i], A[INDEX])
OR
1)		Take an array A[N], of length N.
2)		for i=N-1 to i>0, do i-1
3)			INDEX = i
4)          for j=0 to i, do
5)				if A[INDEX] < A[j]		// For Ascending order
6)					INDEX = j
7)			SWAP(A[i], A[INDEX])

### Explanation
![Explanation](https://i.stack.imgur.com/5ai2E.jpg)
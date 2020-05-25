# Insertion Sort #
##### Insertion sort is a simple sorting algorithm that builds the final sorted array one item at a time. It is much less efficient on large lists ####

### Algorithm
1)		Take an array A[N], of length N.
2)		for i=1 to N-1, do
3)			j, temp = i, A[i]
4)			while if(temp<A[j-1] and j>0), do		// For Ascending order
5)				A[j] = A[j-1]
6)				j--
7) 		A[j] = temp

### Explanation
![Explanation](https://media.geeksforgeeks.org/wp-content/uploads/insertionsort.png)
# Radix Sort #
##### Radix sort also known as Bucket Sort is a non-comparative sorting algorithm. It avoids comparison by creating and distributing elements into buckets according to their radix. ####

### Algorithm
1)		Take an array A[N] of size N
2)		MAX = max(A)
3)		for digit=1 while (MAX//digit > 0), do digit*10
4)			COUNT_DIGIT[10] = 0, TEMP[N]
5)			for i=0 to n, do
6)				index = ( integerDivision(A[i], digit) )%10
7)				COUNT_DIGIT[index]++
8)			for i=1 to 10, do
9)				COUNT_DIGIT[i] += COUNT_DIGIT[i-1]
10)			for i=n-1 to i>=0, do i-1
11)				index = ( integerDivision(A[i], digit) )%10
12)				COUNT_DIGIT[index]--
13)				TEMP[COUNT_DIGIT[index]] = A[i]
14)			COPY(A, TEMP)

### Explanation
![Explanation](https://www.ritambhara.in/wp-content/uploads/2018/01/Screen-Shot-2018-01-13-at-3.26.15-PM.png)
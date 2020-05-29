#include <stdio.h>

// Enum var to generalize true false condition
enum condition {FALSE = -1, TRUE = 1};

// Stack varaible
# define MAX 5
int stack[MAX];
int TOP = -1;

// OVERFLOW check function
int OVERFLOW() {
	if (TOP == MAX-1) { return TRUE; }
	else 		   	  { return FALSE; }
}

// UNDERFLOW check function
int UNDERFLOW() {
	if (TOP == -1) { return TRUE; }
	else 		   { return FALSE; }
}

// PUSH into stack function
int push(int item) {
	if (OVERFLOW() == FALSE) {  // If not overflowed
		stack[++TOP] = item;
		return TRUE;
	}
	return FALSE;
}

// POP from stack function
int pop() {
	if (UNDERFLOW() == FALSE) {  // If not underflowed
		return stack[TOP--];
	}
	return FALSE;
}

// DISPLAY item from stack
void display() {
	if (UNDERFLOW() == FALSE) {  // If not underflowed
		for (int i = TOP; i >= 0; i--) {
			printf("%-5d",stack[i]);
		}
		printf("\n");
	}
	else {
		printf("-> UNDERFLOW <- \n");
	}
}


// DRIVER CODE
int main() {
	int switch_var;		// Switch Variable
	int exit = FALSE;	// Exit condition
	int temp;			// Temporary variable

	while (exit == FALSE) {
		// Menu
		printf("\nEnter \n\t1. PUSH \n\t2. POP \n\t3. DISPLAY \n\t4. EXIT \n-> ");
		scanf("%d", &switch_var);

		switch (switch_var) {
			// PUSH
			case 1:
				printf("Enter a value to push : ");
				scanf("%d", &temp);
				if (push(temp) == TRUE) {  // If not oveflowed
					printf("%d is pushed into stack.\n", temp);
				}
				else {
					printf("-> OVERFLOW <- \n");
				}
				break;
			// POP
			case 2:
				temp = pop();
				if (temp == FALSE) {  // If not underflowed
					printf("-> UNDERFLOW <- \n");
				}
				else {
					printf("The poped value is %d.\n", temp);
				}
				break;
			// DISPLAY
			case 3:
				display();
				break;
			// EXIT
			case 4:
				exit = TRUE;
				break;
			// INVALID
			default:
				printf("Enter a valid option.\n");
				break;
		}
	}

	return 0;
}
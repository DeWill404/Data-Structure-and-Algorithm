#include <stdio.h>

// Queue Initialization
#define MAX 5
int queue[MAX];
int BACK=-1, FRONT=-1;

enum condition{FALSE=-1, TRUE=1};

// OVERFLOW CONDITION
int OVERFLOW() {
    if (BACK == MAX-1) {
        return TRUE;
    }
    else {
        return FALSE;
    }
}

// UNDERFLOW CONDITION
int UNDERFLOW() {
    if (BACK == -1) {
        return TRUE;
    } 
    else {
        return FALSE;
    }
}

// Push into queue
int insert(int item) {
    if (OVERFLOW() == FALSE) {
        if (BACK==-1)
            FRONT=0;
        queue[++BACK] = item;
        return TRUE;
    }
    else {
        return FALSE;
    }
}

// Pop from queue BACK
int delete_back() {
    if (UNDERFLOW() == FALSE) {
		int temp = queue[FRONT];
		if (FRONT == BACK)
			FRONT = BACK = -1;
		else
			BACK--;
        return temp;
    }
    else {
        return -1;
    }
}

// Pop from queue FRONT
int delete_front() {
    if (UNDERFLOW() == FALSE) {
		int temp = queue[FRONT];
		if (FRONT == BACK)
			FRONT = BACK = -1;
		else
			FRONT++;
        return temp;
    }
    else {
        return -1;
    }
}

// Display item in queue
void display() {
    if (UNDERFLOW() == FALSE) {
        for (int i=FRONT; i<=BACK; i++) {
            printf("%-5d", queue[i]);
        }
        printf("\n");
    }
    else {
        printf("-> UNDERFLOW <-\n");
    }
}


// DRIVER CODE
int main() {
    int switch_var;		// Switch Variable
	int exit = FALSE;	// Exit condition
	int temp;			// Temporary variable

	while (exit == FALSE) {
		// Menu
		printf("\nEnter \n\t1. INSERT \n\t2. DELETE BACK \n\t3. DELETE FRONT \n\t4. DISPLAY \n\t5. EXIT \n-> ");
		scanf("%d", &switch_var);

		switch (switch_var) {
			// INSERT
			case 1:
				printf("Enter a value to insert : ");
				scanf("%d", &temp);
				if (insert(temp) == TRUE) {  // If not oveflowed
					printf("%d is inserted into queue.\n", temp);
				}
				else {
					printf("-> OVERFLOW <- \n");
				}
				break;
			// DELETE BACK
			case 2:
				temp = delete_back();
				if (temp == FALSE) {  // If not underflowed
					printf("-> UNDERFLOW <- \n");
				}
				else {
					printf("The deleted value from BACK is %d.\n", temp);
				}
				break;
			// DELETE FRONT
			case 3:
				temp = delete_front();
				if (temp == FALSE) {  // If not underflowed
					printf("-> UNDERFLOW <- \n");
				}
				else {
					printf("The deleted value from FRONT is %d.\n", temp);
				}
				break;
			// DISPLAY
			case 4:
				display();
				break;
			// EXIT
			case 5:
				exit = TRUE;
				break;
			// INVALID
			default:
				printf("Enter a valid option\n");
				break;
		}
	}
	
	return 0;
}
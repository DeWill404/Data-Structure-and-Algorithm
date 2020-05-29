#include <stdio.h>

// Queue Initialization
#define MAX 5
int queue[MAX];
int BACK=-1, FRONT=-1;

enum condition{FALSE=-1, TRUE=1};
enum mode{front, back};

// OVERFLOW CONDITION
int OVERFLOW(int ForB) {
	if (ForB == front) {
		if (BACK == MAX-1) {
			return TRUE;
		}
		else {
			return FALSE;
		}
	}
	else {
		if (FRONT <= 0) {
			return TRUE;
		}
		else {
			return FALSE;
		}
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

// Push into queue BACK
int insert_front(int item) {
    if (OVERFLOW(front) == FALSE) {
        if (BACK==-1)
            FRONT=0;
        queue[++BACK] = item;
        return TRUE;
    }
    else {
        return FALSE;
    }
}

// Push into queue FRONT
int insert_back(int item) {
    if (OVERFLOW(back) == FALSE) {
        queue[--FRONT] = item;
        return TRUE;
    }
    else {
        return FALSE;
    }
}

// Pop from queue FRONT
int delete() {
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
		printf("\nEnter \n\t1. INSERT BACK\n\t2. INSERT FRONT \n\t3. DELETE \n\t4. DISPLAY \n\t5. EXIT \n-> ");
		scanf("%d", &switch_var);

		switch (switch_var) {
			// INSERT BACK
			case 1:
				printf("Enter a value to insert : ");
				scanf("%d", &temp);
				if (insert_front(temp) == TRUE) {  // If not oveflowed
					printf("%d is inserted from front into queue.\n", temp);
				}
				else {
					printf("-> OVERFLOW <- \n");
				}
				break;
			// INSERT FRONT
			case 2:
				printf("Enter a value to insert : ");
				scanf("%d", &temp);
				if (insert_back(temp) == TRUE) {  // If not oveflowed
					printf("%d is inserted from back into queue.\n", temp);
				}
				else {
					printf("-> OVERFLOW <- \n");
				}
				break;
			// DELETE
			case 3:
				temp = delete();
				if (temp == FALSE) {  // If not underflowed
					printf("-> UNDERFLOW <- \n");
				}
				else {
					printf("The deleted value is %d.\n", temp);
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
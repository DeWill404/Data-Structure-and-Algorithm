#include <stdio.h>
#include <stdlib.h>

// Queue Initialization
#define MAX 5
int BACK=-1, FRONT=-1;

enum condition{FALSE=-1, TRUE=1};

// Node structure
typedef struct Node {
	int data;
	struct Node *next;
	struct Node *prev;
} Node;
Node *head, *last, *node;

// Create newnode 
Node *createNode(int data) {
	Node *temp = (Node *)malloc(sizeof(Node));
	temp->data = data;
	temp->next = NULL;
	temp->prev = NULL;
	return temp;
}

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

        if (BACK==-1 || head==NULL) {		// If queue is empty, set head and last
			FRONT = BACK = 0;
			head = last = createNode(item);
		}
		else {								// If queue is not empty, update last
			++BACK;
			node = createNode(item);
			node->prev = last;
			last->next = node;
			last = node;
		}

        return TRUE;
    }
    else {
        return FALSE;
    }
}

// Pop from queue
int delete() {
    if (UNDERFLOW() == FALSE) {
		
		int temp = head->data;
		head = head->next;
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
		node = head;
		while(node != NULL) {
            printf("%-5d", node->data);
			node = node->next;
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
		printf("\nEnter \n\t1. INSERT \n\t2. DELETE \n\t3. DISPLAY \n\t4. EXIT \n-> ");
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
			// DELETE
			case 2:
				temp = delete();
				if (temp == FALSE) {  // If not underflowed
					printf("-> UNDERFLOW <- \n");
				}
				else {
					printf("The deleted value is %d.\n", temp);
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
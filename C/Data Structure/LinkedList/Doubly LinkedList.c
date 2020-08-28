#include <stdio.h>
#include <stdlib.h>

// Node data
typedef struct Linkedlist {
	int data;
	struct Linkedlist *next;
	struct Linkedlist *prev;
} Node;
Node *head, *last, *temp, *node;
int LENGTH = 0;

// Create node function
Node *createNode(int data) {
	Node *temp = (Node *)malloc(sizeof(Node));
	temp->data = data;
	temp->next = NULL;
	temp->prev = NULL;
	return temp;
}

// Insert Node
void insert(int index, int data) {
	if (LENGTH==0 && index==1) {  // If list is empty
		node = createNode(data);  // Create node
		head = last = node;
		LENGTH++;
		printf("%d endered at in begining.", data);
	}
	else if (index>0 && index<=LENGTH+1) {
		node = createNode(data);  // Create node

		if (index == 1) {   				// If index is head
			head->prev = node;	// N-H
			node->next = head;	// N=H
			head = node;
		}
		else if (index == LENGTH+1) {		// If index is last
			last->next = node;	// L-N
			node->prev = last;	// L=N
			last = node;
		}
		else {      // Other position in list
			temp = head;
			for (int i=1; i<index-1; i++)   // Traverse to index-1 node
				temp = temp->next;
			// Making links
			node->next = temp->next;	//  T N-TN
			node->prev = temp;			//  T-N-TN
			temp->next->prev = node;	//  T-N=TN
			temp->next = node;			//  T=N=TN
		}

		LENGTH++;
		printf("%d endered at index %d.", data, index);
	}
	else {
		printf("Invalid Index.\n");
	}
}

// Delete Node
void delete(int index) {
	if (LENGTH == 0) {
		printf("Empty List.\n");
	}
	else {
		if (index>0 && index<=LENGTH) {

			if (LENGTH==index && index==1) {	// if length of list in 1
				node = head;
			}
			else if (index == 1) {   // If index is head
				node = head;		// H=N
				head = node->next;	// N=H
				head->prev = NULL;	// N-H
			}
			else if (index == LENGTH) {   // If index is Last
				node = last;		// N=L
				last = node->prev;	// L=N
				last->next = NULL;	// L-N
			}
			else {

				temp = head;
				for (int i=1; i<index; i++)   // Traverse to index node
					temp = temp->next;
				// Removing links
				node = temp;				
				temp->next->prev = temp->prev;
				temp->prev->next = temp->next;
			}							

			printf("%d is deleted from list.", node->data);
			free(node);
			LENGTH--;

		}
		else {
			printf("Invalid Index.\n");
		}
	}
}

// Display
void display(int reverse) {
	if (LENGTH == 0) {
		printf("Empty list.\n");
	}
	else {
		if (reverse == 0) {
			temp = head;
			while (temp != NULL) {
				printf("%-5d",temp->data);
				temp = temp->next;
			}
		}
		else {
			temp = last;
			while (temp != NULL) {
				printf("%-5d",temp->data);
				temp = temp->prev;
			}
		}
		printf("\n");
	}
}

// DRIVER CODE
int main()
{
	
	int switch_var;		// Switch Variable
	int exit = 0;		// Exit condition
	int t1, t2;			// Temporary variable

	while (!exit) {
		// Menu
		printf("\nEnter \n\t1. Insert \n\t2. Delete \n\t3. DISPLAY \n\t4. REVERSE \n\t5. EXIT \n-> ");
		scanf("%d", &switch_var);

		switch (switch_var) {
			// INSERT
			case 1:
				printf("Enter a value to insert : ");
				scanf("%d", &t1);
				printf("Enter  index(1-%d) : ", LENGTH+1);
				scanf("%d", &t2);
				insert(t2, t1);
				break;
			// DELETE
			case 2:
				printf("Enter index(1-%d) : ", LENGTH);
				scanf("%d", &t1);
				delete(t1);
				break;
			// DISPLAY
			case 3:
				display(0);
				break;
			// DISPLAY REVERSE
			case 4:
				display(1);
				break;
			// EXIT
			case 5:
				exit = 1;
				break;
			// INVALID
			default:
				printf("Enter a valid option.\n");
				break;
		}
	}
	
	return 0;
}

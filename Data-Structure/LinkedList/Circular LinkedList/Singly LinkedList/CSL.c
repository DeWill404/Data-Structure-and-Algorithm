#include <stdio.h>
#include <stdlib.h>

// Node data
typedef struct Linkedlist {
	int data;
	struct Linkedlist *next;
} Node;
Node *head, *temp, *node;
int LENGTH = 0;

// Create node function
Node *createNode(int data) {
	Node *temp = (Node *)malloc(sizeof(Node));
	temp->data = data;
	temp->next = temp;
	return temp;
}

// Insert Node
void insert(int index, int data) {
	if (LENGTH==0 && index==1) {  // If list is empty
		node = createNode(data);  // Create node
		head = node;
		LENGTH++;
		printf("%d entered at in begining.", data);
	}
	else if (index>0 && index<=LENGTH+1) {
		node = createNode(data);  // Create node
		temp = head;

		if (index == 1) {   // If index is head
			node->next = head;
			head = node;
			for (int i=1; i<LENGTH; i++)	// Traverse to last node
				temp = temp->next;
			temp->next = head;
		}
		else {      // Other position in list
			for (int i=1; i<index-1; i++)   // Traverse to index-1 node
				temp = temp->next;
			// Making links
			node->next = temp->next;
			temp->next = node;
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

			if (LENGTH==index && index==1) {	// If length of list is one
				node = head;
			}
			else if (index == 1) {					// if index is head
				temp = head;
				for (int i=1; i<LENGTH; i++)	// Traverse to last node
					temp = temp->next;
				node = temp->next;
				temp->next = node->next;
				head = node->next;
			}
			else {									// For other index

				temp = head;
				for (int i=1; i<index-1; i++)   // Traverse to index-1 node
					temp = temp->next;
				// Making links
				node = temp->next;
				temp->next = node->next;

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
void display() {
	if (LENGTH == 0) {
		printf("Empty list.\n");
	}
	else {
		temp = head;
		do {
			printf("%-5d",temp->data);
			temp = temp->next;
		} while (temp != head);
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
		printf("\nEnter \n\t1. Insert \n\t2. Delete \n\t3. DISPLAY \n\t4. EXIT \n-> ");
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
				display();
				break;
			// EXIT
			case 4:
				exit = 1;
				break;
			// INVALID
			default:
				printf("Enter a valid option\n");
				break;
		}
	}
	
	return 0;
}

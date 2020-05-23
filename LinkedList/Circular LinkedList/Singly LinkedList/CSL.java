import java.util.Scanner;

// Node class
class Node{
	private int data;
	private Node next;

	public Node(int data) {
		this.data = data;
		this.next = this;
	}

	// Getters
	public int getData() { return data; }
	public Node getNext() { return next; }

	// Setters
	public void setNext(Node nextNode) { this.next = nextNode; }
}


class CircularLinkedList {
	// List variables
	private int LENGTH = 0;
	private Node head, temp1, temp2;

	// Get length of list method
	public int getLength() {
		return LENGTH;
	}

	// Insert Node
	public void insert (int index, int data) {
		if (LENGTH==0 && index==1) {  // If list is empty
			Node newNode = new Node(data);  // Create temp2
			head = newNode;
			LENGTH++;
			System.out.println(data + " endered at in begining.");
		} else if (index>0 && index<=LENGTH+1) {
			Node newNode = new Node(data);  // Create temp2
			temp1 = head;
	
			if (index == 1) {   // If index is head
				newNode.setNext(head);
				head = newNode;
				for (int i=1; i<LENGTH; i++)	// Traverse to last node
					temp1 = temp1.getNext();
				temp1.setNext(head);
			} else {      		// Other position in list
				for (int i=1; i<index-1; i++)   // Traverse to index-1 node
					temp1 = temp1.getNext();
				// Making links
				newNode.setNext(temp1.getNext());
				temp1.setNext(newNode);
			}
	
			LENGTH++;
			System.out.println(data + " endered at " + index + ".");
		} else {
			System.out.println("Invalid Index");
		}
	}

	// Delete Node
	public void delete(int index) {
		if (LENGTH == 0) {
			System.out.println("Empty List.");
		} else {
			if (index>0 && index<=LENGTH) {

				if (LENGTH==index && index== 1) {		// If length is 1
					temp2 = head;
				} else if (index == 1) {				// if index is head
					temp1 = head;
					for (int i=1; i<LENGTH; i++)	// Traverse to last node
						temp1 = temp1.getNext();
					temp2 = temp1.getNext();
					temp1.setNext(temp2.getNext());
					head = temp2.getNext();
				} else {								// Other index in list
					temp1 = head;
					for (int i=1; i<index-1; i++)   // Traverse to index-1 node
						temp1 = temp1.getNext();
					// Removing links
					temp2 = temp1.getNext();
					temp1.setNext(temp2.getNext());
				}

				System.out.println(temp2.getData() + " is deleted from list.");
				LENGTH--;
			} else {
				System.out.println("Invalid Index.");
			}
		}
	}

	// Display
	public void display() {
		if (LENGTH == 0) {
			System.out.println("Empty list.");
		} else {
			temp1 = head;
			do {
				System.out.print(temp1.getData() + "\t");
				temp1 = temp1.getNext();
			} while (temp1 != head);
			System.out.println();
		}
	}

}

public class CSL {
	public static void main(String[] args) {
	
		// Object Initialization
		Scanner sc = new Scanner(System.in);
		CircularLinkedList csl = new CircularLinkedList();	

		int switch_var;		// Switch Variable
		int exit = 0;		// Exit condition
		int t1, t2;			// Temporary variable

		while (exit == 0) {
			// Menu
			System.out.print("\nEnter \n\t1. Insert \n\t2. Delete \n\t3. DISPLAY \n\t4. EXIT \n-> ");
			switch_var = sc.nextInt();

			switch (switch_var) {
				// INSERT
				case 1:
					System.out.print("Enter a value to insert : ");
					t1 = sc.nextInt();
					System.out.print("Enter  index(1-"+(csl.getLength()+1)+") : ");
					t2 = sc.nextInt();
					csl.insert(t2, t1);
					break;
				// DELETE
				case 2:
					System.out.print("Enter  index(1-"+csl.getLength()+") : ");
					t1 = sc.nextInt();
					csl.delete(t1);
					break;
				// DISPLAY
				case 3:
					csl.display();
					break;
				// EXIT
				case 4:
					exit = 1;
					break;
				// INVALID
				default:
					System.out.println("Enter a valid option.");
					break;
			}
		}
		sc.close();
	}
}
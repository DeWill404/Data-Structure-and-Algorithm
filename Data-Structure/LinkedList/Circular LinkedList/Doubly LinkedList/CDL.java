import java.util.Scanner;

// Node class
class Node{
	private int data;
	private Node next, prev;

	public Node(int data) {
		this.data = data;
		this.next = this;
		this.prev = this;
	}

	// Getters
	public int getData() { return data; }
	public Node getNext() { return next; }
	public Node getPrev() { return prev; }

	// Setters
	public void setNext(Node nextNode) { this.next = nextNode; }
	public void setPrev(Node nextNode) { this.prev = nextNode; }
}


class CircularDoublyLinkedlist {
	// List variables
	private int LENGTH = 0;
	private Node head, temp, node;

	// Get length of list method
	public int getLength() {
		return LENGTH;
	}

	// Insert Node
	public void insert (int index, int data) {
		if (LENGTH==0 && index==1) {  // If list is empty
			
			Node newNode = new Node(data);  // Create node
			head = newNode;
			LENGTH++;
			System.out.println(data + " endered at in begining.");

		} else if (index>0 && index<=LENGTH+1) {

			Node newNode = new Node(data);  // Create node
			if (index == 1) {   				// If index is head

				newNode.setNext(head);				//  L N-H
				newNode.setPrev(head.getPrev());	//  L-N-H
				head.getPrev().setNext(newNode);	//  L=N-H
				head.setPrev(newNode);				//  L=N=H
				head = newNode;

			} else {      						// Other position in list

				temp = head;
				for (int i=1; i<index-1; i++)   // Traverse to index-1 node
					temp = temp.getNext();
				// Making links
				newNode.setNext(temp.getNext());	//  T N-TN
				newNode.setPrev(temp);				//  T-N-TN
				temp.getNext().setPrev(newNode);	//  T-N=TN
				temp.setNext(newNode);				//  T=N=TN

			}
	
			LENGTH++;
			System.out.println(data + " entered at " + index + ".");
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
				if (LENGTH==index && index==1) {	// if length of list in 1
					node = head;
				} else if (index == 1) {   // If index is head

					node = head;
					head = node.getNext();
					node.getNext().setPrev(node.getPrev());
					node.getPrev().setNext(node.getNext());


				} else {

					temp = head;
					for (int i=1; i<index; i++)   // Traverse to index node
						temp = temp.getNext();
					// Removing links
					node = temp;
					temp.getNext().setPrev(temp.getPrev());
					temp.getPrev().setNext(temp.getNext());

				}

				System.out.println(node.getData() + " is deleted from list.");
				LENGTH--;
				node = null;
			} else {
				System.out.println("Invalid Index.");
			}
		}
	}

	// Display
	public void display(int reverse) {
		if (LENGTH == 0) {
			System.out.println("Empty list.");
		} else {

			if (reverse == 0) {

				temp = head;
				do {
					System.out.print(temp.getData() + "\t");
					temp = temp.getNext();
				} while (temp != head);

			} else {

				temp = head.getPrev();
				do {
					System.out.print(temp.getData() + "\t");
					temp = temp.getPrev();
				} while (temp != head.getPrev());

			}
			System.out.println();

		}
	}

}


public class CDL {
	public static void main(String[] args) {
	
		// Object Initialization
		Scanner sc = new Scanner(System.in);
		CircularDoublyLinkedlist cdl = new CircularDoublyLinkedlist();	

		int switch_var;		// Switch Variable
		int exit = 0;		// Exit condition
		int t1, t2;			// Temporary variable

		while (exit == 0) {
			// Menu
			System.out.print("\nEnter \n\t1. Insert \n\t2. Delete \n\t3. DISPLAY \n\t4. REVERSE \n\t5. EXIT \n-> ");
			switch_var = sc.nextInt();

			switch (switch_var) {
				// INSERT
				case 1:
					System.out.print("Enter a value to insert : ");
					t1 = sc.nextInt();
					System.out.print("Enter  index(1-"+(cdl.getLength()+1)+") : ");
					t2 = sc.nextInt();
					cdl.insert(t2, t1);
					break;
				// DELETE
				case 2:
					System.out.print("Enter  index(1-"+cdl.getLength()+") : ");
					t1 = sc.nextInt();
					cdl.delete(t1);
					break;
				// DISPLAY
				case 3:
					cdl.display(0);
					break;
				// DISPLAY REVERSE
				case 4:
					cdl.display(1);
					break;
				// EXIT
				case 5:
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
import java.util.Scanner;

// Node Class
class Node {
	// Node data
	private int data;
	private Node next;

	Node (int data) {
		this.data = data;
		this.next = null;
	}

	// Getters
	public int getData() {
		return data;
	}
	public Node getNext() {
		return next;
	}

	// Setter
	public void setNext(Node next) {
		this.next = next;
	}
}

class Stack {
	// Stack varaible
	private final int MAX = 5;
	private Node head, node;
	private int TOP = -1;

	// OVERFLOW check function
	public boolean OVERFLOW() {
		if (TOP == MAX-1) { return true; }
		else 		   	  { return false; }
	}

	// UNDERFLOW check function
	public boolean UNDERFLOW() {
		if (TOP == -1) { return true; }
		else 		   { return false; }
	}

	// PUSH into stack function
	public boolean push(int item) {
		if (!OVERFLOW()) {  // If not overflowed

			if (TOP == -1) {	// If stack is empty, set head
				head = new Node(item);
			}
			else {				// If stack is not empty, update head
				node = new Node(item);
				node.setNext(head);
				head = node;
			}

			++TOP;
			return true;
		}
		return false;
	}

	// POP from stack function
	public int pop() {
		if (!UNDERFLOW()) {  // If not underflowed

			int temp = head.getData();
			head = head.getNext();
			TOP--;
			return temp;

		}
		return -1;
	}

	// DISPLAY item from stack
	public void display() {
		if (!UNDERFLOW()) {  // If not underflowed
			node = head;
			while(node != null) {
				System.out.print(node.getData()+"     ");
				node = node.getNext();
			}
			System.out.println();
		}
		else {
			System.out.println("-> UNDERFLOW <-");
		}
	}
}

public class StackUsingLinkedlist {

	// DIRVER CODE
	public static void main(String[] args) {
		Stack stack = new Stack();

		Scanner sc = new Scanner(System.in);
		int switch_var;		    // Switch Variable
		boolean exit = false;	// Exit condition
		int temp;			    // Temporary variable

		while (!exit) {
			// Menu
			System.out.print("\nEnter \n\t1. PUSH \n\t2. POP \n\t3. DISPLAY \n\t4. EXIT \n-> ");
			switch_var = sc.nextInt();

			switch (switch_var) {
				// PUSH
				case 1:
					System.out.print("Enter a value to push : ");
					temp = sc.nextInt();
					if (stack.push(temp)) {  // If not oveflowed
						System.out.println(temp+" is pushed into stack.");
					} else {
						System.out.println("-> OVERFLOW <-");
					}
					break;
				// POP
				case 2:
					temp = stack.pop();
					if (temp == -1) {  // If underflowed
						System.out.println("-> UNDERFLOW <-");
					} else {
						System.out.println("The poped value is "+temp+".");
					}
					break;
				// DISPLAY
				case 3:
					stack.display();
					break;
				// EXIT
				case 4:
					exit = true;
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
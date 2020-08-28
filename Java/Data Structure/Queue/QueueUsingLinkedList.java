import java.util.Scanner;

// Node Class
class Node {
	// Node data
	private int data;
	private Node next;
	private Node prev;

	Node (int data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}

	// Getters
	public int getData() {
		return data;
	}
	public Node getNext() {
		return next;
	}
	public Node getPrev() {
		return prev;
	}

	// Setter
	public void setNext(Node next) {
		this.next = next;
	}
	public void setPrev(Node prev) {
		this.prev = prev;
	}
}

class Queue {
    // Queue Initialization
    private final int MAX = 5;
    private Node head, last, node;
    private int BACK=-1, FRONT=-1;

    // OVERFLOW CONDITION
    public boolean OVERFLOW() {
        if (BACK == MAX-1) {
            return true;
        } else {
            return false;
        }
    }

    // UNDERFLOW CONDITION
    public boolean UNDERFLOW() {
        if (BACK == -1) {
            return true;
        } else {
            return false;
        }
    }

    // insert into queue
    public boolean insert(int item) {
        if(!OVERFLOW()) {

            if (BACK==-1 || head==null) {		// If queue is empty, set head and last
                FRONT = BACK = 0;
                head = last = new Node(item);
            }
            else {								// If queue is not empty, update last
                ++BACK;
                node = new Node(item);
                node.setPrev(last);
                last.setNext(node);
                last = node;
            }

            return true;
        } else {
            return false;
        }
    }

    // delete from queue
    public int delete() {
        if (!UNDERFLOW()) {

            int temp = head.getData();
            head = head.getNext();
            if (FRONT == BACK)
                FRONT = BACK = -1;
            else
                FRONT++;
            return temp;

        } else {
            return -1;
        }
    }

    // Display item in queue
    public void display() {
        if(!UNDERFLOW()) {
            node = head;
            while(node != null) {
                System.out.print(node.getData()+"\t");
                node = node.getNext();
            }
            System.out.println();
        } else {
            System.out.println("-> UNDERFLOW <-");
        }
    }
}

public class QueueUsingLinkedList {
    // DIRVER CODE
    public static void main(String[] args) {
        Queue queue = new Queue();

        Scanner sc = new Scanner(System.in);
        int switch_var;		    // Switch Variable
        boolean exit = false;	// Exit condition
        int temp;			    // Temporary variable
    
        while (!exit) {
            // Menu
            System.out.print("\nEnter \n\t1. INSERT \n\t2. DELETE \n\t3. DISPLAY \n\t4. EXIT \n-> ");
            switch_var = sc.nextInt();
    
            switch (switch_var) {
                // insert
                case 1:
                    System.out.print("Enter a value to insert : ");
                    temp = sc.nextInt();
                    if (queue.insert(temp)) {  // If not oveflowed
                        System.out.println(temp+" is inserted into queue.");
                    } else {
                        System.out.println("-> OVERFLOW <-");
                    }
                    break;
                // delete
                case 2:
                    temp = queue.delete();
                    if (temp == -1) {  // If underflowed
                        System.out.println("-> UNDERFLOW <-");
                    } else {
                        System.out.println("The deleted value is "+temp+".");
                    }
                    break;
                // DISPLAY
                case 3:
                    queue.display();
                    break;
                // EXIT
                case 4:
                    exit = true;
                    break;
                // INVALID
                default:
                    System.out.println("Enter a valid option");
                    break;
            }
        }
        sc.close();
    }
}
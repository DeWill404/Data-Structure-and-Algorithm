import java.util.Scanner;

class Queue {
    // Queue Initialization
    private final int MAX = 5;
    private int[] queue = new int[MAX];
    private int BACK=-1, FRONT=-1;

    // OVERFLOW CONDITION
    public boolean OVERFLOW(int ForB) {
        if (ForB == 1) {
            if (BACK == MAX-1) {
                return true;
            } else {
                return false;
            }
        } else {
            if (FRONT <= 0) {
                return true;
            } else {
                return false;
            }
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

    // insert into queue BACK
    public boolean insert_front(int item) {
        if(!OVERFLOW(1)) {
            if (BACK == -1)
                FRONT = 0;
            queue[++BACK] = item;
            return true;
        } else {
            return false;
        }
    }

    // insert into queue FRONT
    public boolean insert_back(int item) {
        if(!OVERFLOW(2)) {
            queue[--FRONT] = item;
            return true;
        } else {
            return false;
        }
    }

    // delete
    public int delete() {
        if (!UNDERFLOW()) {
            int temp = queue[FRONT];
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
            for (int i=FRONT; i<=BACK; i++) {
                System.out.print(queue[i]+"\t");
            }
            System.out.println();
        } else {
            System.out.println("-> UNDERFLOW <-");
        }
    }
}

public class DoubleEndedInsertionQueue {
    // DIRVER CODE
    public static void main(String[] args) {
        Queue queue = new Queue();

        Scanner sc = new Scanner(System.in);
        int switch_var;		    // Switch Variable
        boolean exit = false;	// Exit condition
        int temp;			    // Temporary variable
    
        while (!exit) {
            // Menu
            System.out.print("\nEnter \n\t1. INSERT BACK\n\t2. INSERT FRONT \n\t3. DELETE \n\t4. DISPLAY \n\t5. EXIT \n-> ");
            switch_var = sc.nextInt();
    
            switch (switch_var) {
                // insert front
                case 1:
                    System.out.print("Enter a value to insert : ");
                    temp = sc.nextInt();
                    if (queue.insert_front(temp)) {  // If not oveflowed
                        System.out.println(temp+" is inserted from front into queue.");
                    } else {
                        System.out.println("-> OVERFLOW <-");
                    }
                    break;
                // insert back
                case 2:
                    System.out.print("Enter a value to insert : ");
                    temp = sc.nextInt();
                    if (queue.insert_back(temp)) {  // If not oveflowed
                        System.out.println(temp+" is inserted from back into queue.");
                    } else {
                        System.out.println("-> OVERFLOW <-");
                    }
                    break;
                // delete
                case 3:
                    temp = queue.delete();
                    if (temp == -1) {  // If underflowed
                        System.out.println("-> UNDERFLOW <-");
                    } else {
                        System.out.println("The deleted value is "+temp+".");
                    }
                    break;
                // DISPLAY
                case 4:
                    queue.display();
                    break;
                // EXIT
                case 5:
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
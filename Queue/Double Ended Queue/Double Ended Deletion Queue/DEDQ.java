import java.util.Scanner;

class DoubleEndedDeletionQueue {
    // Queue Initialization
    private final int MAX = 5;
    private int[] queue = new int[MAX];
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
        if (BACK==-1) {
            return true;
        } else {
            return false;
        }
    }

    // insert into queue
    public boolean insert(int item) {
        if(!OVERFLOW()) {
            if (BACK == -1)
                FRONT = 0;
            queue[++BACK] = item;
            return true;
        } else {
            return false;
        }
    }

    // delete from queue BACK
    public int delete_back() {
        if (!UNDERFLOW()) {
            int temp = queue[FRONT];
            if (FRONT == BACK)
                FRONT = BACK = -1;
            else
                BACK--;
            return temp;
        } else {
            return -1;
        }
    }

    // delete from queue FRONT
    public int delete_front() {
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

public class DEDQ {
    // DIRVER CODE
    public static void main(String[] args) {
        DoubleEndedDeletionQueue queue = new DoubleEndedDeletionQueue();

        Scanner sc = new Scanner(System.in);
        int switch_var;		    // Switch Variable
        boolean exit = false;	// Exit condition
        int temp;			    // Temporary variable
    
        while (!exit) {
            // Menu
            System.out.print("\nEnter \n\t1. INSERT \n\t2. DELETE BACK \n\t3. DELETE FRONT \n\t4. DISPLAY \n\t5. EXIT \n-> ");
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
                // delete BACK
                case 2:
                    temp = queue.delete_back();
                    if (temp == -1) {  // If underflowed
                        System.out.println("-> UNDERFLOW <-");                        
                    } else {
                        System.out.println("The deleted value is "+temp+".");
                    }
                    break;
                // delete FRONT
                case 3:
                    temp = queue.delete_front();
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
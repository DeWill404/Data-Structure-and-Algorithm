class Createnode:
    def __init__(self, data):
        self.data = data
        self.next = self


class CircularSinglyLinkedList:
    # Initializing head
    def __init__(self):
        self.head = None
        self.length = 0

    # Inserting new node
    def insert(self, index , data):
        # If list is empty
        if self.length==0 and index==1:
            self.head = Createnode(data)
            self.length += 1
            print(f"{data} is inserted at begining of list.")
        # if list is not empty
        else:
            # For valid index
            if index>0 and index<=self.length+1:

                newNode = Createnode(data)  # Create node
                temp = self.head
                
                if index == 1:      # For inserting at position 1
                    newNode.next = self.head
                    self.head = newNode
                    for i in range(1, self.length):	# Traverse to last node
                        temp = temp.next
                    temp.next = self.head
                else:               # For remaining position
                    for i in range(1, index-1):    # Traversing to index-1 node
                        temp = temp.next
                    newNode.next = temp.next
                    temp.next = newNode
                
                self.length += 1
                print(f"{data} is inserted at index {index}.")
                
            else:
                print("Invalid Index.")

    # Delete node
    def delete(self, index):
        if self.length == 0:    # if list is empty
            print("Empty list.")
        else:
            if index>0 and index<=self.length:

                if self.length==1 and index==1:	    # If length of list is one
                    temp = self.head
                elif index == 1:                    # For deleting at position 1
                    temp1 = self.head
                    for i in range(1, self.length):	    # Traverse to last node
                        temp1 = temp1.next
                    temp = temp1.next
                    temp1.next = temp.next
                    self.head = temp.next
                else:                               # For remaining position
                    temp1 = self.head
                    for i in range(1, index-1):         # Traversing to index-1 node
                        temp1 = temp1.next
                    temp = temp1.next
                    temp1.next = temp.next

                self.length -= 1
                print(f"{temp.data} is deleted from list.")
                
            else:
                print("Invalid Index.")

    # Traverse through list
    def display(self):
        if self.length == 0:    # if list is empty
            print("Empty list.")
        else:
            temp = self.head
            for i in range(1, self.length+1):
                print(temp.data, end="   ")
                temp = temp.next



menu = '''
Enter
    1. Insert
    2. Delete
    3. Display
    4. Exit
-> '''
if __name__ == "__main__":
    obj = CircularSinglyLinkedList()
    exit = False
    while not exit:
        switch_var = int(input(menu))
        # INSERT
        if switch_var == 1:
            temp = int(input("Enter the number : "))
            index = int(input(f"Enter the index(1-{obj.length+1}) : "))
            obj.insert(index, temp)
        # DELETE
        elif switch_var == 2:
            index = int(input(f"Enter the index(1-{obj.length}) : "))
            obj.delete(index)
        # DISPLAY
        elif switch_var == 3:
            obj.display()
        # EXIT
        elif switch_var == 4:
            exit = True
        # INVALID
        else:
            print("Please enter a valid statement.")
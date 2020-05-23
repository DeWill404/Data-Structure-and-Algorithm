# Node class
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
        self.prev = None


class Queue():
    # Queue Initialization
    def __init__(self):
        self.MAX = 5
        self.head = None
        self.last = None
        self.length = 0

    # OVERFLOW CONDITION
    def OVERFLOW(self):
        if self.length == self.MAX:
            return True
        else:
            return False

    # UNDERFLOW CONDITION
    def UNDERFLOW(self):
        if self.length == 0:
            return True
        else:
            return False
    
    # Insert into queue
    def insert(self, item):
        if not self.OVERFLOW():

            if self.length == 0:		        # If queue is empty, set head and last
                self.head = self.last = Node(item)
            else:								# If queue is not empty, update last
                temp = Node(item)
                Node.prev = self.last
                self.last.next = temp
                self.last = temp

            self.length += 1
            return True
        else:
            return False
    
    # Delete from queue
    def delete(self):
        if not self.UNDERFLOW():

            temp = self.head.data
            self.head = self.head.next
            self.length -= 1
            return temp

        else:
            return False
    
    def display(self):
        if not self.UNDERFLOW():
            temp = self.head
            while temp != None:
                print(temp.data, end="   ")
                temp = temp.next
        else:
            print("-> UNDERFLOW <-")

menu = '''
Enter
        1. INSERT
        2. DELETE
        3. DISPAY
        4. EXIT
-> '''

if __name__ == "__main__":
    obj = Queue()
    exit = False
    while not exit:
        switch_var = int(input(menu))
        # INSERT
        if switch_var == 1:
            temp = int(input("Enter a value to insert : "))
            if obj.insert(temp):
                print(f"{temp} is inserted into queue.")
            else:
                print("-> OVERFLOW <-")
        # DELETE
        elif switch_var == 2:
            temp = obj.delete()
            if temp:
                print(f"The deleted value is {temp}.")
            else:
                print("-> UNDERFLOW <-")
        # DISPLAY
        elif switch_var == 3:
            obj.display()
        # EXIT
        elif switch_var == 4:
            exit = True
        # INVALID
        else:
            print("Enter a valid option.")

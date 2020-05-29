# Node class
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


class Stack:
    # Stack varaible Initialization
    def __init__(self):
        self.head = None
        self.MAX = 5
        self.TOP = -1
    
    # OVERFLOW check function
    def UNDERFLOW(self):
        if self.TOP == -1:
            return True
        else:
            return False
    
    # UNDERFLOW check function
    def OVERFLOW(self):
        if self.TOP == self.MAX-1:  # If not overflowed
            return True
        else:
            return False

    # PUSH into stack function
    def push(self, item):
        if not self.OVERFLOW():     # If not underflowed
            
            if self.TOP == -1:	# If stack is empty, set head
                self.head = Node(item)
            else:				# If stack is not empty, update head
                temp = Node(item)
                temp.next = self.head
                self.head = temp
            self.TOP += 1
            
            return True
        else:
            return False

    # POP from stack function
    def pop(self):
        if not self.UNDERFLOW():     # If not underflowed

            temp = self.head.data
            self.head = self.head.next
            self.TOP -= 1
            return temp
        else:
            return False

    # DISPLAY item from stack
    def display(self):
        if not self.UNDERFLOW():
            temp = self.head
            while temp != None:
                print(temp.data, end="     ")
                temp = temp.next
        else:
            print("-> UNDERFLOW <-")

menu = '''
Enter
        1. PUSH
        2. POP
        3. DISPAY
        4. EXIT
-> '''

if __name__ == "__main__":
    obj = Stack()
    exit = False
    while not exit:
        switch_var = int(input(menu))
        # PUSH
        if switch_var == 1:
            temp = int(input("Enter a value to push : "))
            if obj.push(temp):
                print(f"{temp} is pushed into stack.")
            else:
                print("-> OVERFLOW <-")
        # POP
        elif switch_var == 2:
            temp = obj.pop()
            if temp:
                print(f"The poped value is {temp}.")
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

class Queue():
    # Queue Initialization
    def __init__(self):
        self.MAX = 5
        self.queue = []

    # OVERFLOW CONDITION
    def OVERFLOW(self):
        if len(self.queue) == self.MAX:
            return True
        else:
            return False

    # UNDERFLOW CONDITION
    def UNDERFLOW(self):
        if len(self.queue) == 0:
            return True
        else:
            return False
    
    # Insert into queue
    def insert(self, item):
        if not self.OVERFLOW():
            self.queue.append(item)
            return True
        else:
            return False
    
    # Delete from queue FRONT
    def delete_front(self):
        if not self.UNDERFLOW():
            return self.queue.pop(0)
        else:
            return False

    # Delete from queue BACK
    def delete_back(self):
        if not self.UNDERFLOW():
            return self.queue.pop()
        else:
            return False
    
    def display(self):
        if not self.UNDERFLOW():
            print("   ".join([str(i) for i in self.queue]))
        else:
            print("-> UNDERFLOW <-")

menu = '''
Enter
    1. INSERT
    2. DELETE FRONT
    3. DELETE BACK
    4. DISPAY
    5. EXIT
-> '''

if __name__ == "__main__":
    obj = Queue()
    exit = False
    while not exit:
        switch_var = int(input(menu))
        # INSERT
        if switch_var == 1:
            temp = int(input("Enter the number : "))
            if obj.insert(temp):
                print(f"{temp} is inserted into queue.")
            else:
                print("-> OVERFLOW <-")
        # DELETE BACK
        elif switch_var == 2:
            temp = obj.delete_front()
            if temp:
                print(f"{temp} is deleted from queue.")
            else:
                print("-> UNDERFLOW <-")
        # DELETE BACK
        elif switch_var == 3:
            temp = obj.delete_back()
            if temp:
                print(f"{temp} is deleted from queue.")
            else:
                print("-> UNDERFLOW <-")
        # DISPLAY
        elif switch_var == 4:
            obj.display()
        # EXIT
        elif switch_var == 5:
            exit = True
        # INVALID
        else:
            print("Please enter a valid statement.")

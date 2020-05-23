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
    
    # Insert into queue FRONT
    def insert_front(self, item):
        if not self.OVERFLOW():
            self.queue.insert(0, item)
            return True
        else:
            return False

    # Insert into queue BACK
    def insert_back(self, item):
        if not self.OVERFLOW():
            self.queue.append(item)
            return True
        else:
            return False
    
    # Delete from queue FRONT
    def delete(self):
        if not self.UNDERFLOW():
            return self.queue.pop(0)
        else:
            return False
    
    def display(self):
        if not self.UNDERFLOW():
            print("   ".join([str(i) for i in self.queue]))
        else:
            print("-> UNDERFLOW <-")

menu = '''
Enter
    1. INSERT FRONT
    2. INSERT BACK
    3. DELETE
    4. DISPAY
    5. EXIT
-> '''

if __name__ == "__main__":
    obj = Queue()
    exit = False
    while not exit:
        switch_var = int(input(menu))
        # INSERT FRONT
        if switch_var == 1:
            temp = int(input("Enter the number : "))
            if obj.insert_front(temp):
                print(f"{temp} is inserted into queue from front.")
            else:
                print("-> OVERFLOW <-")
        # INSERT BACK
        elif switch_var == 2:
            temp = int(input("Enter the number : "))
            if obj.insert_back(temp):
                print(f"{temp} is inserted into queue fron back.")
            else:
                print("-> OVERFLOW <-")
        # DELETE 
        elif switch_var == 3:
            temp = obj.delete()
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

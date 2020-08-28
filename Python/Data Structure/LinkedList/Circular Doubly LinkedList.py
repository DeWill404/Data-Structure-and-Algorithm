class Createnode:
	def __init__(self, data):
		self.data = data
		self.next = self
		self.prev = self


class CircularDoublyLinkedList:
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

				if index == 1:                  # For inserting at position 1
					newNode.next = self.head		#  L N-H
					newNode.prev = self.head.prev	#  L-N-H
					self.head.prev.next = newNode	#  L=N-H
					self.head.prev = newNode		#  L=N=H
					self.head = newNode
				else:                           # For remaining position
					temp = self.head
					for i in range(1, index+1):    # Traversing to index-1 node
						temp = temp.next
					# Making links
					newNode.next = temp.next	#  T N-TN
					newNode.prev = temp			#  T-N-TN
					temp.next.prev = newNode	#  T-N=TN
					temp.next = newNode			#  T=N=TN

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

				if self.length == index == 1:	# if length of list in 1
					temp = self.head
				elif index == 1:      			# For deleting at position 1
					temp = self.head
					self.head = temp.next
					temp.next.prev = temp.prev
					temp.prev.next = temp.next
				else:               			# For remaining position
					temp1 = self.head
					for i in range(1, index):    # Traversing to index node
						temp1 = temp1.next
					# Removing links
					temp = temp1
					temp1.next.prev = temp.prev
					temp1.prev.next = temp.next
				
				self.length -= 1
				print(f"{temp.data} is deleted from list.")
				temp = None
				
			else:
				print("Invalid Index.")

	# Traverse through list
	def display(self, reverse):
		if self.length == 0:    # if list is empty
			print("Empty list.")
		else:
			if reverse == 0:
				temp = self.head
				for i in range(1, self.length+1):
					print(temp.data, end="   ")
					temp = temp.next
			else:
				temp = self.head.prev
				for i in range(1, self.length+1):
					print(temp.data, end="   ")
					temp = temp.prev


menu = '''
Enter
	1. Insert
	2. Delete
	3. Display
	4. Reverse
	5. Exit
-> '''
if __name__ == "__main__":
	obj = CircularDoublyLinkedList()
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
			obj.display(0)
		# REVERSE
		elif switch_var == 4:
			obj.display(1)
		# EXIT
		elif switch_var == 5:
			exit = True
		# INVALID
		else:
			print("Please enter a valid statement.")
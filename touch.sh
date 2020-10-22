name="$1"		# Get path of folder to create
control="$2"	# Get control whether to create file/folder

# Commands to create folder
if [ $control == "1" ]; then
	mkdir "C/$name"
	mkdir "Java/$name"
	mkdir "Python/$name"
# Commands to create files
elif [ $control == "2" ]; then
	touch "C/$name.c"
	touch "Java/$name.java"
	touch "Python/$name.py"
# If invalid argument is passed
else
	echo "Invalid redirection"
fi
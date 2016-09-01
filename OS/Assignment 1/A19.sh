# Print sorted list of users

getent passwd | sort | cut -d: -f1

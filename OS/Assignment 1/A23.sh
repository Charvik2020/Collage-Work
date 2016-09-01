#Count how many times user logged in

echo "Enter your username : \c"
read user

last | grep '$user' | wc -l

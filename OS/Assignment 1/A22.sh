echo "Enter Username -> "
read user
getent passwd $user #fetch detail from passwd file

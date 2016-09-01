echo "Enter username ->"
read user
if [ `getent passwd $user | wc -l` -gt 0 ] #details of username with password:groupid:userid and other details
then
echo "$user is online"
else
echo "$user is offline"
fi

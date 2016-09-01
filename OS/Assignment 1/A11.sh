t=12 #inital with 12
h=`date |cut -d ' ' -f 4-4 |cut -d ':' -f 1-1` #fetching hour from date (24 hour format)
if [ $h -ge $t ]
then
	echo "Good Afternoon!"
	z=`expr $h - $t` #seting hour in 12hour format
	echo "Time: $z:`date |cut -d ' ' -f 4-4 |cut -d ':' -f 2-3` PM"
else
	echo "Good Morning!" #seting hour in 12hour format
	echo "Time: $h:`date |cut -d ' ' -f 4-4 |cut -d ':' -f 2-3` AM"
fi


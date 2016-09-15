while [ 1 ]
do
echo 'Enter Path Of Directory in which you want to find file->'
read path

echo 'Choose Any one.
1. Find Biggest File in following Directory
2. Find Smallest File in following Directory
3. Exit'
read choose

case $choose in
	
	[1])	echo 'The biggest file is : \c'
	    	find $path -type f | ls -la | awk '{print $5 "\t" $9}' | sort -n | awk 'END {print $2 "-->" $1 " Bytes"}'
	    	sleep 5
	    	continue;;
	
	[2])	echo 'The smallest file is : \c'
	    	find $path -type f | ls -la | awk '{print $5 "\t" $9}' | sort -n | awk 'NR==2{print $2 "-->" $1 " Bytes"}'
	    	sleep 5
	    	continue;;
	    	
	[3])	exit;;
	
	*) echo '\nPlease enter proper choice'
esac
done
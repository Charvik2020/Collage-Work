printf 'Menu \n'

printf 'A) Copy file(s) \n'
	
printf 'B) Delete file(s) \n'

printf 'C) Rename file(s) \n'


echo 'Enter your Choice ->'
read choice

case $choice in
	[aA])   echo 'Enter filename from which to copy ->'
		read Filename
		echo 'Enter filename to copy ->'
		read  Des_Filename
		cp -i $Filename $Des_Filename #copy,interactive,source
		sleep 5
		echo 'Copy Completed!'
  	        continue;;

	[bB])   echo 'Enter Filename ->'
		read Filename
		rm -i $Filename #remove,interactive,source
		echo 'File Deleted!'
		sleep 5
	   	continue;;

	[cC])   echo 'Enter Filename ->'
		read Filename
		echo 'Enter Filename to Rename ->'
		read newFilename
		mv -i $Filename $newFilename #rename,interactive,source
 		sleep 5
		echo 'Renamed!'
	        continue;;


esac


cat << MENU

Menu

A) Count of words , charactor and line
	
B) File in reversed Order

C) Frequency of particular word in file

D) Lower case letters in place of upper case alphabates 

MENU

echo 'Enter File Name :'
read file

echo 'Enter your Choice :'
read choice

case $choice in
	[aA])	echo "Lines:`wc -l $file | cut -d ' ' -f 1`"
			echo "Words:` wc -w $file | cut -d ' ' -f 1`"
			echo "Characters:` wc -m $file | cut -d ' ' -f 1`"
  	          continue;;

	[bB])	tac $file   
			continue;;

	[cC])	echo 'Enter Word :'
			read word
			grep -io "$word" $file | wc -l
			continue;;

	[dD])	tr '[A-Z]' '[a-z]' <$file
               continue;;


esac


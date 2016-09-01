#count the number of files in directory

ls -p $path | grep -v / | wc -l

echo "Enter first Directory Name ->"
read dir1 #read directory 

echo "Enter second Directory Name ->"
read dir2 #read directory

echo "Enter Destination Directory Name ->"
read dir #read directory

rsync -avz -u $dir1/* $dir #archive,verbose,compression source
rsync -avz -u $dir2/* $dir



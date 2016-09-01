echo "Enter Directory Name ->"
read dir
du --max-depth=1 $dir/* | sort -nr #estimated file size=1 in given directory,numerical and reverse sort


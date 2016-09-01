for file in *
do
if [ ! -s $file ]; then #zero size file to be deleted 
echo 'deleting file '$file
rm -i $file
echo 'Deleted file'$file
fi
done


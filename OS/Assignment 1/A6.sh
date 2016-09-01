set ` ls -l `l
ls -l |cut -d ' ' -f 5-9 >>file.txt # cut 5 to 9 columns copy content into file


shift 2 # removing unwanted data
while [ $1 ]
do

   echo  $9 \ $5 \ $6  $7 \ $3 \ $4 #printing required columns
   shift 9 # shifting for get next file details 
done
wc -l file.txt # for counting

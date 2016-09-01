echo 'Enter Directory Path :'
read Path
echo 'From Date :'
read from
echo 'To Date:'
read to
find $Path -type f -newermt $from ! -newermt $to



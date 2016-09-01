echo "Enter Path"
read path
cd $path
ls -la | cut -c 8,9,47- | grep rw # cut 8,9 char and 47 onwards and grep will serch for rw


echo 'Enter File ->'
read File
find "$(cd ..; pwd)" -name $File

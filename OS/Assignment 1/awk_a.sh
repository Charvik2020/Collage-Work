w | awk '{print $1,$4}' | awk 'FNR>=3' | sort -k 2 #login detail,print column 1 & 4,print from 3 line, sort with key column 2

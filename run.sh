#!/bin/sh

# The "sorts" variable contains a list of sort-array pairs that are passed
# to TestHarness
# First char: sort type
# - i = insertion sort
# - b  = bubble sort
# - s = selection sort
# - q = quicksort
# - j = Java's quicksort
# - m = mergesort
#
# Second char: initial order of array
# - a = ascending order
# - d = descending order
# - r = randomly ordered (actually: randomly swapped around)
# - n = ascending with 10% randomly swapped (ie: nearly sorted)

if [ -z $1 ]; then
    max=4096
else
    max=$1
fi

runEm()
{
    for i in `awk 'BEGIN{for(i=1;i<='"$max"';i*=2)print i;exit}'`
    do
        java SortsTestHarness $i $sorts
    done
}


for sorts in br ir mr qr bn in mn qn ba ia ma qa bd id md qd; do
    tempFile="${sorts}.dat"
    runEm > $tempFile
done

for a in r n a d; do
gnuplot <<EOF
    set term png 
    set output "b${a}.png" 
    plot"b${a}.dat" using 2:3 t "b${a}" w l, \
        "i${a}.dat" using 2:3 t "i${a}" w l, \
        "m${a}.dat" using 2:3 t "m${a}" w l, \
        "q${a}.dat" using 2:3 t "q${a}" w l
EOF
done

rm *.dat

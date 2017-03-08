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


for sorts in br ir sr mr qr bn in sn mn qn ba ia sa ma qa bd id sd md qd; do
    echo sorting ${sorts}..
    tempFile="${sorts}.dat"
    runEm > $tempFile
done

for a in r n a d; do
gnuplot <<EOF
    set term png
    set output "${a}.png"
    plot"b${a}.dat" using 2:3 t "b${a}" w l, \
        "i${a}.dat" using 2:3 t "i${a}" w l, \
        "s${a}.dat" using 2:3 t "s${a}" w l, \
        "m${a}.dat" using 2:3 t "m${a}" w l, \
        "q${a}.dat" using 2:3 t "q${a}" w l
EOF
echo $a array png created
done

rm *.dat

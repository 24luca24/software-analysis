#!/bin/sh

#generate verifier
spin -a model.pml

#compile verifier
gcc -Wno-format-overflow -o analyzer pan.c 

#run each property
./analyzer -a -N p1
./analyzer -a -N p2
./analyzer -a -N p3
./analyzer -a -N p4
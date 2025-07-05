#!/bin/sh

# Generate verifier
spin -a model.pml

# Recompile with increased NFAIR to support more processes under fairness
gcc -DNFAIR=6 -o analyzer pan.c

# Run each LTL property with weak fairness and increased depth
for prop in p1 p2 p3 p4
do
  echo "Running verification for LTL property $prop..."
  ./analyzer -a -f -m2000000 -N "$prop"
done

#!/bin/bash

# Clean previous Infer output
rm -rf infer-out

# Run Infer in Eradicate mode on the whole Maven project
infer --eradicate --keep-going --jobs 1 -- mvn clean compile

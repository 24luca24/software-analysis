# Software Analysis

As a student of the Software Analysis course, I would like to share what we have done and what technologies we have used in this course.  

In this course, we will complete three assignments, each focusing on different software analysis techniques.

## Assignment 1: Algorithm Analysis with Dafny

Dafny is a formal static verification tool that allows you to write and verify programs with mathematical guarantees. It supports specifications such as preconditions, postconditions, and loop invariants.  

The goal of this assignment was to gain hands-on experience with Dafny by analyzing algorithms such as Selection Sort, Insertion Sort, Quicksort, and Mergesort. The algorithms I chose are:

- **Selection Sort** (verifying sorted and permuted element properties)  
- **Quicksort** (verifying only the permuted property)  

### Running Dafny

After installing Dafny and its extension in VSCode, you can compile and verify an algorithm using the following command:

```sh
dafny build algorithmName.dfy



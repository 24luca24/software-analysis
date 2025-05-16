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
```
 
## Assignment 2: Project Analysis with Infer

Infer is a static analysis tool developed by Facebook that automatically detects bugs in code before it runs. It can find issues such as null pointer exceptions, resource leaks, and concurrency errors, helping improve software quality by identifying potential problems early.

In the `infer` folder, you will find two subfolders: **before** and **after**. The **before** folder contains the original project code, while the **after** folder contains the same project but improved by fixing the issues that Infer identified. This demonstrates how static analysis can guide bug fixing and enhance code reliability.

To see more about how I execute the project, and what the project is about, go in the folder and you will found a report explain everything I did.


## Assignment 3: Model checking with Spin

Spin is a widely used open-source software model checker designed for verifying the correctness of distributed software models. It uses the Promela (Process Meta Language) modeling language to describe system behaviors and allows formal verification of properties such as safety and liveness expressed in Linear Temporal Logic (LTL).
The goal of this assignment was to build a Promela model simulating multiple worker threads completing tasks either in ordered or random sequences. Then, I defined and verified several LTL properties using Spin to check correctness, including eventual completion of all tasks and consistency conditions. Counterexamples produced by Spin helped analyze potential violations and improve understanding of concurrent behaviors.

After installing Promela extention on VSCode, you can run the script.sh, inside the Spin folder, which contain instruction used to run the program and verify the properties.
```sh
./script.sh
```


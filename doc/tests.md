
# Testing correctness

This document provides some details about how the tests to check the correctness of the compiler are organized and how to execute them.

The tests are taken from the following sources:

 *   https://wiki.eclipse.org/ATL_VM_Testing 
 
 Project **examples.vmtesting** contains a copy of the tests provided by the [ATL VM Testing](https://wiki.eclipse.org/ATL_VM_Testing )  page. We have tried not to change the tested transformations unless it contains typing errors which must be fixed for the A2L compiler to work. In such cases, the modification is annotated with a comment starting with @a2l_change.
 
## How to compile the tests

 
## Evaluation code

Project lintra.evaluation contains facilities to run evaluations and experiments for A2L transformations. 

In particular it implements a simple UI to compile test cases in batch mode and then execute the corresponding test suites. 
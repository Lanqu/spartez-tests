Iteration
===========

Refactor recursion into loop, because recursion can cause StackOverflowError

Given:
 - Interface Folder.java - your solution must implement it
 - OldFolder.java - refactor this class into MyFolder.java


Flatten
===========

Represent tree in flat order from left to right.

>     |
>   / | \
>  1  |  2
>   / | \
>  3  4  5

Should produce output: 1, 3, 4, 5, 2

Given:
 - Either.java
 - FlattenTree.java
 - Function.java
 - Tree.java
 - Triple.java

 Implement MyFlattenTree.java that implements interface FlattenTree.java


Find array
============

Find sub array starting index in array.

> [1, 4, 5, 7, 9]
> [5,7]

Output: 2

Given:
 - FindArray.java

You must implement FindArray.java interface


Find Common Ancestor
=====================

You have a git-like structure of branches. It is described by 2 arrays.
First array describe commits in sorted order by date.
Second array describe each first array's element parent commit.
Find first common ancestor of 2 given commits.
If one commit is ancestor of the other, then return it.
It is possible to implement O(n) solution.

Example:

>           E - F
>         /      \
>    A - B - D - G

Commits: {"G", "F", "E", "D", "B", "A"}
Parents: {{"F","D"}, {"E"}, {"B"}, {"B"}, {"A"}, null}
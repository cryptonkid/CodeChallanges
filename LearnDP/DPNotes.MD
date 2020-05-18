What is Dynamic Programming and How to Solve the questions ?
DP is an special approach of Divide and Conquer. 
In Divide and Conquer you solve the problem by combining the **disjoint** __subproblems__. ( disjoint = having no element in common )
One solve every subproblem using recursion and combines all the solution into to the final solution. 

In DP  every subproblem contains subsubproblems which are common between other subproblems.
So when one is solving the problem one uses various storage mechanisum to solve the **subsubproblems** once and retrive there solution once solved.
Simplest Approach for Any DP problem is :
1) Write a Recursive Solution to the problem. 
2) Store the subsubproblem in an optimal way.
3) Combine all the subproblem to get the optimal answer. 

Some of the famous base problems of DP are 
1) 01Knapsack / RodCutting Problem.
3) Matrix Chain Multiplication 
3) LongestCommanSubsequence.
4) Optimal BinarySearchTree.

To be good at DP writing recursive solution is important.
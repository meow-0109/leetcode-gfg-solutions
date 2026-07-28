
Lets start understanding what is a greedy algorithm?
Its like we need to choose a set of books such that we dont know the complexity we dont know anything but the only thing we can do is to choose book that gives most obvious and provide immediate benefit after this book again choose which gives immediate benefit
Greedy algorithms are used for optimiztion of problems 
We can use greedy if problem fulfils following requirement
At every step, we can make a choice that looks best at the moment, and we get the optimal solution to the complete problem. 
However, it's important to note that not all problems are suitable for greedy algorithms. They work best when the problem exhibits the following properties:

Greedy Choice Property: The optimal solution can be constructed by making the best local choice at each step.
Optimal Substructure: The optimal solution to the problem contains the optimal solutions to its sub-problems.
Here's how it works:
```
Start with the initial state of the problem.
Consider all the options available at that specific moment.
Choose the option that seems best at that moment, regardless of future consequences. This is the "greedy" part - you take the best option available now, even if it might not be the best in the long run.
Move to the new state based on your chosen option. This becomes your new starting point for the next iteration.
Repeat steps 2-4 until you reach the goal state or no further progress is possible.
```
Example:
Let's say you have a set of coins with values [1, 2, 5, 10] and you need to give minimum number of coin to someone change for 39.

The greedy algorithm for making change would work as follows:

Step-1: Start with the largest coin value that is less than or equal to the amount to be changed. In this case, the largest coin less than or equal to 39 is 10.
Step- 2: Subtract the largest coin value from the amount to be changed, and add the coin to the solution. In this case, subtracting 10 from 39 gives 29, and we add one 10-coin to the solution.
Repeat steps 1 and 2 until the amount to be changed becomes 0.
```java
// Java Program to find the minimum number of coins
// to construct a given amount using greedy approach

import java.util.Arrays;

class GfG {
    static int minCoins(int[] coins, int amount) {
        int n = coins.length;
        Arrays.sort(coins);  
        int res = 0;
        
        // Start from the coin with highest denomination
        for (int i = n - 1; i >= 0; i--) {
            if (amount >= coins[i]) {
              
                // Find the maximum number of ith coin we can use
                int cnt = (amount / coins[i]);
                
                // Add the count to result
                res += cnt;
                
                // Subtract the corresponding amount from 
                // the total amount
                amount -= (cnt * coins[i]);
            }
            
            // Break if there is no amount left
            if (amount == 0)
                break;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] coins = {5, 2, 10, 1};
        int amount = 39;
      
        System.out.println(minCoins(coins, amount));
    }
}
```

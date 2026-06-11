
```java class Solution {
    public int numberOfSteps(int num) {
//passing 0 initial steps
        return helper(num,0);
    }
    public int helper(int num,int steps){
//if not added resursion becomes infinite as it operates for zero as well
        if(num==0){
            return steps;
        }
      if(num%2==0){
//if even divide by 2
        num=num/2;
//As we need to count steps increase steps and reduce no. by 2
        return helper(num,steps+1);
      }
//otherwise when its odd subtract one and increase steps
      return helper(num-1,steps+1);
    }
}
```


Input: num = 14
Output: 6
Explanation: 
Step 1) 14 is even; divide by 2 and obtain 7. 
Step 2) 7 is odd; subtract 1 and obtain 6.
Step 3) 6 is even; divide by 2 and obtain 3. 
Step 4) 3 is odd; subtract 1 and obtain 2. 
Step 5) 2 is even; divide by 2 and obtain 1. 
Step 6) 1 is odd; subtract 1 and obtain 0.






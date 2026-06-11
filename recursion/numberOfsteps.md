
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

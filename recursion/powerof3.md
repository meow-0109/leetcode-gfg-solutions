```java class Solution {
    public boolean isPowerOfThree(int n) {
        //brute force direct thinking checking and multiplying eaach number by 3
        // if(n<=0) return false;
        // int power = 1;
        // if(power<n){
        //     power*=3;
        // }
        // return power==n;
        //use recursion
        // if(n<=0) return false;
        // if(n==1) return true;

        // if(n % 3 != 0) return false;
        // return isPowerOfThree(n/3);
        //most optimal approach
        return n > 0 && 1162261467 % n == 0;
    
    }
}

```

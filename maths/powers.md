power of 3

```java
public class powerofthree {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
//If a number is truly a power of 3, then dividing by 3 again and again should finally give 1
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        powerofthree solution = new powerofthree();
        int n = 27;
        boolean result = solution.isPowerOfThree(n);
        System.out.println(n + " is a power of three: " + result);
    }

}
```
Time Complexity:O(log n)

Example: n = 27
Iteration 1
27 % 3 == 0
27 / 3 = 9
Iteration 2
9 % 3 == 0
9 / 3 = 3
Iteration 3
3 % 3 == 0
3 / 3 = 1

Loop stops because:

1 % 3 != 0

Now:

return n == 1;

Since n became 1, answer is true.

2. power of 2
   
```java
public class poweroftwo {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        poweroftwo solution = new poweroftwo();
        int n = 16;
        boolean result = solution.isPowerOfTwo(n);
        System.out.println(n + " is a power of two: " + result);
    }
}
```
Important Trick

For every power of 2:

n       -> one 1-bit
n - 1   -> all bits after it become 1

AND operation removes that single 1.

Result becomes 0.
Time Complexity: O(1)
Space Complexity: O(1)

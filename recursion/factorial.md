```java
class GFG {

    static int factorial(int n)
    {
        // Calculating factorial of number
        //base condition 
        if (n == 0 || n == 1)
            return 1;
       //recursive call
        return n * factorial(n - 1);
    }

    public static void main(String[] args)
    {
        int num = 5;
        System.out.println(factorial(num));
    }
}
```

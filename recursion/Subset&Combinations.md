
# 1. Master This Pattern First: Include / Exclude

Suppose:

```text
nums = [1,2,3]
```

For every element, you have two choices:

```text
Include it
Exclude it
```

Decision tree:

```text
                    []
               /          \
            1               x
         /     \         /     \
      2          x     2         x
    /  \       /  \  /  \      /  \
   3    x     3   x 3   x    3    x
```

Every root-to-leaf path is one subset.

Examples:

```text
[1,2,3]
[1,2]
[1,3]
[1]
[2,3]
[2]
[3]
[]
```

This is the foundation.

---

# 2. Subsets

Question:

> Should I take this element or not?

State:

```java
helper(index)
```

Decision:

```text
Take current element
Skip current element
```

Template:

```java
curr.add(nums[index]);
helper(index + 1);

curr.remove(curr.size()-1);
helper(index + 1);
```

Notice:

```text
Take
Skip
```

exactly once per element.

Complexity:

```text
2^n
```

because every element creates two branches.

---

# 3. Combination Sum

Question:

> Can I reuse the same element?

For:

```text
[2,3,6,7]
target = 7
```

Decision:

```text
Take it again
Skip it forever
```

Tree:

```text
7

Take 2
|
5

Take 2
|
3

Take 2
|
1

Skip 2
|
Try 3
```

The key difference:

### Take

Stay on same index

```java
helper(index)
```

### Skip

Move forward

```java
helper(index + 1)
```

Think:

```text
Take => reuse allowed
Skip => done with this number
```

---

# 4. Combination (nCr)

Example:

```text
Choose 2 numbers from [1,2,3,4]
```

Again:

```text
Take
Skip
```

Tree:

```text
1

Take 1
Skip 1

2

Take 2
Skip 2
```

The only difference:

Stop when:

```java
curr.size() == k
```

Then store answer.

Notice:

```text
Subsets
Combination
Combination Sum
```

all use Include/Exclude.

---

# 5. Permutations

This is where students get confused.

Question changes:

```text
Which number should I place next?
```

Not:

```text
Take or skip?
```

Example:

```text
[1,2,3]
```

Root:

```text
[]
```

Choices:

```text
Choose 1
Choose 2
Choose 3
```

Tree:

```text
        []
      /  |  \
     1   2   3
```

After choosing 1:

```text
      [1]
      / \
     2   3
```

After choosing 2:

```text
      [1,2]
         |
         3
```

Result:

```text
[1,2,3]
```

Notice:

Subsets:

```text
Take / Skip
```

Permutations:

```text
For every unused element
choose it
```

Template:

```java
for(each unused number){

    choose

    recurse

    unchoose
}
```

This is a different pattern.

---

# 6. String Permutations

Example:

```text
ABC
```

Level 1:

```text
A
B
C
```

Choose A:

```text
BC
```

Choose B:

```text
AC
```

Choose C:

```text
AB
```

Tree:

```text
ABC

A
├─ B
│   └─ C
└─ C
    └─ B

B
├─ A
│   └─ C
└─ C
    └─ A

C
├─ A
│   └─ B
└─ B
    └─ A
```

Results:

```text
ABC
ACB
BAC
BCA
CAB
CBA
```

---

# 7. How to Recognize the Pattern

When you see a problem, ask:

### Question 1

Each element:

```text
Take or not take?
```

Then:

```text
Include/Exclude
```

Examples:

* Subsets
* Combination
* Combination Sum
* Target Sum
* Partition

---

### Question 2

Can elements be reused?

Yes:

```java
helper(index)
```

No:

```java
helper(index+1)
```

---

### Question 3

Do I need ordering?

If:

```text
[1,2]
[2,1]
```

are different answers

➡️ Permutation

Use:

```java
for loop + visited[]
```

---

# Why You Can't Solve Them Yet

You're trying to memorize solutions.

Instead, build a mental checklist:

```text
1. What is my state?
   index?
   target?
   current answer?

2. What choices do I have?
   take/skip?
   choose any unused?

3. What is the base case?

4. How do I undo the choice?
```

Every recursion problem can be attacked with these four questions.

# Practice Order

Do these in order:

1. Subsets (LeetCode 78)
2. Subsets II
3. Combination Sum (39)
4. Combination Sum II
5. Combinations (77)
6. Letter Combinations of Phone Number (17)
7. Permutations (46)
8. Permutations II
9. Palindrome Partitioning (131)
10. N-Queens (51)

Don't move to the next one until you can draw the recursion tree by hand.

If you master **Subsets → Combination Sum → Permutations**, 80% of backtracking interview questions start looking like the same problem with slightly different rules.




1.Subsets Leetcode 78
```java
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> ans=new ArrayList<>();
    helper(0,nums,new ArrayList<>(),ans);
    return ans;
        
    }

    public void helper(int index,int[] nums,List<Integer> curr,List<List<Integer>> ans){
        if(index==nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        //include
        curr.add(nums[index]);
        helper(index+1,nums,curr,ans);
        //backtrack
        curr.remove(curr.size()-1);
        //exclude
        helper(index+1,nums,curr,ans);
    }
}
```
| Part                           | Complexity |
| ------------------------------ | ---------- |
| Time                           | O(n × 2ⁿ)  |
| Aux Space (stack only)         | O(n)       |
| Total Space (including answer) | O(n × 2ⁿ)  |


2.Subsets ||
First sort the array
Here it is same like subsets but just remove duplicates 
idea is that check if nums[index]==nums[index+1]
move to next index
```java
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> ans=new ArrayList<>();
    helper(0,nums,new ArrayList<>(),ans);
    return ans;
        
    }

    public void helper(int index,int[] nums,List<Integer> curr,List<List<Integer>> ans){
        if(index==nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        //include
        curr.add(nums[index]);
        helper(index+1,nums,curr,ans);
        //backtrack
        curr.remove(curr.size()-1);
        //exclude
//Here consiser for duplicates
        while(index+1 < nums.length && nums[index] == nums[index+1])
        {
            index++;
        }
    helper(index+1,nums,curr,ans);    
    }
}

```
Complexity

Still:

Time:

O(n⋅2
n
)

Space:

O(n)

Sorting adds:

O(nlogn)

but n·2^n dominates.

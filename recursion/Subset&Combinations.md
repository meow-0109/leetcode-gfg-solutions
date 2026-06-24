
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

3.Combination Sum(Leetcode 39)

```java
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        helper(
            candidates,
            target,
            0,                      // start index
            new ArrayList<>(),      // current combination
            ans
        );

        return ans;
    }
    private void helper(
    int[] candidates,
    int target,
    int index,
    List<Integer> curr,
    List<List<Integer>> ans
) {

    if (target == 0) {
        ans.add(new ArrayList<>(curr));
        return;
    }

    if (target < 0 || index == candidates.length) {
        return;
    }

    // Take current number

    curr.add(candidates[index]);

    helper(
        candidates,
        target - candidates[index],
        index,      // index or index + 1 ?
        curr,
        ans
    );

    curr.remove(curr.size() - 1);

    // Skip current number

    helper(
        candidates,
        target,
        index + 1,
        curr,
        ans
    );
}
}
```
Good approach. For **Combination Sum**, try to think of it as a **decision tree**.

Don't think about optimization yet. Just build the brute-force recursion.

### Step 1: What choices do you have?

Suppose you're at index `i`.

For the current number `candidates[i]`, you have **two choices**:

1. **Take it**

   * Add it to the current combination.
   * Since the same number can be reused, stay at the **same index**.

2. **Skip it**

   * Don't add it.
   * Move to the **next index**.

So your recursion tree looks like:

```text
helper(i, target)

├── take candidates[i]
│     helper(i, target - candidates[i])
│
└── skip candidates[i]
      helper(i + 1, target)
```

---

### Step 2: What information must your recursive function carry?

Ask yourself:

```java
helper( ?, ?, ? )
```

What do you need to know at every step?

* current index
* remaining target
* current combination being built

So something like:

```java
helper(index, remainingTarget, currentList)
```

---

### Step 3: Base Cases

Think carefully.

#### When have you found a valid combination?

If remaining target becomes:

```java
remainingTarget == 0
```

What should happen?

---

#### When should recursion stop?

What if:

```java
index == candidates.length
```

and target is still not 0?

Or

```java
remainingTarget < 0
```

What does that mean?

---

### Step 4: Backtracking

When you choose a number:

```java
current.add(...)
```

After the recursive call returns, what must happen before exploring another branch?

Think about why this is necessary.

---

### Dry Run

Try:

```java
candidates = [2,3]
target = 5
```

Draw:

```text
(0,5)
├─ take 2 -> (0,3)
│   ├─ take 2 -> (0,1)
│   └─ skip 2 -> (1,3)
│
└─ skip 2 -> (1,5)
```

Keep expanding until you hit the base cases.

---

Before coding, answer this:

When you **take** `candidates[i]`, do you call:

```java
helper(i, ...)
```

or

```java
helper(i + 1, ...)
```
The next thing is to optimize
Use for loop backtracking
Instead of explicit take/skip, compress the skip branches into a loop.

Idea:

At each level, try every possible next candidate.

Tree:

[]
├── 2
│   ├── 2
│   │   ├── 2
│   │   └── 3
│   └── 3
├── 3
│   └── 4
└── 7
Instead of checking each element with two choisess 
1.take
2.skip
so it looks binary.

But depth depends on target, not just n.
Suppose
```
candidates = [1]
target = T
```

and **why**? That is the key insight of Combination Sum.


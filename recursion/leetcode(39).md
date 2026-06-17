```java
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //This is list of unique combination of candidates we need to return
        
        List<List<Integer>> ans = new ArrayList<>();
          //call recursive fun
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
//base case 1
//if target becomes 0 just return current element 
    if (target == 0) {
        ans.add(new ArrayList<>(curr));
        return;
    }
//if target less than 0 and index equals length of array just end
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

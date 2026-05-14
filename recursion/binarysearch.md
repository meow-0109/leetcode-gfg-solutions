```java
class Solution {
    public int search(int[] nums, int target) {
        return binarysearch(nums,0,nums.length-1,target);
    }
    public int binarysearch(int[] nums,int low,int high,int target){
//base condition
        if(low>high){
            return -1;
        }
        int mid=low+(high-low) / 2;
        if(nums[mid]==target){
            return mid;
        }
   
        else if (target < nums[mid]) {
            return binarysearch(nums, low, mid - 1, target);
        }
        else{
            return binarysearch(nums,mid+1,high,target);
        } 
    } 
}
```

T(n)=T(n/2)+1
Which gives:

O(logn)

because size becomes

n → n/2 → n/4 → n/8 → ...

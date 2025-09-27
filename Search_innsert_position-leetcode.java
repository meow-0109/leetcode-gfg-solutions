class Solution {
    public int searchInsert(int[] nums, int target) {
        int right=nums.length-1;
        int left=0;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){
                left=mid+1;

            }
            else{
                right=mid-1;
            }

        }
        return left;
    }
}

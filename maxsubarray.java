//bruteforce approach
class maxsubarray{
    public int maxsubarray(int[] nums){
        int maxsum=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int sum=0;
            for(int j=i;j<nums.length;j++){
                sum+=nums[i];
                maxsum=MAsth.max(maxsum,sum);

            }
        }
        return maxsum
    }
}



//optimized using kadane's algorithm

class Solution {
    public int maxSubArray(int[] nums) {
            int maxsofar=nums[0];
             int currentsum=nums[0];

        for(int i=1;i<nums.length;i++){
            currentsum=Math.max(nums[i],nums[i]+currentsum);
            maxsofar=Math.max(maxsofar,currentsum);
        }
return maxsofar;
    }

}
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int i=0;
    while(i<nums.length){
        int correct=nums[i]-1;
        if(nums[i]!=nums[correct]){
            swap(nums,i,correct);
        }
        else{
            i++;
        }

        }
        List<Integer> res=new ArrayList<>();
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=j+1){
                res.add(j+1);
            }
        }
        return res;
    }
    void swap(int[] arr,int start,int last){
        int temp=arr[start];
        arr[start]=arr[last];
        arr[last]=temp;
    }
}

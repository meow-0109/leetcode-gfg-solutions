//Finding the pivot: O(n) in the worst case (traverse from right to left once).

//Finding the successor: O(n) in the worst case (traverse from right to left again).

//Reversing the suffix: O(n) in the worst case (swap elements in the suffix).

//This is optimal approach
class Solution {
    public void nextPermutation(int[] nums) {
     int n=nums.length;
     int i=n-2;
     while(i>=0 && nums[i]>=nums[i+1]){
        i--;
     }
     if(i>=0){
        int j=n-1;
        while(nums[j]<nums[i]){
            j--;
        }
        swap(nums,i,j);
     }
     swap(nums,i+1,n-1);
    }
    private void reverse(int[] arr,int start,int end){
        while(start<=end){
          start++;
          end--;
        }
    }
    private void swap(int[] arr,int i,int j){
        int temp=0;
        temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

}

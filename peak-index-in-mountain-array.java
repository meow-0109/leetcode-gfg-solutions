class Solution {
    public int peakIndexInMountainArray(int[] arr) {
       // for(int i=0;i<arr.length;i++){
            //brute force
            //if(arr[i]>arr[i+1]){
            //    return i;
           // }
       // }
       // return -1;
       int start=0;
       int end=arr.length-1;
       while(start<end){
        int mid=start+(end-start)/2;
        if(arr[mid]<arr[mid+1]){
            start=mid+1;
        }
        else{
            end=mid;
        }
       }
       return start;
    }
}

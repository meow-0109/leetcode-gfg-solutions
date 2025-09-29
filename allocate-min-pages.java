//This is binary search approach
//Time: O(n log(sum)).
class Solution {
    public int findPages(int[] arr, int k) {
        // code here
        if(k>arr.length){
            return -1;
        }
        int start=Integer.MIN_VALUE;
        int end=0;
        for(int i:arr){
            start=Math.max(start,i);
            end+=i;
        }
        while(start<=end){
            int mid=start+(end-start)/2;
        if(isPossible(arr,arr.length,k,mid)){
            end=mid-1;
        }
        else{
            start=mid+1;
        }
    }
      
      return start;
    }
    
    private static boolean isPossible(int[] pages,int n,int k,int maxpages )
    {
        int students=1;
        int currentpages=0;
        for(int p:pages){
            if(currentpages+p>maxpages){
                students++;
                currentpages=p;
                if(students>k){
                    return false;
                }
            }
                else{
                    currentpages+=p;
                }
            }
        return true;
    }
}
}

class Solution {
    public boolean checkIfExist(int[] arr) {
        //1.brute force using nested loops time complexity(O(n^2))
        for(int i=0;i<arr.length;i++){
           for(int j=0;j<arr.length;j++){
           if(i!=j && arr[i]==2*arr[j]){
             return true;
           }
           }
       }
       return false;

         //2.Using hashset(optimal)
             Set<Integer> set = new HashSet<>();   
               for(int x : arr){
             if(set.contains(2*x) || (x % 2 == 0 && set.contains(x/2))){
                return true;
                        }
                  set.add(x);
                       }
               return false;
           // 3.using hashmap
            Map<Integer, Integer> freq = new HashMap<>();
             for(int x : arr) freq.put(x, freq.getOrDefault(x, 0)+1);

               for(int x : arr){
    if(x == 0 && freq.get(x) > 1) return true;
    if(x != 0 && freq.containsKey(2*x)) return true;
}
return false;
      // 4.Using sorting + binary search  O(nlogn)
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            int target=2*arr[i];
            int left=0;
            int right=arr.length-1;
            while(left<=right){
                int mid=left+(right-left)/2;
                if(arr[mid]==target){
                if(mid!=i){
                    return true;
                }
                else break;
                }
                 
                else if(arr[mid]>target){
                    right=mid-1;
                }
                else{
                    left=mid+1;
                }
            }
        }
        return false;


    }


}

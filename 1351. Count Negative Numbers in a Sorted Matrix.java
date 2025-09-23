//brute force traverse all elements with two loops
class Solution {
    public int countNegatives(int[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++{
                if(grid[i][j]<0){
                    count++;
                }
            }
        }
        return count;
    }
}
//optimized using sorting properties
//If current element is negative → all elements below in this column are also negative, so add them to count and move left.
//If current element is non-negative → move down.
class Solution {
    public int countNegatives(int[][] grid) {
       int n=grid.length;
       int m=grid[0].length;
       int start=0;
       int end=m-1;
       int count=0;

       while(start<n && end>=0 ){
        if(grid[start][end]<0){
            count+=(n-start);
            end--;
        }
        else{
            start++;
        }
       }
       return count;
    }
}

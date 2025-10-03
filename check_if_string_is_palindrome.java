class Solution {
    public boolean isPalindrome(int x) {
        for(int i=0;i<x.length()/2;i++){
            if(x.charAt(i)!=x.charAt(x.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}

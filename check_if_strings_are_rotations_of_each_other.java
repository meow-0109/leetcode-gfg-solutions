class Solution {
    //public boolean areRotations(String s1, String s2) {
        // code here
        //naive approach checking all rotations O(n^2)tc and O(1) sc
    //     int n=s1.length();
    //     for(int i=0;i<n;i++){
    //         if(s1.equals(s2)){
    //         return true;
            
    //     }
    //     char last=s1.charAt(s1.length()-1);
    //     s1=last+s1.substring(0,s1.length()-1);
    // }
    // return false;
    // String txt=s1+s2;
    // String pat=s2;
    // int n=txt.length();
    // int m=pat.length();
    // int lps[]=computeLPSArray(pat);
    // int i=0;
    // int j=0;
    // while(i<n){
    //     if(pat.charAt(j)==txt.charAt(i)){
    //         i++;
    //         j++;
    //     }
    //     if(j==m){
    //         return true;
    //     }
    //     else if(i<n && pat.charAt(j)!=txt.charAt(i)){
    //         if(j!=0){
    //             j=lps[j-1];
    //         }
    //         else{
    //             i++;
    //         }
    //     }
    // }
    // return false;
    
    // }
        private boolean KMPSearch(String txt, String pat) {
        int n = txt.length();
        int m = pat.length();
        int[] lps = computeLPSArray(pat);
        int i = 0, j = 0;

        while (i < n) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++; j++;
            }
            if (j == m) {
                return true; // pattern found
            } else if (i < n && txt.charAt(i) != pat.charAt(j)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }
        return false;
    }

   
    private int[] computeLPSArray(String pat){
        int n=pat.length();
        int[] lps=new int[n];
        int len=0;
        int i=1;
        while(i<n){
            if(pat.charAt(i)==pat.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }
            else{
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }

            }
        }
        return lps;
    }
        public boolean areRotations(String s1, String s2) {
        // If lengths differ, can't be rotations
        if (s1.length() != s2.length()) return false;

        String txt = s1 + s1;  // should be s1+s1, not s1+s2
        return KMPSearch(txt, s2);
    }

}

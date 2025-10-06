//Best Use an integer array of size 26 (for lowercase letters).
//Increment count for each char in s.
//Decrement count for each char in t.
//If all counts are 0 → it’s an anagram.
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] count = new int[26]; // For lowercase a-z

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        // Check if all counts are zero
        for (int c : count) {
            if (c != 0) return false;
        }

        return true;
    }
}
//Sort both strings and check if they’re equal.
class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false;
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        return Arrays.equals(sArr, tArr);

    }
}

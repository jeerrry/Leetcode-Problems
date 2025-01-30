class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freq = new int[26];

        for(char c : s.toCharArray()) {
            int index = c - 'a';
            freq[index]++;
        }

        for(char c : t.toCharArray()) {
            int index = c - 'a';
            freq[index]--;
        }

        for(int val : freq) {
            if(val != 0) return false;
        }

        return true;
    }
}
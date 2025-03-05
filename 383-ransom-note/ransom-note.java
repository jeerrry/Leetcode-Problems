class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        var freq = new int[26];
        for(char c : ransomNote.toCharArray()) freq[c - 'a']++;

        for(char c : magazine.toCharArray()) {
            int index = c - 'a';
            if(freq[index] > 0) freq[index]--;
        }

        for(int val : freq) if(val > 0) return false;

        return true;
    }
}
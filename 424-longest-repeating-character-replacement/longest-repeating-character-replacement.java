class Solution {
    public int characterReplacement(String s, int k) {
        int length = 0;
        int maxFreq = 0;
        int[] frequency = new int[26];

        int start = 0;
        for(int i=0; i<s.length(); i++) {
            int index = s.charAt(i) - 'A';
            frequency[index]++;
            maxFreq = Math.max(maxFreq, frequency[index]);

            int charReplacement = (i - start + 1) - maxFreq;
            if(charReplacement > k) {
                frequency[s.charAt(start++) - 'A']--;
            }

            length = Math.max(length, i - start + 1);
        }

        return length;
    }
}
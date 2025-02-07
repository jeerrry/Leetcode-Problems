class Solution {
    public int beautySum(String s) {
        int result = 0;
        for(int i=0; i<s.length(); i++) {
            int[] freq = new int[26];
            int maxFreq = 0;
            for(int j=i; j<s.length(); j++) {
                int index = s.charAt(j) - 'a';
                freq[index]++;

                maxFreq = Math.max(maxFreq, freq[index]);
                int minFreq = Integer.MAX_VALUE;
                for(int val : freq) {
                    if(val > 0) minFreq = Math.min(minFreq, val);
                }

                result+= (maxFreq - minFreq);
            }
        }

        return result;
    }
}
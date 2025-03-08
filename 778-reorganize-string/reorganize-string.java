class Solution {
    public String reorganizeString(String s) {
        var freq = new int[26];
        int maxIndex = 0;
        int length = s.length();
        for(int i=0; i<length; i++) {
            char c = s.charAt(i);
            int index = c - 'a';
            freq[index]++;

            if(freq[maxIndex] < freq[index]) {
                maxIndex = index;
            }
        }

        if(freq[maxIndex] > length + 1 >>> 1) return "";
        int k = 0;
        
        char[] result = new char[length];
        char c = (char)(maxIndex + 'a');
        for(;freq[maxIndex] > 0; freq[maxIndex]--) {
            result[k] = c;
            k+=2;
            if(k >= length) k = 1;
        }

        for(int i=0; i<26; i++) {
            c = (char) (i + 'a');
            for(int j=0; j<freq[i]; j++) {
                result[k] = c;
                k+=2;

                if(k >= length) k = 1;
            }
        }

        return String.valueOf(result);
    }
}
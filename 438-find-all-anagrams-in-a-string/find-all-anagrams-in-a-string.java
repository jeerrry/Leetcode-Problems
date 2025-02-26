class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        var result = new ArrayList<Integer>();
        var freq = new int[26];
        var tFreq = new int[26];
        for(char c : p.toCharArray()) {
            tFreq[c - 'a']++;
        }
        
        int k = p.length();
        for(int i=0,j=0; j<s.length(); j++) {
            char current = s.charAt(j);
            freq[current - 'a']++;
            if(j - i + 1 == k) {
                if(isMatch(freq, tFreq)) {
                    result.add(i);
                }

                char old = s.charAt(i++);
                freq[old - 'a']--;
            }
        }

        return result;
    }

    private boolean isMatch(int[] a, int[] b) {
        for(int i=0; i<26; i++) {
            if(a[i] != b[i]) return false;
        }

        return true;
    }
}
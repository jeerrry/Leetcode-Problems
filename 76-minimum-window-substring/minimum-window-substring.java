class Solution {
    public String minWindow(String s, String t) {
        var tFreq = new HashMap<Character, Integer>();
        for(char c : t.toCharArray()) tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);

        int minLength = s.length() + 1;
        int start = 0;
        int count = 0;
        int substr = 0;
        for(int i=0; i<s.length(); i++) {
            char current = s.charAt(i);
            if(tFreq.containsKey(current)) {
                int ccount = tFreq.getOrDefault(current, 0);
                tFreq.put(current, --ccount);
                if(ccount == 0) count++;
            }

            // Compress window
            while(count == tFreq.size()) {
                if(minLength > i - start + 1) {
                    minLength = i - start + 1;
                    substr = start;
                }

                char deleted = s.charAt(start++);
                if(tFreq.containsKey(deleted)) {
                    if(tFreq.get(deleted) == 0) count--;
                    tFreq.put(deleted, tFreq.getOrDefault(deleted, 0) + 1);
                }
            }
        }

        return minLength > s.length() ? "" : s.substring(substr, substr + minLength);
    }
}
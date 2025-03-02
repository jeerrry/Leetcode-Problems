class Solution {
    public int numberOfSubstrings(String s) {
        int count = 0;
        var freq = new HashMap<Character, Integer>();

        for (int start = 0, end = 0; end < s.length(); end++) {
            char current = s.charAt(end);
            freq.put(current, freq.getOrDefault(current, 0) + 1);

            // Shrink window when all three characters are present
            while (freq.size() == 3) {
                // Correct counting: All substrings ending at `end`
                count += s.length() - end; 

                char c = s.charAt(start++);
                int old = freq.get(c);
                if (old - 1 == 0) {
                    freq.remove(c);
                } else {
                    freq.put(c, old - 1);
                }
            }
        }

        return count;
    }
}

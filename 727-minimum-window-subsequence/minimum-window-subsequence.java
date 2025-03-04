class Solution {
    public String minWindow(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int start = 0, len = Integer.MAX_VALUE, count = 0;

        for (int i = 0; i < m; i++) {
            if (s1.charAt(i) == s2.charAt(count)) count++;

            // all characters in s2 are matched. now reduce the window to the right-most part which has all the characters in s2
            if (count == n) {
                int j = i;
                // Doing this over here remove duplicates from the start...
                // abbcdebdde -> doing validation gets the min win since the last of two
                // bb makes it to the count.
                while (count > 0) {
                    if (s2.charAt(count - 1) == s1.charAt(j--)) {
                        count--;
                    }
                }
                j++; // index in s1 which is the first character in s2

                if (len > i - j + 1) {
                    len = i - j + 1;
                    start = j;
                }
                // move back i so it starts next search from j+1 in next iteration
                i = j;
            }
        }
        return len == Integer.MAX_VALUE ? "" : s1.substring(start, start + len);
    }
}

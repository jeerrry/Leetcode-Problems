class Solution {
    public boolean isPalindrome(String s) {
        int p1 = 0;
        int p2 = s.length() - 1;
        while(p1 < p2) {
            char a = Character.toLowerCase(s.charAt(p1));
            char b = Character.toLowerCase(s.charAt(p2));

            boolean isAValid = Character.isLetterOrDigit(a);
            boolean isBValid = Character.isLetterOrDigit(b);

            if(!isAValid) {
                p1++;
                continue;
            }

            if(!isBValid) {
                p2--;
                continue;
            }

            if(isAValid && isBValid) {
                if(a != b) {
                    return false;
                }
            }

            p1++;
            p2--;
        }

        return true;
    }
}
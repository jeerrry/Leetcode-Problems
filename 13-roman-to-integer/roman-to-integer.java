class Solution {
    static Map<Character, Integer> values = new HashMap<>();
    static {
        values.put('M', 1000);
        values.put('D', 500);
        values.put('C', 100);
        values.put('L', 50);
        values.put('X', 10);
        values.put('V', 5);
        values.put('I', 1);
    }
    public int romanToInt(String s) {
        int res = 0;
        for(int i=0; i<s.length(); i++) {
            char current = s.charAt(i);
            if(i + 1 < s.length()) {
                char next = s.charAt(i + 1);
                if(values.get(current) < values.get(next)) {
                    res -= values.get(current);
                }else {
                    res += values.get(current);
                }
            }else {
                res += values.get(current);
            }
        }

        return res;
    }
}
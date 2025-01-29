class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length - 1];

        if(first.length() == 0) return "";
        
        var prefix = new StringBuilder();
        for(int i=0; i<last.length() && i < first.length(); i++) {
            char a = first.charAt(i);
            char b = last.charAt(i);

            if(a == b) {
                prefix.append(a);
                continue;
            }

            break;
        }

        return prefix.toString();
    }
}
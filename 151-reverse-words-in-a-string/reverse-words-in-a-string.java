class Solution {
    public String reverseWords(String s) {
        s = s.trim();

        var result = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == ' ') continue;
            var temp = new StringBuilder();
            temp.append(" ");
            while(i < s.length() && s.charAt(i) != ' ') {
                temp.append(s.charAt(i) + "");
                i++;
            }


            result.insert(0, temp);
        }

        s = result.toString().trim();

        return s;
    }
}
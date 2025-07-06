class Solution {
    int index = 0;
    public String decodeString(String s) {
        var builder = new StringBuilder();

        while(index < s.length() && s.charAt(index) != ']') {
            char current = s.charAt(index);
            if(!Character.isDigit(current)){
                builder.append(current);
                index++;
            }
            else {
                int multiplier = 0;
                while(index < s.length() && Character.isDigit(s.charAt(index))) {
                    multiplier = multiplier * 10 + s.charAt(index++) - '0';
                }

                index++;

                var result = decodeString(s);

                index++;

                while(multiplier-- > 0) {
                    builder.append(result);
                }
            }
        }

        return builder.toString();
    }
}
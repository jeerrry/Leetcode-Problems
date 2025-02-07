class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] builder = new StringBuilder[numRows];
        for(int i=0; i<numRows; i++) builder[i] = new StringBuilder();

        boolean increase = true;
        int index = 0;
        int builderIndex = 0;
        while(index < s.length()) {
            builderIndex = 0;
            while(index < s.length() && builderIndex < numRows) {
                char current = s.charAt(index++);
                builder[builderIndex++].append(current + "");
            }

            builderIndex = numRows - 1 - 1;
            while(index < s.length() && builderIndex > 0) {
                char current = s.charAt(index++);
                builder[builderIndex--].append(current + "");
            }
        }

        String result = "";
        for(var bul : builder) {
            result += bul.toString();
        }

        return result;
    }
}
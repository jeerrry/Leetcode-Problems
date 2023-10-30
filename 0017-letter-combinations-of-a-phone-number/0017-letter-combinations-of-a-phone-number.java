class Solution {
    private String[] charMap = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        var result = new ArrayList<String>();
        letterCombinationsHelper(digits, "", result);

        return result;
    }

    public void letterCombinationsHelper(String digits, String rsf, List<String> res) {
        if (digits.length() == 0) {
            if(rsf.length() > 0) {
                res.add(rsf);
            }
            return;
        }

        int current = Character.getNumericValue(digits.charAt(0));
        String alphabets = charMap[current];
        
        for(int i=0; i<alphabets.length(); i++) {
            char cc = alphabets.charAt(i);
            letterCombinationsHelper(digits.substring(1), rsf + cc, res);
        }
    }
}

class Solution {
    public int maxProduct(String s) {
        int N = s.length();
        HashMap<Integer, Integer> palindromes = new HashMap<>();

        for (int i = 1; i < 1 << N; i++) {
            StringBuilder palindrome = new StringBuilder();
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) > 0) {
                    palindrome.append(s.charAt(j));
                }
            }

            if (palindrome.toString().equals(new StringBuilder(palindrome.toString()).reverse().toString())) {
                palindromes.put(i, palindrome.length());
            }
        }

        int result = 0;
        for (var key1 : palindromes.keySet()) {
            for (var key2 : palindromes.keySet()) {
                if((key1 & key2) == 0) {
                    int val1 = palindromes.get(key1);
                    int val2 = palindromes.get(key2);

                    result = Math.max(result, val1 * val2);
                }
            }
        }

        return result;
    }
}
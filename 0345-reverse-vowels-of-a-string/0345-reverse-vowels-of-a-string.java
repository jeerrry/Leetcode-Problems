class Solution {
    static final String vowels = "aeiouAEIOU";
    public String reverseVowels(String s) {
        int first = 0, last = s.length() - 1; // Initialize the two pointers
        char[] array = s.toCharArray();
        while (first < last) {
          while (first < last && vowels.indexOf(array[first]) == -1) {
            first++; // Skip non-vowel characters from the start
          }
          while (first < last && vowels.indexOf(array[last]) == -1) {
            last--; // Skip non-vowel characters from the end
          }
          char temp = array[first]; // Swap the vowels found at first and last
          array[first] = array[last];
          array[last] = temp;
          first++;
          last--;
        }
        return new String(array); // Return the reversed string
    }
}
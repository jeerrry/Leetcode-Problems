class Solution {
    public String removeDuplicateLetters(String s) {
        var freq = new int[26];
        var stack = new Stack<Character>();
        var result = new StringBuilder();
        var use = new boolean[26];

        for(char c : s.toCharArray()) freq[c - 'a']++;

        for(char c : s.toCharArray()) {
            freq[c - 'a']--;
            if(use[c - 'a']) continue;
            
            while(!stack.isEmpty() && stack.peek() > c && freq[stack.peek() - 'a'] > 0){
                    use[stack.peek() - 'a'] = false;
                    stack.pop();
            }
            
            stack.push(c);
            use[c - 'a'] = true;
        }

        while(!stack.isEmpty()) result.append(stack.pop());

        result.reverse();

        return result.toString();
    }
}
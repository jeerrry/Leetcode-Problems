class Solution {
    public boolean isValid(String s) {
        var stack = new Stack<Character>();
        var map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');


        for(char c : s.toCharArray()) {
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                char open = map.get(c);
                if(stack.isEmpty() || stack.peek() != open) return false;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
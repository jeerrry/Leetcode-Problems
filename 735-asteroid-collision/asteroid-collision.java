class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        var stack = new Stack<Integer>();

        for(int val : asteroids) {
            boolean isContinue = false;
            while(!stack.isEmpty() && stack.peek() > 0 && val < 0) {
                if(val * -1 == stack.peek()) {
                    stack.pop();
                    isContinue = true;
                    break;
                }
                else if(val * -1 > stack.peek()) stack.pop();
                else {
                    isContinue = true;
                    break;
                }
            }

            if(isContinue) continue;
            stack.push(val);
        }

        var result = new int[stack.size()];
        int j = result.length - 1;
        while(!stack.isEmpty()) result[j--] = stack.pop();
        return result;
    }
}
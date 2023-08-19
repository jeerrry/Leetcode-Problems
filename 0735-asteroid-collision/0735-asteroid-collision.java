class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<asteroids.length; i++) {
            int asteroid = asteroids[i];
            if(stack.size() == 0) {
                stack.push(asteroid);
                continue;
            }
            
            boolean currentDir = asteroid < 0;
            while(stack.size() > 0) {
                int lastVal = stack.peek();
                boolean lastDir = lastVal < 0;
                
                if(lastDir == currentDir || !currentDir) {
                    stack.push(asteroid);
                    break;
                }else{
                    int diff = lastVal + asteroid;
                    if(diff == 0){
                        stack.pop();
                        break;
                    }else if(diff > 0){
                        break;
                    }else {
                        stack.pop();
                        if(stack.size() == 0){
                            stack.push(asteroid);
                            break;
                        }
                    }
                }
            }
        }
        
        int[] result = new int[stack.size()];
        int index = stack.size() - 1;
        while(stack.size() > 0) {
            result[index--] = stack.pop();
        }
        
        return result;
    }
}
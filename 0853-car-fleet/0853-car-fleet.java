class Pair {
    int position;
    int speed;
    double turnsToReach;
    
    public Pair(int position, int speed, int target) {
        this.position = position;
        this.speed = speed;
        int leftTurns = target - position;
        turnsToReach = leftTurns <= 0 ? 0 : leftTurns/(double)speed;
    }
}

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Pair[] vehicles = new Pair[position.length];
        for(int i=0; i<position.length; i++) {
            int currentPosition = position[i];
            int currentSpeed = speed[i];
            vehicles[i] = new Pair(currentPosition, currentSpeed, target);
        }
        
        Arrays.sort(vehicles, (a, b) -> b.position - a.position);
        
        Stack<Pair> stack = new Stack<>();
        
        for(int i=0; i<position.length; i++) {
            Pair current = vehicles[i];
            if(stack.size() == 0) {
                stack.push(current);
            }else{
                while(stack.size() > 0) {
                    Pair last = stack.peek();
                    if(current.turnsToReach > last.turnsToReach){
                        stack.push(current);
                    }
                    break;
                }
            }
        }
        
        return stack.size();
    }
}
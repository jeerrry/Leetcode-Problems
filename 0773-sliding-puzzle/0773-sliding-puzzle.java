class Solution {

    public int slidingPuzzle(int[][] board) {
        Queue<String> queue = new LinkedList<>();
        String target = "123450";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j] + "");
            }
        }

        String initial = sb.toString();
        int[][] swapIdx = { { 1, 3 }, { 0, 2, 4 }, { 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 4, 2 } };
        
        queue.add(initial);
        int level = 0;
        HashSet<String> visited = new HashSet<>();
        
        while(queue.size() > 0) {
            int size = queue.size();
            
            while(size-->0) {
                String rem = queue.remove();
                
                if(rem.equals(target)) return level;
                int cIdx = rem.indexOf('0');
                int[] possibleMoves = swapIdx[cIdx];
                
                for(int idx : possibleMoves) {
                    String nTarget = swapChars(rem, cIdx, idx);
                    if(visited.contains(nTarget)) continue;
                    
                    visited.add(nTarget);
                    queue.add(nTarget);
                }
            }
            
            level++;
        }
        
        return -1;
    }
    
    public String swapChars(String input, int current, int target) {
        char[] chars = input.toCharArray();
        chars[current] = chars[target];
        chars[target] = '0';
        
        return String.valueOf(chars);
    }
}

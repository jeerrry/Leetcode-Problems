class Solution {
    private Queue<int[]> queue = new LinkedList<>();
    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        
        int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        int distance = 0;
        while(queue.size() > 0) {
            int count = queue.size();
            
            for(int i=0; i<count; i++) {
                int[] coord = queue.remove();
                
                int row = coord[0];
                int col = coord[1];
                
                for(int[] dir : dirs) {
                    int nrow = row + dir[0];
                    int ncol = col + dir[1];
                    if(nrow < 0 || ncol < 0 || nrow == rooms.length || ncol == rooms[0].length) continue;
                    if(rooms[nrow][ncol] != Integer.MAX_VALUE) continue;
                    queue.add(new int[]{nrow, ncol});
                }
                
                int value = rooms[row][col];
                if(value == Integer.MAX_VALUE) {
                    rooms[row][col] = distance;
                }
            }
            distance++;
        }
    }
}

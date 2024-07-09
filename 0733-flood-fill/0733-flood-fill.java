class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        
        int startColor = image[sr][sc];
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            for(int i=0; i<size; i++) {
                int[] coord = queue.remove();
                image[coord[0]][coord[1]] = color;
                
                for(int[] dir : dirs) {
                    int row = coord[0] + dir[0];
                    int col = coord[1] + dir[1];
                    
                    if(row < 0 || col < 0) continue;
                    if(row >= image.length || col >= image[0].length) continue;
                    if(image[row][col] == color) continue;
                    
                    if(image[row][col] == startColor) {
                        queue.add(new int[]{row, col});
                    }
                }
            }
        }
        
        return image;
    }
}
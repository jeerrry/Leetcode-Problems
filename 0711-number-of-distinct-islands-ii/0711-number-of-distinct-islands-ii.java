class Solution {
    public int numDistinctIslands2(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Set<List<List<Integer>>> islands = new HashSet<>();
        
        for(int i=0; i<row; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 0) continue;
                
                var list = new ArrayList<Integer>();
                dfs(i, j, grid, list);
                islands.add(normalize(list, row, col));
            }
        }
        
        return islands.size();
    }
    
    private List<List<Integer>> normalize(List<Integer> coords, int rows, int cols) {
        List<int[]>[] allTransformations = new ArrayList[8];
        
        for(int i=0; i<8; i++) allTransformations[i] = new ArrayList<>();
        for(int shape : coords) {
            int row = shape / cols;
            int col = shape % cols;
            
            // Rotations
            allTransformations[0].add(new int[]{row, col});
            allTransformations[1].add(new int[]{col, -row});
            allTransformations[2].add(new int[]{-row, -col});
            allTransformations[3].add(new int[]{-col, row});
            
            // Reflections
            allTransformations[4].add(new int[]{row, -col});
            allTransformations[5].add(new int[]{col, row});
            allTransformations[6].add(new int[]{-row, col});
            allTransformations[7].add(new int[]{-col, -row});
        }
        
        for(List<int[]> transformations : allTransformations) {
            transformations.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            
            int bRow = transformations.get(0)[0];
            int bCol = transformations.get(0)[1];
            for(int i = transformations.size() - 1; i>=0; i--) {
                int[] coord= transformations.get(i);
                coord[0] -= bRow;
                coord[1] -= bCol;
                
                transformations.set(i, coord);
            }
        }
        
        Arrays.sort(allTransformations, (a, b) -> {
            for(int k = 0; k < a.size(); k++) {
                int[] coordsA = a.get(k);
                int[] coordsB = b.get(k);
                
                if(coordsA[0] != coordsB[0]) return coordsA[0] - coordsB[0];
                if(coordsA[1] != coordsB[1]) return coordsA[1] - coordsB[1];
            }
            
            return 0;
        });
        
        
        List<List<Integer>> cannonicalShape = new ArrayList<>();
        for(int[] coord : allTransformations[0]) {
            cannonicalShape.add(Arrays.asList(coord[0], coord[1]));
        }
        
        return cannonicalShape;
    }
    
    private void dfs(int row, int col, int[][] grid,ArrayList<Integer> coords) {
        if(grid[row][col] == 0) return;
        grid[row][col] = 0;
        coords.add(row * grid[0].length + col);
        
        int[] dir = {-1, 0, 1, 0, -1};
        for(int i=0; i<4; i++) {
            int nrow = row + dir[i];
            int ncol = col + dir[i + 1];
            
            if(nrow < 0 || ncol < 0 || nrow >= grid.length || ncol >= grid[0].length) continue;
            dfs(nrow, ncol, grid, coords);
        }
    }
}
class Solution {
    private int[] parent;
    private int[] rank;

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        parent = new int[m * n];
        rank = new int[m * n];
        Arrays.fill(parent, -1);
        int count = 0;
        int[][] directions = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

        for (int i = 0; i < positions.length; i++) {
            int row = positions[i][0];
            int col = positions[i][1];
            int cellno = row * n + col;

            if (parent[cellno] > -1) {
                ans.add(count);
                continue;
            }

            parent[cellno] = cellno;
            rank[cellno] = 1;
            count++;
            
            for(int[] dir : directions) {
                int rd = row + dir[0];
                int cd = col + dir[1];
                int celld = rd * n + cd;
                
                if(rd < 0 || cd < 0 || rd >= m || cd >=n || parent[celld] == -1) continue;
                
                count += union(cellno, celld) ? -1 : 0;
            }
            
            ans.add(count);
        }
        
        return ans;
    }

    private int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        parent[x] = find(parent[x]);

        return parent[x];
    }

    private boolean union(int x, int y) {
        int lx = find(x);
        int ly = find(y);

        if (lx == ly) return false;

        if (rank[lx] > rank[ly]) {
            parent[ly] = lx;
        } else if (rank[ly] > rank[lx]) {
            parent[lx] = ly;
        } else {
            parent[ly] = lx;
            rank[lx] += 1;
        }

        return true;
    }
}

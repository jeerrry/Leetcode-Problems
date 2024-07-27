class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] distance = new int[n][n];
        int max = ((int)1e9);
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                distance[i][j] = i == j ? 0 : max;
            }
        }
        
        for(var edge : edges) {
            int src = edge[0];
            int tar = edge[1];
            int wt = edge[2];
            
            distance[src][tar] = wt;
            distance[tar][src] = wt;
        }
        
        for(int k = 0; k < n; k++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(distance[i][k] == max || distance[k][i] == max) continue;
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }
        
        int cntCity = n;
        int city = -1;
        
        for(int i=0; i<n; i++) {
            int cnt = 0;
            for(int j=0; j<n;j++) {
                if(distance[i][j] <= distanceThreshold) cnt++;
            }
            
            if(cnt <= cntCity) {
                cntCity = cnt;
                city = i;
            }
        }
        
        return city;
    }
}
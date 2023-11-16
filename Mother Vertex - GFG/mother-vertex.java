//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
            }
            Solution obj = new Solution();
            int ans = obj.findMotherVertex(V, adj);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends



class Solution
{
    //Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        int targetCount = 0;
        
        for(int i=0; i<V; i++) {
            if(visited[i]) continue;
            
            targetCount += dfs(adj, visited, stack, i);
        }
        
        int src = stack.pop();
        visited = new boolean[V];
        stack = new Stack<>();
        int result = dfs(adj, visited, stack, src);
        
        return stack.size() == V ? src : -1;
        
    }
    
    private int dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack, int src) {
        if(visited[src]) return 0;
        
        int count = 1;
        visited[src] = true;
        ArrayList<Integer> edges = adj.get(src);
        for(int tar : edges) {
            count += dfs(adj, visited, stack, tar);
        }
        
        stack.add(src);
        
        return count;
    }
}
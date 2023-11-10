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
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends




class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        // Code here
        Pair[] pairs = new Pair[nums.length];
        for(int i =0; i<nums.length; i++) {
            pairs[i] = new Pair(nums[i], i);
        }
        
        Arrays.sort(pairs);
        int swaps = 0;
        boolean[] visited = new boolean[nums.length];
        for(int i=0; i<nums.length; i++) {
            if(visited[i] || pairs[i].index == i) continue;
            
            int clen = 0;
            int j = i;
            while(!visited[j]) {
                visited[j] = true;
                j = pairs[j].index;
                clen++;
            }
            
            swaps += (clen - 1);
        }
        
        return swaps;
    }
    
    public static class Pair implements Comparable<Pair> {
        public int value;
        public int index;
        
        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
        
        public int compareTo(Pair p) {
            return this.value - p.value;
        }
    }
}
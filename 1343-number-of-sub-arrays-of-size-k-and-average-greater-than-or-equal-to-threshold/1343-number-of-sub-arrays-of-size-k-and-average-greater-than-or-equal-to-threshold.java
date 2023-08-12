class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int currentSum = 0;
        for(int i=0, j=0; j<arr.length;) {
            
            while(j - i < k) {
                currentSum += arr[j++];
            }
            
            count += currentSum/k >= threshold ? 1 : 0;
            currentSum -= arr[i++];
        }
        
        return count;
    }
}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<Integer>();
        int low = 0;
        int high = k-1;
        
        int i=k;
        while(i<arr.length) {
            if(Math.abs(arr[i] - x) < Math.abs(arr[low] - x) || arr[i] == arr[low]){
                low++;
                high++;
            }
            i++;
        }
        
        for(int j=low; j<=high; j++) {
            result.add(arr[j]);
        }
        
        return result;
    }
}
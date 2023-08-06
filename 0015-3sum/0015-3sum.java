class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<nums.length-2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            
            for(int j = i+1, k = nums.length - 1; j < k;){
                int val1 = nums[j];
                int val2 = nums[k];
                int val3 = nums[i];
                int sum = val1 + val2 + val3;
                if(sum == 0) {
                    var res = new ArrayList<Integer>();
                    res.add(val3);
                    res.add(val1);
                    res.add(val2);
                    result.add(res);
                    
                    while(j < k && nums[j] == nums[j+1]) j++;
                    while(j < k && nums[k] == nums[j-1]) k--;
                    
                    j++;
                    k--;
                    
                }else if (sum > 0){
                    k--;
                }else {
                    j++;
                }
            }
        }
        
        return result;
    }
}
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
  
        
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length - 3; i++) {
            int val1 = nums[i];
            
            if(i > 0 && val1 == nums[i-1]) continue;
            
            for(int j=i+1; j < nums.length - 2; j++) {
                int val2 = nums[j];
                
                if(j > i + 1 && val2 == nums[j-1]) continue;
                
                for(int k=j+1, l = nums.length-1; k < l;) {
                    int val3 = nums[k];
                    int val4 = nums[l];
                    
                    long diff = target - val1;
                    diff -= val2;
                    diff -= val3;
                    diff -= val4;
                    if(diff == 0) {
                        var res = new ArrayList<Integer>();
                        res.add(val1);
                        res.add(val2);
                        res.add(val3);
                        res.add(val4);
                        result.add(res);
                        
                        while(k < l && nums[k] == nums[k + 1])k++;
                        while(k < l && nums[l] == nums[l - 1])l--;
                        
                        k++;
                        l--;
                        
                    }else if(diff < 0){
                        l--;
                    }else{
                        k++;
                    }
                }
            }
        }
        return result;
    }
}
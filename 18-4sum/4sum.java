class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for(int i=0; i<n - 3; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j=i+1; j<n-2; j++) {
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                int k=j+1,l=n-1;
                while(k<l) {
                    long diff = target - nums[i];
                    diff -= nums[j];
                    diff -= nums[k];
                    diff -= nums[l];

                    if(diff == 0) {
                        var temp = new ArrayList<Integer>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);

                        result.add(temp);

                        while(k < l && nums[k] == nums[k + 1]) k++;
                        while(k < l && nums[l] == nums[l - 1]) l--;

                        k++;
                        l--;
                    }else if(diff < 0) {
                        l--;
                    }else {
                        k++;
                    }
                }
            }
        }

        return result;
    }
}
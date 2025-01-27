class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length -1);
    }

    private int mergeSort(int[] nums, int low, int high) {
        if(low >= high) return 0;

        int count = 0;
        int mid = (low + high) / 2;
        count += mergeSort(nums, low, mid);
        count += mergeSort(nums, mid + 1, high);
        count += countPairs(nums, low, mid, high);

        merge(nums, low, mid, high);

        return count;
    }

    private int countPairs(int[] nums, int low, int mid, int high) {
        int count = 0;
        int p2 = mid + 1;

        for(int p1 = low; p1 <= mid; p1++) {
            while(p2 <= high && nums[p1] > 2L * nums[p2]) p2++;
            count += (p2 - (mid + 1));
        }

        return count;
    }

    private void merge(int[] nums, int low, int mid, int high) {
        var temp = new ArrayList<Integer>();
        int p1 = low;
        int p2 = mid + 1;

        while(p1 <= mid && p2 <= high) {
            int val1 = nums[p1];
            int val2 = nums[p2];

            if(val1 <= val2) {
                temp.add(val1);
                p1++;
            }else {
                temp.add(val2);
                p2++;
            }
        }

        while(p1 <= mid) temp.add(nums[p1++]);
        while(p2 <= high) temp.add(nums[p2++]);

        for(int i=low; i<=high; i++) {
            nums[i] = temp.get(i - low);
        }
    }
}
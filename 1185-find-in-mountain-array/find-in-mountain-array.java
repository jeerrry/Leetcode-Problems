/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray arr) {
        int low = 0;
        int high = arr.length() - 1;

        while(low <= high) {
            int mid = (low + high) / 2;
            if(arr.get(mid) < arr.get(mid + 1)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        int peak = low;

        int index = search(arr, 0, peak, target);
        if(index == -1) {
            return search(arr, peak + 1, arr.length() - 1, target);
        }

        return index;
    }

    private int search(MountainArray arr, int low, int high, int target) {
        boolean isDesc = high == arr.length() - 1;

        while(low <= high) {
            int mid = (low + high) >> 1;
            if(arr.get(mid) == target) return mid;
            if(!isDesc) {
                if(arr.get(mid) > target) {
                    high = mid - 1;
                }else {
                    low = mid + 1;
                }
            }else {
                if(arr.get(mid) > target) {
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
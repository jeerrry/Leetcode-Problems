class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));

        var mergedList = new ArrayList<int[]>();
        mergedList.add(intervals[0]);

        for(int i=1; i<intervals.length; i++) {
            int lastIndex = mergedList.size() - 1;
            int[] last = mergedList.get(lastIndex);
            int[] current = intervals[i];
            if(last[1] >= current[0]) {
                last[1] = Math.max(last[1], current[1]);
                mergedList.set(lastIndex, last);
            }else {
                mergedList.add(current);
            }
        }

        var result = new int[mergedList.size()][2];
        for(int i=0; i<mergedList.size(); i++) {
            result[i] = mergedList.get(i);
        }

        return result;
    }
}
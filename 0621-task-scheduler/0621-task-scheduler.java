class Solution {

    public int leastInterval(char[] tasks, int n) {
        Queue<int[]> queue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        HashMap<Character, Integer> map = new HashMap<>();
        int[] freq = new int[26];

        for (char c : tasks) {
            freq[c - 'A'] += 1;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.add(freq[i]);
            }
        }

        int time = 0;
        while (pq.size() > 0 || queue.size() > 0) {
            time++;
            if (pq.size() > 0) {
                int task = pq.remove();
                if (task - 1 > 0) queue.add(new int[] { task - 1, time + n });
            }
            
            int[] val = queue.peek();
            if(val != null && time >= val[1]) {
                val = queue.remove();                
                if(val[0] > 0) pq.add(val[0]);
            }
        }

        return time;
    }
}

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        var deque = new ArrayDeque<Integer>();
        var result = new int[deck.length];

        Arrays.sort(deck);
        for(int i=0; i<deck.length; i++) deque.addLast(i);

        int i=0;
        while(!deque.isEmpty()) {
            int index = deque.removeFirst();
            result[index] = deck[i];

            if(!deque.isEmpty()) {
                deque.addLast(deque.removeFirst());
            }
            i++;
        }

        return result;
    }
}
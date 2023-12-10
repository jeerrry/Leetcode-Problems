class Twitter {
    private HashMap<Integer, HashSet<Integer>> users;
    private HashMap<Integer, List<int[]>> tweets;
    private int timeStamp;
    
    public Twitter() {
        users = new HashMap<>();
        tweets = new HashMap<>();
        timeStamp = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        authOrCreate(userId);
        
        var tweet = tweets.get(userId);
        tweet.add(new int[]{tweetId, timeStamp++});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if(!users.containsKey(userId)) return new ArrayList<Integer>();
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        
        HashSet<Integer> following = users.get(userId);
        
        for(Integer id : following) {
            var posts = tweets.get(id);
            pq.addAll(posts);
        }
        
        while(pq.size() > 10) {
            pq.remove();
        }
        
        List<Integer> result = new ArrayList<>();
        while(pq.size() > 0) result.add((pq.remove())[0]);
        
        Collections.reverse(result);
        
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        authOrCreate(followerId);
        authOrCreate(followeeId);
        
        HashSet<Integer> following = users.get(followerId);
        following.add(followeeId);
        
        users.put(followerId, following);
    }
    
    public void unfollow(int followerId, int followeeId) {
        boolean result = authOrCreate(followerId) && authOrCreate(followeeId);
        
        if(!result) return;
        
        HashSet<Integer> following = users.get(followerId);
        following.remove(followeeId);
        
        users.put(followerId, following);
    }
    
    private boolean authOrCreate(int userId) {
        if(!users.containsKey(userId)) {
            var followers = new HashSet<Integer>();
            followers.add(userId);
            users.put(userId, followers);
            tweets.put(userId, new ArrayList<int[]>());
            return false;
        }
        
        return true;
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
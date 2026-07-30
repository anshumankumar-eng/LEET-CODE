class Twitter {
    private static int timestamp = 0;
    private Map<Integer, Set<Integer>> followMap;
    private List<Tweet> tweets;

    private class Tweet {
        int userId;
        int tweetId;
        int time;
        Tweet(int userId, int tweetId, int time) {
            this.userId = userId;
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    public Twitter() {
        followMap = new HashMap<>();
        tweets = new ArrayList<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.add(new Tweet(userId, tweetId, timestamp++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> followed = followMap.getOrDefault(userId, new HashSet<>());
        Set<Integer> users = new HashSet<>(followed);
        users.add(userId);
        List<Integer> feed = new ArrayList<>();
        for (int i = tweets.size() - 1; i >= 0 && feed.size() < 10; i--) {
            Tweet t = tweets.get(i);
            if (users.contains(t.userId)) {
                feed.add(t.tweetId);
            }
        }
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
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
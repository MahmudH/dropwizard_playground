package com.mahmud.repositories;

import com.mahmud.api.TweetView;

import java.util.HashMap;
import java.util.Map;

public class TweetRepository {
    private Map<Long, String> tweet = new HashMap<>();

    public void create(TweetView tweetView) {
        tweet.put(tweetView.getId(), tweetView.getBody());
    }

    public TweetView find(long id) {
        if (tweet.containsKey(id)) {
            return new TweetView(id, tweet.get(id));
        }
        return null;
    }

    public void delete(long id) {
        tweet.remove(id);
    }

    public TweetView showAll() {
        if (tweet.size() > 0) {
            for (int i = 0; i < tweet.size(); i++) {
                return new TweetView(i, tweet.get(i));
            }
        }
        return null;
    }
}

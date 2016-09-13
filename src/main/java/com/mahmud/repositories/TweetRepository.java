package com.mahmud.repositories;

import com.mahmud.api.TweetView;
import com.mahmud.db.TweetDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TweetRepository {
    private Map<Long, String> tweet = new HashMap<>();
    private TweetDAO tweetDao;

    public TweetRepository(TweetDAO tweetDao) {
        this.tweetDao = tweetDao;
        tweetDao.ensureSchema();
    }

    public void create(TweetView tweetView) {
        tweet.put(tweetView.getId(), tweetView.getBody());
        tweetDao.insert(tweetView.getId(), tweetView.getBody());
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

    public List<TweetView> showAll() {
        List<TweetView> tweets = tweet.keySet()
                .stream()
                .map(id -> new TweetView(id, tweet.get(id)))
                .collect(Collectors.toList());
        return tweets;
    }
}

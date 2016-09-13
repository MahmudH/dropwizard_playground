package com.mahmud.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class TweetsView {
    private List<TweetView> tweets = new ArrayList<>();

    public TweetsView(List<TweetView> tweets) {
        this.tweets = tweets;
    }

    @JsonProperty
    public List<TweetView> getTweets() {
        return tweets;
    }
}

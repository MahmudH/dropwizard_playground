package com.mahmud.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TweetView {
    private long id;
    private String body;

    public TweetView() {
    }

    public TweetView(long id, String body) {
        this.id = id;
        this.body = body;
    }

    @JsonProperty
    public String getBody() {
        return body;
    }

    @JsonProperty
    public long getId() {
        return id;
    }
}

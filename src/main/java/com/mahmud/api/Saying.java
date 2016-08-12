package com.mahmud.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class Saying {
    private long id;

    @Length(max=3)
    private String content;

    public Saying(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Saying() {

    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}

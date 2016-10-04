package com.mahmud.resources;

import com.mahmud.api.TweetView;
import com.mahmud.repositories.TweetRepository;
import org.apache.commons.lang3.NotImplementedException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.NotFoundException;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TweetResourceTest {
    @Mock
    TweetRepository mockRepository;

    @Test
    public void whenTweetIsFound_shouldReturnTweet() throws Exception {
        when(mockRepository.find(1)).thenReturn(new TweetView(1, "foo bar baz"));
        TweetResource tweetResource = new TweetResource(mockRepository);

        TweetView tweetView = tweetResource.viewTweet(1);
        assertThat(tweetView.getBody(), equalTo("foo bar baz"));
    }

    @Test
    public void whenTweetIsNotFound_shouldThrowException() throws Exception {
        when(mockRepository.find(1)).thenReturn(null);

        TweetResource tweetResource = new TweetResource(mockRepository);

        try {
            TweetView tweetView = tweetResource.viewTweet(1);

            fail("expected NotFoundException");
        } catch (NotFoundException e) {
            // passed test
        }
    }

}
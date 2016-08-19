package com.mahmud.resources;

import com.mahmud.api.TweetView;
import com.mahmud.repositories.TweetRepository;

import javax.ws.rs.*;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/tweets")
public class TweetResource {
    private TweetRepository tweetRepository;

    public TweetResource(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    @POST
    @Consumes(APPLICATION_JSON)
    public void create(TweetView tweet) {
        tweetRepository.create(tweet);
    }

    @GET
    @Produces(APPLICATION_JSON)
    @Path("/{id}")
    public TweetView viewTweet(@PathParam("id") long id) {
        if (tweetRepository.find(id) != null) {
            return tweetRepository.find(id);
        }
        throw new NotFoundException();
    }

    @DELETE
    @Produces(APPLICATION_JSON)
    @Path("/{id}")
    public void deleteTweet(@PathParam("id") long id) {
        tweetRepository.delete(id);
    }


}

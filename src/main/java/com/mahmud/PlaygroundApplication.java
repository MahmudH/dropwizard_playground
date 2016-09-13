package com.mahmud;

import com.mahmud.db.TweetDAO;
import com.mahmud.health.TemplateHealthCheck;
import com.mahmud.repositories.TweetRepository;
import com.mahmud.resources.HelloWorldResource;
import com.mahmud.resources.TweetResource;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

public class PlaygroundApplication extends Application<PlaygroundConfiguration> {

    public static void main(String[] args) throws Exception {
        new PlaygroundApplication().run(args);
    }

    @Override
    public void run(PlaygroundConfiguration playgroundConfiguration, Environment environment) throws Exception {
        final HelloWorldResource resource = new HelloWorldResource(
                playgroundConfiguration.getTemplate(),
                playgroundConfiguration.getDefaultName()
        );
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, playgroundConfiguration.getDatabase(), "postgresql");
        final TweetDAO tweetDao = jdbi.onDemand(TweetDAO.class);

        TweetRepository tweetRepository = new TweetRepository(tweetDao);
        final TweetResource tweetResource = new TweetResource(tweetRepository);

        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(playgroundConfiguration.getTemplate());
        environment.healthChecks().register("template", healthCheck);

        environment.jersey().register(resource);
        environment.jersey().register(tweetResource);
    }
}

package com.mahmud;

import com.mahmud.health.TemplateHealthCheck;
import com.mahmud.resources.HelloWorldResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

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

        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(playgroundConfiguration.getTemplate());
        environment.healthChecks().register("template", healthCheck);

        environment.jersey().register(resource);
    }
}

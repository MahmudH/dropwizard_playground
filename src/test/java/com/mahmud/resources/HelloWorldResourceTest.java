package com.mahmud.resources;

import com.google.common.base.Optional;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class HelloWorldResourceTest {

    @Test
    public void should_returnName() {
        HelloWorldResource resource = new HelloWorldResource("foo %s", "bar");

        assertThat(resource.sayHello(Optional.absent()).getContent(), equalTo("Hello, bar!"));
    }
}
package conch3.server;

import com.google.common.base.Optional;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloConchResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public HelloConchResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

//    @GET
//    @Timed
//    public Feedback sayHello(@QueryParam("name") Optional<String> name) {
//        final String value = String.format(template, name.or(defaultName));
//        return new Feedback(counter.incrementAndGet(), value);
//    }
    
    @GET
    @Timed
    public Feedback giveResult(@QueryParam("command") Optional<String> command) {
        final String value = String.format("Oops, no results available. Not implemented yet ... Your command: %s", 
        		command.or(defaultName));
        return new Feedback(counter.incrementAndGet(), value);
    }
}
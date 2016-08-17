package conch3.server;

import com.google.common.base.Optional;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

import conch3.internal.ConchReplyFactory;

@Path("/conch")
@Produces(MediaType.APPLICATION_JSON)
public class ConchResource {
    private final String template;
    private final String defaultReply;

    public ConchResource(String template, String defaultReply) {
        this.template = template;
        this.defaultReply = defaultReply;
    }
    
    @GET
    @Timed
    public AbstractReply giveResult(@QueryParam("command") Optional<String> command) {
        if (!command.isPresent()) {
        	return new AbstractReply(defaultReply); // Return help information.
        } else {
        	// The factory generates correct reply based on content of <command> 
        	return ConchReplyFactory.GetConchReply(command.get());
        }
    }
}
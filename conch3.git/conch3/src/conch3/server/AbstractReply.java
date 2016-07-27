package conch3.server;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class AbstractReply {
    private long id;

    @Length(max = 300)
    private String content;

    public AbstractReply() {
        // Jackson deserialization
    }

    public AbstractReply(String message) {
        this.content = message;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}
package conch3.server;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class Feedback {
    private long id;

    @Length(max = 3)
    private String content;

    public Feedback() {
        // Jackson deserialization
    }

    public Feedback(long id, String content) {
        this.id = id;
        this.content = content;
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
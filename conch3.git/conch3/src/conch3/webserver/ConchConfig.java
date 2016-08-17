package conch3.server;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class ConchConfig extends Configuration {
    @NotEmpty
    private String template;
    
    @NotEmpty
    private String defaultReply;

    @JsonProperty
    public String getTemplate() {
        return template;
    }

    @JsonProperty
    public void setTemplate(String template) {
        this.template = template;
    }

    @JsonProperty
	public String getDefaultReply() {
		return defaultReply;
	}

    @JsonProperty
	public void setDefaultReply(String defaultReply) {
		this.defaultReply = defaultReply;
	}    
}
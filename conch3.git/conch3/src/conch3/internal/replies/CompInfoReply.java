package conch3.internal.replies;

import conch3.webserver.AbstractReply;

public class CompInfoReply extends AbstractReply {
	public CompInfoReply(String[] params) {
		setContent("rep_" + params[0] + " content_not_defined");
	}
}

package conch3.internal;

import conch3.server.AbstractReply;

/**
 * Factory class to generate correct subclass of AbstractReply based on command
 * content.
 * @author Teng Long(mbrfail@gmail.com)
 *
 */
public class ConchReplyFactory {
	public static AbstractReply GetConchReply(String command) {
		return new AbstractReply(
				"Reply for this command is not implemented yet.");
	}
}

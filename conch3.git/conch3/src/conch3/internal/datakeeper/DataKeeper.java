package conch3.internal.datakeeper;

/**
 * Singleton class that manages data storage and query. It has the following
 * features:
 * 
 *  1) Loads data (exclude test records) into memory while booting up
 *  2) Backs up data periodically to storage
 *  3) Runs a thread pool for query 
 */
public class DataKeeper {
	private static DataKeeper instance = null;
	
	private DataKeeper() {
		// TODO(tlongcn): Loads data, starts query thread and backup thread	
	}
	
	public static DataKeeper get() {
		if (instance == null) {
			instance = new DataKeeper();
		}
		return instance;
	}
}

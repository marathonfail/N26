package core;

/**
 * 
 * @author sridhar
 * 
 *         StatisticsManager that aggregates transactions and provides access
 * 
 */
public interface StatisticsManager {

    /**
     * 
     * @return Aggregated statistics about the transactions in the past 60
     *         seconds or configured time interval.
     */
    public Statistics getStatistics();
}

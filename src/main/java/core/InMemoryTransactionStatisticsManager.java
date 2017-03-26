package core;

/**
 * 
 * @author sridhar
 *
 *         InMemoryTransactionStatisticsManager implements both
 *         TransactionManager and StatisticsManager and aggregates the
 *         transactions into useful
 */

public class InMemoryTransactionStatisticsManager implements StatisticsManager, TransactionManager {

    private int aggregationPeriod;
    
    /**
     * 
     * @param aggregationPeriod aggregationPeriod in milliseconds
     */
    public InMemoryTransactionStatisticsManager(int aggregationPeriod) {
         this.aggregationPeriod = aggregationPeriod;
    }

    @Override
    public void addTransaction(Transaction tx) {
        
    }

    @Override
    public Statistics getStatistics() {
        return null;
    }

}

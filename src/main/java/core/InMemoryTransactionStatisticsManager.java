package core;

import java.util.Hashtable;
import java.util.Map;
import java.util.stream.IntStream;

import utils.Pair;

/**
 * 
 * @author sridhar
 *
 *         InMemoryTransactionStatisticsManager implements both
 *         TransactionManager and StatisticsManager and aggregates the
 *         transactions into useful statistics
 */

public class InMemoryTransactionStatisticsManager implements StatisticsManager, TransactionManager {

    private int aggregationPeriod;

    /*
     * Data structure to hold aggregated statistics
     * 
     * Key is the second(time) Value is a pair containing the aggregated
     * statistics for that second. The second value in the pair specifies what
     * is the time upto minute)
     * 
     * So, if the aggregation period is 60 seconds, we will at the most have 60
     * values in this map.
     */

    Map<Long, Pair<Statistics, Long>> database;

    /**
     * 
     * @param aggregationPeriod
     *            aggregationPeriod in milliseconds
     */
    public InMemoryTransactionStatisticsManager(int aggregationPeriod) {
        this.aggregationPeriod = aggregationPeriod;
        database = new Hashtable<Long, Pair<Statistics, Long>>();
    }

    @Override
    public synchronized boolean addTransaction(Transaction tx) {
        boolean added = false;
        if (tx != null) {
            long currentTime = System.currentTimeMillis();
            if (tx.timestamp < (currentTime - aggregationPeriod)) {
                // ignore
            } else {
                long second = ((tx.timestamp / 1000) % 60);
                long minute = (tx.timestamp / (60 * 1000));
                long hour = (tx.timestamp / (60 * 60 * 1000)) % (24);
                System.out.println(" minute: " + minute + ", second: " + second + ", " + tx.timestamp);
                Pair<Statistics, Long> existing = null;
                if (database.containsKey(second)) {
                    existing = database.get(second);
                }
                if (existing == null) {
                    Statistics st = new Statistics();
                    st.set(tx);
                    existing = new Pair<Statistics, Long>(st, minute);
                    database.put(second, existing);
                } else {
                    if (existing.getSecond() != minute) {
                        Statistics st = new Statistics();
                        st.set(tx);
                        Pair<Statistics, Long> newStatistic = new Pair<Statistics, Long>(st, minute);
                        database.put(second, newStatistic);
                    } else {
                        Statistics st = existing.getFirst();
                        st.combine(tx);
                        existing.setSecond(minute);
                        database.put(second, existing);
                    }
                }
                added = true;
            }
            System.out.println(database);
        }
        return added;
    }

    @Override
    public Statistics getStatistics() {
        long second = ((System.currentTimeMillis() / 1000) % 60);
        long minute = (System.currentTimeMillis() / (60 * 1000));
        long currentTime = second + minute * 60;
        final Statistics result = new Statistics();
        // Maximum 60 iterations
        database.forEach((k, v) -> {
            long thenTime = k + v.getSecond() * 60;
            System.out.println("Current time: " + currentTime + ", then Time: " + thenTime);
            if (thenTime > (currentTime - 60)) {
                if (result.count == 0) {
                    result.set(v.getFirst());
                } else {
                    result.combine(v.getFirst());
                }
            }
        });
        return result;
    }
}

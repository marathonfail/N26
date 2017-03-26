package core;

import org.junit.Before;
import org.junit.Test;

public class InMemoryTransactionStatisticsManagerTest {

    public InMemoryTransactionStatisticsManager manager;

    @Before
    public void setup() {
        manager = new InMemoryTransactionStatisticsManager(60000);
    }

    @Test
    public void testAddTransaction() {
        Transaction tx = new Transaction();
        tx.amount = 10.0;
        tx.timestamp = System.currentTimeMillis() - 1000;
        assert (manager.addTransaction(tx));

        tx.timestamp = System.currentTimeMillis() - 120000;
        assert (manager.addTransaction(tx) == false);
        /*
         * Statistics st = manager.getStatistics(); assert (st.count == 1);
         * assert (st.avg == 10.0); assert (st.max == 10.0); assert (st.min ==
         * 10.0); assert (st.sum == 10.0);
         */
    }
}

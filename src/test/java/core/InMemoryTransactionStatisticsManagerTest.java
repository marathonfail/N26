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
        long thisTime = System.currentTimeMillis() - 1000;
        tx.setAmount(10.0);
        tx.setTimestamp(thisTime);
        assert (manager.addTransaction(tx));

        tx.setTimestamp(System.currentTimeMillis() - 6000);
        tx.setAmount(12);
        assert (manager.addTransaction(tx));

        Statistics st = manager.getStatistics();
        System.out.println(st);
        assert (st.getCount() == 2);
        assert (st.getAvg() == 11.0);
        assert (st.getMax() == 12.0);
        assert (st.getMin() == 10.0);
        assert (st.getSum() == 22.0);

        tx.setTimestamp(System.currentTimeMillis() - 61000);
        tx.setAmount(12);
        assert (manager.addTransaction(tx) == false);

    }
}

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
        tx.amount = 10.0;
        tx.timestamp = thisTime;
        assert (manager.addTransaction(tx));

        tx.timestamp = System.currentTimeMillis() - 6000;
        tx.amount = 12;
        assert (manager.addTransaction(tx));

        Statistics st = manager.getStatistics();
        System.out.println(st);
        assert (st.count == 2);
        assert (st.avg == 11.0);
        assert (st.max == 12.0);
        assert (st.min == 10.0);
        assert (st.sum == 22.0);

        tx.timestamp = System.currentTimeMillis() - 61000;
        tx.amount = 12;
        assert (manager.addTransaction(tx) == false);

        try {
            Thread.sleep(56000);
        } catch (Exception e) {

        }
        st = manager.getStatistics();
        System.out.println(st);
        assert (st.count == 1);
        assert (st.avg == 10.0);
        assert (st.max == 10.0);
        assert (st.min == 10.0);
        assert (st.sum == 10.0);

        tx.amount = 12;
        tx.timestamp = thisTime;
        assert (manager.addTransaction(tx));
        st = manager.getStatistics();
        System.out.println(st);
        assert (st.count == 2);
        assert (st.avg == 11.0);
        assert (st.max == 12.0);
        assert (st.min == 10.0);
        assert (st.sum == 22.0);

    }
}

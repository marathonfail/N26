package core;

/**
 * 
 * @author sridhar
 *
 *         TransactionManager interface to implement
 *
 */
public interface TransactionManager {

    /**
     * Add transaction to the database
     * 
     * @param tx
     *            Transaction to be added
     */
    public void addTransaction(Transaction tx);
}

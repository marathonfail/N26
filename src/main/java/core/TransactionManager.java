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
     * 
     * @return whether the transaction was added to the database
     */
    public boolean addTransaction(Transaction tx);
}

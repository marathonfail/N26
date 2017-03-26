package core;

/**
 * 
 * @author sridhar
 *
 *         Model that defines a transaction
 */
public class Transaction {
    @Override
    public String toString() {
        return "Transaction [amount=" + amount + ", timestamp=" + timestamp + "]";
    }

    /**
     * amount - transaction amount
     */
    public double amount;

    /**
     * When the transaction was added
     */
    public long timestamp;
}

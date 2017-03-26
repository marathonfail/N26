package core;

import com.google.gson.Gson;

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
    private double amount;

    /**
     * When the transaction was added
     */
    private long timestamp;

    public static Transaction fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Transaction.class);
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}

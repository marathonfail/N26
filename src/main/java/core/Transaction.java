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
    public double amount;

    /**
     * When the transaction was added
     */
    public long timestamp;

    public static Transaction fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Transaction.class);
    }
}

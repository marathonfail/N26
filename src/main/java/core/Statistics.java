package core;

/**
 * 
 * @author sridhar
 *
 *         Model for statistics
 */
public class Statistics {

    /**
     * A double specifying the total sum of transaction value in the last 60
     * seconds.
     */
    public double sum;

    /**
     * A double specifying the average amount of transaction value in the last
     * 60 seconds.
     */
    public double avg;

    /**
     * A double specifying the max value of transaction in the last 60 seconds.
     */
    public double max;

    /**
     * A double specifying the min value of transaction in the last 60 seconds.
     */
    public double min;

    /**
     * An integer specifying the total number of transactions in the last 60
     * seconds.
     */
    public double count;

    /**
     * Combine the given transaction into the current statistic
     * 
     * @param tx
     */
    public void combine(Transaction tx) {
        this.sum += tx.amount;
        this.max = Math.max(tx.amount, this.max);
        this.avg = (this.avg * this.count + tx.amount) / (this.count + 1);
        this.min = Math.min(tx.amount, this.min);
        this.count += 1;
    }

    @Override
    public String toString() {
        return "Statistics [sum=" + sum + ", avg=" + avg + ", max=" + max + ", min=" + min + ", count=" + count + "]";
    }

    public void set(Transaction tx) {
        this.sum = tx.amount;
        this.count = 1;
        this.avg = tx.amount;
        this.min = tx.amount;
        this.max = tx.amount;
    }

    public void set(Statistics st) {
        this.sum = st.sum;
        this.count = st.count;
        this.avg = st.avg;
        this.max = st.max;
        this.min = st.min;
    }

    public void combine(Statistics st) {
        this.sum += st.sum;
        this.avg = ((this.avg * this.count) + (st.avg * st.count)) / (this.count + st.count);
        this.count += st.count;
        this.max = Math.max(this.max, st.max);
        this.min = Math.min(this.min, st.min);
    }
}

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
    private double sum;

    /**
     * A double specifying the average amount of transaction value in the last
     * 60 seconds.
     */
    private double avg;

    /**
     * A double specifying the max value of transaction in the last 60 seconds.
     */
    private double max;

    /**
     * A double specifying the min value of transaction in the last 60 seconds.
     */
    private double min;

    /**
     * An integer specifying the total number of transactions in the last 60
     * seconds.
     */
    private double count;

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    /**
     * Combine the given transaction into the current statistic
     * 
     * @param tx
     */
    public void combine(Transaction tx) {
        this.sum += tx.getAmount();
        this.max = Math.max(tx.getAmount(), this.max);
        this.avg = (this.avg * this.count + tx.getAmount()) / (this.count + 1);
        this.min = Math.min(tx.getAmount(), this.min);
        this.count += 1;
    }

    @Override
    public String toString() {
        return "Statistics [sum=" + sum + ", avg=" + avg + ", max=" + max + ", min=" + min + ", count=" + count + "]";
    }

    public void set(Transaction tx) {
        this.sum = tx.getAmount();
        this.count = 1;
        this.avg = tx.getAmount();
        this.min = tx.getAmount();
        this.max = tx.getAmount();
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

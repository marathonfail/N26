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
}

package utils;

public class Pair<F, S> {

    private F first;
    private S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public F getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }

    public void setSecond(S s) {
        this.second = s;
    }

    public void setFirst(F f) {
        this.first = f;
    }

    @Override
    public String toString() {
        return "Pair [first=" + first + ", second=" + second + "]";
    }

}

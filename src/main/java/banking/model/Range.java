package banking.model;

public class Range {

    private final double min;
    private final double rate;

    public Range( double min,double rate) {
        this.min = min;
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }

    public double getMin() {
        return min;
    }

    public boolean contains(long number){
        return(number>=min);
    }
}

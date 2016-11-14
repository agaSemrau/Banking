package banking.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(Range.class)
@Table(name = "ranges")
public class Range implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "definition_name")
    private RangedInvestmentDefinition definition;

    @Id
    @Column(name = "minimum")
    private double min;

    private double rate;

    public Range() {
    }

    public Range(double min, double rate) {
        this.min = min;
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }

    public double getMin() {
        return min;
    }

    public boolean contains(long number) {
        return (number >= min);
    }
}

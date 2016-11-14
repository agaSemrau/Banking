package banking.model;

import java.io.Serializable;

public class RangePK implements Serializable{

    protected RangedInvestmentDefinition definition;
    protected double min;

    public RangePK(){}

    public RangePK(RangedInvestmentDefinition definition, double min) {
        this.definition = definition;
        this.min = min;
    }

    public RangedInvestmentDefinition getDefinition() {
        return definition;
    }

    public double getMin() {
        return min;
    }
}

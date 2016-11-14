package banking.model;

public enum InvestmentPeriod {
    ONE_MONTH(1), THREE_MONTHS(3), SIX_MONTHS(6);

    private int period;

    InvestmentPeriod(int numVal) {
        this.period = numVal;
    }

    public int getNumVal() {
        return period;
    }
}

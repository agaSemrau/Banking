package banking.model;

public enum InvestmentTime {
    ONE_MONTH(1), THREE_MONTHS(3), SIX_MONTHS(6);

    private int numVal;

    InvestmentTime(int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    }
}

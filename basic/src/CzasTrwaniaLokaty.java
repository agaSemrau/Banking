package src;

public enum CzasTrwaniaLokaty {
    ONE_MONTH(1), THREE_MONTHS(3), SIX_MONTHS(6);

    private int numVal;

    CzasTrwaniaLokaty(int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    }
}

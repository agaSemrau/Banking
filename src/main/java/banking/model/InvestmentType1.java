package banking.model;


public class InvestmentType1 extends Investment{
    double oprocentowanie = 0.025;

    public InvestmentType1(String walutaLokaty, long numerKontaLokaty, int czasTrwaniaLokaty, long kwotaLokaty, String dataZalozeniaLokaty) {
        super(walutaLokaty, numerKontaLokaty, czasTrwaniaLokaty, kwotaLokaty, dataZalozeniaLokaty);
    }

    public double getOprocentowanie() {
        return oprocentowanie;
    }

    @Override
    public String toString() {
        return "InvestmentType1{" +
                "oprocentowanie=" + oprocentowanie +
                '}';
    }
}

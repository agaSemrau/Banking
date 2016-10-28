package banking.model;


public class InvestmentType3 extends Investment{
    double oprocentowanie = 0.01;
    public InvestmentType3(String walutaLokaty, long numerKontaLokaty, int czasTrwaniaLokaty, long kwotaLokaty, String dataZalozeniaLokaty) {
        super(walutaLokaty, numerKontaLokaty, czasTrwaniaLokaty, kwotaLokaty, dataZalozeniaLokaty);
    }

    public double getOprocentowanie() {
        return oprocentowanie;
    }

    @Override
    public String toString() {
        return "InvestmentType3{" +
                "oprocentowanie=" + oprocentowanie +
                '}';
    }
}

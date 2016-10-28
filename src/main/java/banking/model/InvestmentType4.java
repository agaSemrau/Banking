package banking.model;


public class InvestmentType4 extends Investment{
    double oprocentowanie = 0.015;
    public InvestmentType4(String walutaLokaty, long numerKontaLokaty, int czasTrwaniaLokaty, long kwotaLokaty, String dataZalozeniaLokaty) {
        super(walutaLokaty, numerKontaLokaty, czasTrwaniaLokaty, kwotaLokaty, dataZalozeniaLokaty);

    }

    public double getOprocentowanie() {
        return oprocentowanie;
    }
}

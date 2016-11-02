package banking.model;


public class InvestmentType1 extends Investment {
    private double oprocentowanie = 0.025;

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
                " waluta lokaty=" + getWalutaLokaty() +
                " numer konta lokaty=" + getNumerKontaLokaty() +
                " czas trwania lokaty=" + getCzasTrwaniaLokaty() +
                " kwota lokaty=" + getKwotaLokaty() +
                " data założenia lokaty=" + getDataZalozeniaLokaty() +
                '}';
    }
}

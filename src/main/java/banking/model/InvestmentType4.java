package banking.model;


public class InvestmentType4 extends Investment {
    private double oprocentowanie = 0.015;

    public InvestmentType4(String walutaLokaty, long numerKontaLokaty, int czasTrwaniaLokaty, long kwotaLokaty, String dataZalozeniaLokaty) {
        super(walutaLokaty, numerKontaLokaty, czasTrwaniaLokaty, kwotaLokaty, dataZalozeniaLokaty);

    }

    public double getOprocentowanie() {
        return oprocentowanie;
    }

    @Override
    public String toString() {
        return "InvestmentType4{" +
                "oprocentowanie=" + oprocentowanie +
                " waluta lokaty=" + getWalutaLokaty() +
                " numer konta lokaty=" + getNumerKontaLokaty() +
                " czas trwania lokaty=" + getCzasTrwaniaLokaty() +
                " kwota lokaty=" + getKwotaLokaty() +
                " data założenia lokaty=" + getDataZalozeniaLokaty() +
                '}';
    }
}

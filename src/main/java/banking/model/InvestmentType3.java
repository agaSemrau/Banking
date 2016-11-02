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
                " waluta lokaty=" + getWalutaLokaty() +
                " numer konta lokaty=" + getNumerKontaLokaty()+
                " czas trwania lokaty=" + getCzasTrwaniaLokaty()+
                " kwota lokaty=" + getKwotaLokaty()+
                " data założenia lokaty=" + getDataZalozeniaLokaty()+
                '}';
    }
}

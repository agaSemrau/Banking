package banking.model;


public class InvestmentType2 extends Investment{
    double oprocentowanie = 0.02;
    public InvestmentType2(String walutaLokaty, long numerKontaLokaty, int czasTrwaniaLokaty, long kwotaLokaty, String dataZalozeniaLokaty) {
        super(walutaLokaty, numerKontaLokaty, czasTrwaniaLokaty, kwotaLokaty, dataZalozeniaLokaty);

    }

    @Override
    public String toString() {
        return "InvestmentType2{" +
                "oprocentowanie=" + oprocentowanie +
                " waluta lokaty=" + getWalutaLokaty() +
                " numer konta lokaty=" + getNumerKontaLokaty()+
                " czas trwania lokaty=" + getCzasTrwaniaLokaty()+
                " kwota lokaty=" + getKwotaLokaty()+
                " data założenia lokaty=" + getDataZalozeniaLokaty()+
                '}';
    }
}

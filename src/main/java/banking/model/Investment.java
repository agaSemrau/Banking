package banking.model;


import java.util.Date;

public class Investment {

    private Currency walutaLokaty;
    private long numerKontaLokaty;
    private InvestmentPeriod czasTrwaniaLokaty;
    private double kwotaLokaty;
    private Date dataZalozeniaLokaty;
    private double rate;
    private long clientPesel;

    public Investment(Currency walutaLokaty, long numerKontaLokaty,
                      InvestmentPeriod czasTrwaniaLokaty,
                      double kwotaLokaty, Date dataZalozeniaLokaty, double rate, long clientPesel) {
        this.czasTrwaniaLokaty = czasTrwaniaLokaty;
        this.numerKontaLokaty = numerKontaLokaty;
        this.walutaLokaty = walutaLokaty;
        this.numerKontaLokaty = numerKontaLokaty;
        this.czasTrwaniaLokaty = czasTrwaniaLokaty;
        this.kwotaLokaty = kwotaLokaty;
        this.dataZalozeniaLokaty = dataZalozeniaLokaty;
        this.rate = rate;
        this.clientPesel = clientPesel;
    }

    @Override
    public String toString() {
        return "Investment{" +
                "walutaLokaty='" + walutaLokaty + '\'' +
                ", numerKontaLokaty=" + numerKontaLokaty +
                ", czasTrwaniaLokaty=" + czasTrwaniaLokaty +
                ", kwotaLokaty=" + kwotaLokaty +
                ", dataZalozeniaLokaty=" + dataZalozeniaLokaty +
                ", oprocentowanie=" + rate +
                ", pesel klienta=" + clientPesel +
                '}';
    }

    public Currency getWalutaLokaty() {
        return walutaLokaty;
    }

    public long getNumerKontaLokaty() {
        return numerKontaLokaty;
    }

    public InvestmentPeriod getCzasTrwaniaLokaty() {
        return czasTrwaniaLokaty;
    }

    public double getKwotaLokaty() {
        return kwotaLokaty;
    }

    public Date getDataZalozeniaLokaty() {
        return dataZalozeniaLokaty;
    }

    public double getRate() {
        return rate;
    }

    public long getClientPesel() {
        return clientPesel;
    }
}

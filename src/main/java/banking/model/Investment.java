package banking.model;


import banking.controller.Uslugi;

public class Investment implements Uslugi {

    private String walutaLokaty;
    private long numerKontaLokaty;
    private int czasTrwaniaLokaty;
    private double oprocentowanie;
    private long kwotaLokaty;
    private String dataZalozeniaLokaty;

    public Investment(String walutaLokaty, long numerKontaLokaty,
                      int czasTrwaniaLokaty, double oprocentowanie,
                      long kwotaLokaty, String dataZalozeniaLokaty) {
        this.oprocentowanie = oprocentowanie;
        this.czasTrwaniaLokaty = czasTrwaniaLokaty;
        this.numerKontaLokaty = numerKontaLokaty;
        this.walutaLokaty = walutaLokaty;
        this.numerKontaLokaty = numerKontaLokaty;
        this.czasTrwaniaLokaty = czasTrwaniaLokaty;
        this.kwotaLokaty = kwotaLokaty;
        this.dataZalozeniaLokaty = dataZalozeniaLokaty;
    }

    @Override
    public String toString() {
        return "Investment{" +
                ", walutaLokaty='" + walutaLokaty + '\'' +
                ", numerKontaLokaty=" + numerKontaLokaty +
                ", czasTrwaniaLokaty=" + czasTrwaniaLokaty +
                ", oprocentowanie=" + oprocentowanie +
                ", kwotaLokaty=" + kwotaLokaty +
                ", dataZalozeniaLokaty=" + dataZalozeniaLokaty +
                '}';
    }


}

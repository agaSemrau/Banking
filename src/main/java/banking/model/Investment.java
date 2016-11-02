package banking.model;


public abstract class Investment {

    private String walutaLokaty;
    private long numerKontaLokaty;
    private int czasTrwaniaLokaty;
    private long kwotaLokaty;
    private String dataZalozeniaLokaty;

    public Investment(String walutaLokaty, long numerKontaLokaty,
                      int czasTrwaniaLokaty,
                      long kwotaLokaty, String dataZalozeniaLokaty) {
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
                ", kwotaLokaty=" + kwotaLokaty +
                ", dataZalozeniaLokaty=" + dataZalozeniaLokaty +
                '}';
    }


}

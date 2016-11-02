package banking.model;


public class Account {
    private String waluta;
    private long numerKonta;


    public Account(String waluta, long numerKonta) {
        this.waluta = waluta;
        this.numerKonta = numerKonta;
    }

    public String getWaluta() {
        return waluta;
    }
    public long getNumerKonta() {
        return numerKonta;
    }


    @Override
    public String toString() {
        return "Account{" +
                "waluta='" + waluta + '\'' +
                ", numerKonta=" + numerKonta +
                '}';
    }
}


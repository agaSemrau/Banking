package banking.model;


public class Account {
    private Currency waluta;
    private long numerKonta;
    private long clientPesel;


    public Account(Currency waluta, long numerKonta, long clientPesel) {
        this.waluta = waluta;
        this.numerKonta = numerKonta;
        this.clientPesel = clientPesel;
    }

    public Currency getWaluta() {
        return waluta;
    }
    public long getNumerKonta() {
        return numerKonta;
    }
    public long getClientPesel() {
        return clientPesel;
    }

    @Override
    public String toString() {
        return "Account{" +
                "waluta='" + waluta + '\'' +
                ", numerKonta=" + numerKonta +
                ", pesel kilenta=" + clientPesel +
                '}';
    }
}


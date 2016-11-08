package banking.model;


public class Account {
    private Currency currency;
    private long accountNumber;
    private long clientPesel;
    private double balance;


    public Account(Currency currency, long accountNumber, long clientPesel, double balance) {
        this.currency = currency;
        this.accountNumber = accountNumber;
        this.clientPesel = clientPesel;
        this.balance = balance;
    }

    public Currency getCurrency() {
        return currency;
    }
    public long getAccountNumber() {
        return accountNumber;
    }
    public long getClientPesel() {
        return clientPesel;
    }
    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "currency='" + currency + '\'' +
                ", accountNumber=" + accountNumber +
                ", pesel kilenta=" + clientPesel +
                ", saldo=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (accountNumber != account.accountNumber) return false;
        if (clientPesel != account.clientPesel) return false;
        if (Double.compare(account.balance, balance) != 0) return false;
        return currency == account.currency;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = currency.hashCode();
        result = 31 * result + (int) (accountNumber ^ (accountNumber >>> 32));
        result = 31 * result + (int) (clientPesel ^ (clientPesel >>> 32));
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}


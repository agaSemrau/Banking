package banking.model;

import javax.persistence.*;

@Entity
@Table(name="accounts")
public class Account {

    @Enumerated(value = EnumType.STRING)
    @Column(name = "currency",nullable = false)
    private Currency currency;

    @Id
    @Column(name = "number")
    private long accountNumber;

    @ManyToOne
    @JoinColumn(name = "pesel")
    private Client client;

    @Column(name = "balance",nullable = false)
    private double balance;

    public Account(){}

    public Account(Currency currency, long accountNumber, Client client, double balance) {
        this.currency = currency;
        this.accountNumber = accountNumber;
        this.client = client;
        this.balance = balance;
    }

    public Currency getCurrency() {
        return currency;
    }
    public long getAccountNumber() {
        return accountNumber;
    }
    public Client getClient() {
        return client;
    }
    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "currency='" + currency + '\'' +
                ", accountNumber=" + accountNumber +
                ", klient=" + client +
                ", saldo=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (accountNumber != account.accountNumber) return false;
        if (Double.compare(account.balance, balance) != 0) return false;
        if (currency != account.currency) return false;
        return client.equals(account.client);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = currency.hashCode();
        result = 31 * result + (int) (accountNumber ^ (accountNumber >>> 32));
        result = 31 * result + client.hashCode();
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}


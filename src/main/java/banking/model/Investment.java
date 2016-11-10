package banking.model;


import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="deposits")
public class Investment {

    @Column(name = "currency",nullable = false)
    private Currency currency;

   @Id
    private long accountNumber;

    @Column(name = "period",nullable = false)
    private InvestmentPeriod investmentPeriod;

    @Column(name = "balance",nullable = false)
    private double amount;

    @Column(name = "opening_date",nullable = false)
    private Date openingDate;

    @Column(name = "rate",nullable = false)
    private double rate;

    @ManyToOne
    private Client client;

    public Investment(){}

    public Investment(Currency currency, long accountNumber,
                      InvestmentPeriod investmentPeriod,
                      double kwotaLokaty, Date openingDate, double rate, Client client) {
        this.investmentPeriod = investmentPeriod;
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.accountNumber = accountNumber;
        this.investmentPeriod = investmentPeriod;
        this.amount = kwotaLokaty;
        this.openingDate = openingDate;
        this.rate = rate;
        this.client = client;
    }

    @Override
    public String toString() {
        return "Investment{" +
                "currency='" + currency + '\'' +
                ", accountNumber=" + accountNumber +
                ", investmentPeriod=" + investmentPeriod +
                ", kwotaLokaty=" + amount +
                ", openingDate=" + openingDate +
                ", oprocentowanie=" + rate +
                ", klient=" + client +
                '}';
    }

    public Currency getCurrency() {
        return currency;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public InvestmentPeriod getInvestmentPeriod() {
        return investmentPeriod;
    }

    public double getKwotaLokaty() {
        return amount;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public double getRate() {
        return rate;
    }

    public Client getClient() {
        return client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Investment that = (Investment) o;

        if (accountNumber != that.accountNumber) return false;
        if (Double.compare(that.amount, amount) != 0) return false;
        if (Double.compare(that.rate, rate) != 0) return false;
        if (currency != that.currency) return false;
        if (investmentPeriod != that.investmentPeriod) return false;
        if (!openingDate.equals(that.openingDate)) return false;
        return client.equals(that.client);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = currency.hashCode();
        result = 31 * result + (int) (accountNumber ^ (accountNumber >>> 32));
        result = 31 * result + investmentPeriod.hashCode();
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + openingDate.hashCode();
        temp = Double.doubleToLongBits(rate);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + client.hashCode();
        return result;
    }
}

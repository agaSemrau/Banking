package banking.model;


import java.util.Date;

public class Investment {

    private Currency currency;
    private long accountNumber;
    private InvestmentPeriod investmentPeriod;
    private double amount;
    private Date openingDate;
    private double rate;
    private long clientPesel;

    public Investment(Currency currency, long accountNumber,
                      InvestmentPeriod investmentPeriod,
                      double kwotaLokaty, Date openingDate, double rate, long clientPesel) {
        this.investmentPeriod = investmentPeriod;
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.accountNumber = accountNumber;
        this.investmentPeriod = investmentPeriod;
        this.amount = kwotaLokaty;
        this.openingDate = openingDate;
        this.rate = rate;
        this.clientPesel = clientPesel;
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
                ", pesel klienta=" + clientPesel +
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

    public long getClientPesel() {
        return clientPesel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Investment that = (Investment) o;

        if (accountNumber != that.accountNumber) return false;
        if (Double.compare(that.amount, amount) != 0) return false;
        if (Double.compare(that.rate, rate) != 0) return false;
        if (clientPesel != that.clientPesel) return false;
        if (currency != that.currency) return false;
        if (investmentPeriod != that.investmentPeriod) return false;
        return openingDate.equals(that.openingDate);

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
        result = 31 * result + (int) (clientPesel ^ (clientPesel >>> 32));
        return result;
    }
}

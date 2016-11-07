package banking.model;


public enum Currency {
    PLN ("PLN"), EUR("EUR"), USD ("USD");

    private String currency;

    Currency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }
}

package banking.model;

import javax.activation.DataSource;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "clients")
public class Client  {

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "surname",nullable = false)
    private String surname;

    @Id
    private long pesel;

    @Transient
    private List<Account> accountsList = new ArrayList<Account>();

    @Transient
    private List<Investment> investmentsList = new ArrayList<Investment>();

    public Client(){}

    public Client(String name, String surname, long pesel) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
    }


    public long getPesel() {
        return pesel;
    }

    public List<Account> getAccountsList() {
        return accountsList;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }


    public void setAccountsList(List<Account> accountsList) {
        this.accountsList = accountsList;
    }

    public void setInvestmentsList(List<Investment> investmentsList) {
        this.investmentsList = investmentsList;
    }

    public List<Investment> getInvestmentsList() {
        return investmentsList;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", pesel=" + pesel +
                ", accountsList=" + accountsList +
                ", investmentsList=" + investmentsList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (pesel != client.pesel) return false;
        if (!name.equals(client.name)) return false;
        return surname.equals(client.surname);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + (int) (pesel ^ (pesel >>> 32));
        return result;
    }
}

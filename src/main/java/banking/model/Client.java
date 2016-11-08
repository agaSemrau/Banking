package banking.model;

import java.util.ArrayList;
import java.util.List;

public class Client  {
    private String name;
    private String surname;
    private long pesel;
    private List<Account> ACCOUNTS_LIST = new ArrayList<Account>();
    private List<Investment> INVESTMENTS_LIST = new ArrayList<Investment>();


    public Client(String name, String surname, long pesel) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
    }


    public long getPesel() {
        return pesel;
    }

    public List<Account> getACCOUNTS_LIST() {
        return ACCOUNTS_LIST;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }


    public void setACCOUNTS_LIST(List<Account> ACCOUNTS_LIST) {
        this.ACCOUNTS_LIST = ACCOUNTS_LIST;
    }

    public void setINVESTMENTS_LIST(List<Investment> INVESTMENTS_LIST) {
        this.INVESTMENTS_LIST = INVESTMENTS_LIST;
    }

    public List<Investment> getINVESTMENTS_LIST() {
        return INVESTMENTS_LIST;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", pesel=" + pesel +
                ", ACCOUNTS_LIST=" + ACCOUNTS_LIST +
                ", INVESTMENTS_LIST=" + INVESTMENTS_LIST +
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

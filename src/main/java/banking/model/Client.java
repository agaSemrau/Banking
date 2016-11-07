package banking.model;

import java.util.ArrayList;
import java.util.List;

public class Client  {
    private String name;
    private String surname;
    private long id;
    private long pesel;
    private List<Account> ACCOUNTS_LIST = new ArrayList<Account>();
    private List<Investment> INVESTMENTS_LIST = new ArrayList<Investment>();


    public Client(String name, String surname, long id, long pesel) {
        this.name = name;
        this.surname = surname;
        this.id = id;
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

    public long getId() {
        return id;
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
                ", id=" + id +
                ", pesel=" + pesel +
                ", ACCOUNTS_LIST=" + ACCOUNTS_LIST +
                ", INVESTMENTS_LIST=" + INVESTMENTS_LIST +
                '}';
    }
}

package banking.model;

import banking.controller.CreateClient;

import java.util.List;

public class Client  {
    String name;
    String surname;
    long id;
    long pesel;
    List<Account> ACCOUNTS_LIST;
    List<Investment> INVESTMENTS_LIST;


    public Client(String name, String surname, long id, long pesel, List<Account> ACCOUNTS_LIST, List<Investment> INVESTMENTS_LIST) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.pesel = pesel;
        this.ACCOUNTS_LIST = ACCOUNTS_LIST;
        this.INVESTMENTS_LIST = INVESTMENTS_LIST;
    }

    public Client findClient(long pesel) {
        for (Client klient : CreateClient.CLIENTS_LIST) {
            if (klient.getPesel() == pesel) {
                System.out.println(klient);
                return klient;
            }
        }
        System.out.println("Klient nie został znaleziony");
        return null;
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

    public long getPesel() {
        return pesel;
    }

    public List<Account> getACCOUNTS_LIST() {
        return ACCOUNTS_LIST;
    }

    public void setACCOUNTS_LIST(List<Account> ACCOUNTS_LIST) {
        this.ACCOUNTS_LIST = ACCOUNTS_LIST;
    }

    public void setINVESTMENTS_LIST(List<Investment> INVESTMENTS_LIST) {
        this.INVESTMENTS_LIST = INVESTMENTS_LIST;
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

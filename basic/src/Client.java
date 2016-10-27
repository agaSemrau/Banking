package src;

import static src.NowyKlient.CLIENTS_LIST;

public class Client  {
    String name;
    String surname;
    long id;
    long pesel;

    public Client( String name, String surname, long id, Long pesel) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.pesel = pesel;
    }

    public Client findClient(long pesel) {
        for (Client klient : CLIENTS_LIST) {
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

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", id=" + id +
                ", pesel=" + pesel +
                '}';
    }
}

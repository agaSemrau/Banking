package src;

import static src.DodajKlienta.CLIENTS_LIST;

public class Client  {
    String name;
    String surname;
    Long id;
    long pesel;

    public Client( String name, String surname, Long id, Long pesel) {
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



    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getPesel() {
        return pesel;
    }

    public void setPesel(long pesel) {
        this.pesel = pesel;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", id=" + id +
                '}';
    }

}

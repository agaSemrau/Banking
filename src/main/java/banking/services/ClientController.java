package banking.services;

import banking.model.Client;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;


public class ClientController {

    public static final java.util.List<Client> CLIENTS_LIST = new ArrayList<Client>();
    private static AtomicLong nextId = new AtomicLong();
    private static long idCounter() {
        return nextId.getAndIncrement();
    }


    public static Client createClient(String name, String surname, int pesel){

        Client klient = new Client(name, surname, idCounter(), pesel);
        CLIENTS_LIST.add(klient);
        return klient;

    }

    public static Client findClient(long pesel) {
        Client theClient = null;
        for (Client klient : CLIENTS_LIST) {
            if (klient.getPesel() == pesel) {
                theClient = klient;
            }
        }
        return theClient;
    }
}

package banking.controller;

import banking.model.Account;
import banking.model.Client;
import banking.model.Investment;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import static banking.controller.CreateInvestment.INVESTMENTS_LIST;
import static banking.controller.ServicesController.ACCOUNTS_LIST;

public class ClientController {

    public static final java.util.List<Client> CLIENTS_LIST = new ArrayList<Client>();
    private static AtomicLong nextId = new AtomicLong();
    private static long idCounter() {
        return nextId.getAndIncrement();
    }


    public static void createClient(String name, String surname, int pesel){

        Client klient = new Client(name, surname, idCounter(), pesel, ACCOUNTS_LIST, INVESTMENTS_LIST);
        CLIENTS_LIST.add(klient);

        System.out.println(klient.toString());
        System.out.println(CLIENTS_LIST);

    }

    public static Client findClient(long pesel) {
        for (Client klient : CLIENTS_LIST) {
            if (klient.getPesel() == pesel) {
                System.out.println(klient);
                return klient;
            }else {
                System.out.println("Klient nie został znaleziony");
                return null;
            }
        }
        return null;
    }
}

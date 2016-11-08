package banking.services;

import banking.model.Client;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ClientService {

    @PersistenceContext
    private EntityManager entityManager;

    private static final java.util.List<Client> CLIENTS_LIST = new ArrayList<Client>();


    @Transactional
    public Client createClient(String name, String surname, int pesel){
        Client klient = new Client(name, surname, pesel);
        CLIENTS_LIST.add(klient);
        return klient;
    }

    public Client findClient(long pesel) {
        Client theClient = null;
        for (Client klient : CLIENTS_LIST) {
            if (klient.getPesel() == pesel) {
                theClient = klient;
            }
        }
        return theClient;
    }
}

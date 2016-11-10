package banking.services;

import banking.model.Client;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ClientService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Client createClient(String name, String surname, long pesel){
        Client client = new Client(name, surname, pesel);

        entityManager.persist(client);
        entityManager.flush();

        return client;
    }

    public Client findClient(long pesel) {
        Client c = entityManager.find(Client.class, pesel);
        Hibernate.initialize(c);
        return c;
    }

    public List<Client> getClientList(){
        Query q =entityManager.createQuery("Select c from Client c");
        return q.getResultList();
    }


}

package banking.services;

import banking.model.Account;
import banking.model.Client;
import banking.model.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;


@Repository
public class AccountsService {

    public static final List<Account> ACCOUNTS_LIST = new ArrayList<Account>();
    private static final long LIMIT = 10000000000L;
    private static long accountNumber = 0;

    @Autowired
    private ClientService clientService;

    @PersistenceContext
    private EntityManager entityManager;

    private long nadajNumerKonta() {
        long id = System.currentTimeMillis() % LIMIT;
        if ( id <= accountNumber ) {
            id = (accountNumber + 1) % LIMIT;
        }
        return accountNumber = id;
    }

    @Transactional
    public Account openAccount(Currency currency, long pesel, double balance) {
        Client client = clientService.findClient(pesel);
        Account newAccount = new Account(currency, nadajNumerKonta(), client, balance);

        entityManager.persist(newAccount);

        client.getAccountsList().add(newAccount);
        entityManager.flush();

        return newAccount;
    }

    public Account findAccount(long accountNr) {
        return entityManager.find(Account.class, accountNr);
    }

    public List<Account> findAccountListByPesel(long pesel) {
        //return entityManager.createQuery("SELECT a FROM Account a WHERE a.client LIKE :clientData").setParameter("clientData", clientService.findClient(pesel)).getResultList();
        return entityManager.createQuery("SELECT a FROM Account a WHERE a.client.pesel = :pesel").setParameter("pesel", pesel).getResultList();
    }
}

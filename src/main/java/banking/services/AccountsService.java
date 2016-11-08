package banking.services;

import banking.model.Account;
import banking.model.Client;
import banking.model.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class AccountsService {

    public static final List<Account> ACCOUNTS_LIST = new ArrayList<Account>();
    private static final long LIMIT = 10000000000L;
    private static long accountNumber = 0;

    @Autowired
    private ClientService clientService;

    private long nadajNumerKonta() {
        long id = System.currentTimeMillis() % LIMIT;
        if ( id <= accountNumber ) {
            id = (accountNumber + 1) % LIMIT;
        }
        return accountNumber = id;
    }


    public Account openAccount(Currency currency, long pesel, double balance) {
        Client klient = clientService.findClient(pesel);
        Account newAccount = new Account(currency, nadajNumerKonta(), klient.getPesel(), balance);
        ACCOUNTS_LIST.add(newAccount);
        klient.getACCOUNTS_LIST().add(newAccount);
        return newAccount;
    }

    public Account findAccount(long kontoNr) {
        Account theAccount = null;
        for (Account account : ACCOUNTS_LIST) {
            if (account.getAccountNumber() == kontoNr) {
                theAccount = account;
            }
        }
        return theAccount;
    }

    public Account findAccountByPesel(long pesel) {
        Account theAccount = null;
        for (Account account : ACCOUNTS_LIST) {
            if (account.getClientPesel() == pesel) {
                theAccount = account;
            }
        }
        return theAccount;
    }
}

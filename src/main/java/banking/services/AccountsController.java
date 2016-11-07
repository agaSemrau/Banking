package banking.services;

import banking.model.Account;
import banking.model.Client;
import banking.model.Currency;

import java.util.ArrayList;
import java.util.List;

import static banking.services.ClientController.findClient;
import static banking.view.OpenAccountForm.getSelectedCurrency;

public class AccountsController {

    public static final List<Account> ACCOUNTS_LIST = new ArrayList<Account>();
    private static final long LIMIT = 10000000000L;
    private static long accountNumber = 0;

    public static long nadajNumerKonta() {
        long id = System.currentTimeMillis() % LIMIT;
        if ( id <= accountNumber ) {
            id = (accountNumber + 1) % LIMIT;
        }
        return accountNumber = id;
    }


    public static Account openAccount(Currency currency, long pesel) {
        Client klient = findClient(pesel);
        Account newAccount = new Account(currency, nadajNumerKonta(), klient.getPesel());
        ACCOUNTS_LIST.add(newAccount);
        klient.getACCOUNTS_LIST().add(newAccount);
        return newAccount;
    }

    public static Account findAccount(long kontoNr) {
        Account theAccount = null;
        for (Account account : ACCOUNTS_LIST) {
            if (account.getNumerKonta() == kontoNr) {
                theAccount = account;
            }
        }
        return theAccount;
    }

    public static Account findAccountByPesel(long pesel) {
        Account theAccount = null;
        for (Account account : ACCOUNTS_LIST) {
            if (account.getClientPesel() == pesel) {
                theAccount = account;
            }
        }
        return theAccount;
    }
}

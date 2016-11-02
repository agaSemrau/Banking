package banking.controller;

import banking.model.Account;
import banking.model.Client;

import java.util.ArrayList;
import java.util.List;


import static banking.controller.ClientController.findClient;
import static banking.model.forms.OpenAccountForm.getSelectedCurrency;


public class ServicesController {

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


    public static void openAccount(long pesel) {

        Client klient = findClient(pesel);
        getSelectedCurrency();

        Account noweAccount = new Account( getSelectedCurrency(), nadajNumerKonta());

        System.out.println("Twój numer konta to: " + noweAccount.getNumerKonta());

        ACCOUNTS_LIST.add(noweAccount);
        klient.setACCOUNTS_LIST(ACCOUNTS_LIST);
        System.out.println(klient);
    }

}

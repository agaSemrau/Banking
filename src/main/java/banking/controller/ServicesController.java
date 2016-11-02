package banking.controller;

import banking.model.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


import static banking.controller.ClientController.findClient;
import static banking.view.OpenAccountForm.getSelectedCurrency;


public class ServicesController {

    public static final List<Account> ACCOUNTS_LIST = new ArrayList<Account>();
    public static final List<Investment> INVESTMENTS_LIST = new ArrayList<Investment>();
    static Calendar dzisiaj = Calendar.getInstance();


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

    public static Account findAccount(long kontoNr) {
        for (Account account : ACCOUNTS_LIST) {
            if (account.getNumerKonta() == kontoNr) {
                System.out.println(account);
                return account;
            }
        }
        System.out.println("Account nie zostało znalezione");
        return null;
    }



    static public String ustaleDateZalozeniaLokaty() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return sdf.format(dzisiaj.getTime());
    }


    public static Investment openInvestment(long pesel, String waluta, int czasTrwania, long kwotaLokaty ) {

        long numerKontaLokaty = nadajNumerKonta();
        Client klient = findClient(pesel);


        Calendar dataRozpoczeciaPromocji = Calendar.getInstance();
        dataRozpoczeciaPromocji.set(2016, 10, 28, 15, 40);

        Investment nowaInvestment = new InvestmentType1(waluta, numerKontaLokaty, czasTrwania, kwotaLokaty, ustaleDateZalozeniaLokaty());

        if (dataRozpoczeciaPromocji.compareTo(dzisiaj) >= 0) {


            if (kwotaLokaty > 10000) {
                nowaInvestment = new InvestmentType2(waluta, numerKontaLokaty, czasTrwania, kwotaLokaty, ustaleDateZalozeniaLokaty());
            }
            if (kwotaLokaty < 1000) {
                nowaInvestment = new InvestmentType3(waluta, numerKontaLokaty, czasTrwania, kwotaLokaty, ustaleDateZalozeniaLokaty());
            }
            if (kwotaLokaty > 1000 && kwotaLokaty<5000) {
                nowaInvestment = new InvestmentType4(waluta, numerKontaLokaty, czasTrwania, kwotaLokaty, ustaleDateZalozeniaLokaty());
            }


            System.out.println("Twój numer konta lokaty to: " + numerKontaLokaty);
            System.out.println(nowaInvestment);

            INVESTMENTS_LIST.add(nowaInvestment);
            klient.setINVESTMENTS_LIST(INVESTMENTS_LIST);

            System.out.println(klient);


        }
        return nowaInvestment;
    }

}

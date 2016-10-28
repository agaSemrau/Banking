package banking.controller;


import banking.model.Account;
import banking.model.Client;
import banking.model.InvestmentTime;
import banking.model.Investment;

import java.text.SimpleDateFormat;
import java.util.*;

public class CreateInvestment {

    public static final List<Investment> LOKATY_LIST = new ArrayList<Investment>();
    private long kwotaLokaty;
    double wysokoscOprocentowania;
    String dataZalozeniaLokaty;
    Calendar dzisiaj = Calendar.getInstance();



    int czasTrwania = 0;

    public void czyChceszZalozycLokate() {
        System.out.println("Czy chcesz założyć lokatę? T/N");

        Scanner scanner = new Scanner(System.in);
        boolean wantToAdd = false;
        if (scanner.next().equals("T")) {
            wantToAdd = true;
        }

        if (wantToAdd == true) {
            zalozLokate();
        } else {
            System.out.println("Dziękujemy za wizytę");
            return;
        }
    }

    private int wybierzCzasTrwaniaLokaty() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Na ile miesięcy chcesz założyć lokatę?: 1, 3 czy 6 ?");
        String wybranyCzasTrwania = scanner.next() ;
        int czas = Integer.parseInt(wybranyCzasTrwania);

        for (InvestmentTime c: InvestmentTime.values()){
            int d = c.getNumVal();
            if(d==czas){
                czasTrwania = d;
                System.out.println(czasTrwania);
            }
        }
        System.out.println(czasTrwania);
        return czasTrwania;

    }

    private static Account znajdzKonto (long kontoNr) {
        for (Account account : CreateAccount.ACCOUNTS_LIST) {
            if (account.getNumerKonta() ==kontoNr) {
                System.out.println(account);
                return account;
            }
        }
        System.out.println("Account nie zostało znalezione");
        return null;
    }

    private long ustalKwoteLokaty () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Na jaką kwotę chcesz założyć lokatę?");
        kwotaLokaty = Long.parseLong(scanner.next());
        return kwotaLokaty;
    }

    private String ustaleDateZalozeniaLokaty(){
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        long jedenDzien = 24 * 60 * 60 * 1000;
        return sdf.format(dzisiaj.getTime());
    }

    private double ustalOprocentowanie () {

        Calendar dataRozpoczeciaPromocji = Calendar.getInstance();
        dataRozpoczeciaPromocji.set(2016,10,28,15,40);

        if(dataRozpoczeciaPromocji.compareTo(dzisiaj)<0){
            wysokoscOprocentowania = 0.025;
        }
        else {

            if(kwotaLokaty>10000){
                wysokoscOprocentowania = 0.02;
            }
            if(kwotaLokaty<1000){
                wysokoscOprocentowania = 0.01;
            }
            if(kwotaLokaty>1000){
                wysokoscOprocentowania = 0.015;
            }
        }
        return wysokoscOprocentowania;
    }



    private void zalozLokate(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj numer pesel");
        long pesel = Long.parseLong(scanner.next());
        System.out.println("Podaj numer konta");
        long kontoNr = Long.parseLong(scanner.next());

        Client klient = CreateAccount.findClient(pesel);
        Account account = znajdzKonto(kontoNr);
        long numerKontaLokaty = CreateAccount.nadajNumerKonta();


        assert klient != null;
        assert account != null;

        Investment nowaInvestment = new Investment(account.getWaluta(), numerKontaLokaty,  wybierzCzasTrwaniaLokaty(), ustalOprocentowanie(), ustalKwoteLokaty(), ustaleDateZalozeniaLokaty());
        System.out.println("Twój numer konta lokaty to: " + numerKontaLokaty);
        System.out.println(nowaInvestment);
        LOKATY_LIST.add(nowaInvestment);

    }
}

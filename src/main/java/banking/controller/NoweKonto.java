package banking.basics.controller;

import banking.basics.model.Client;
import banking.basics.model.Konto;
import banking.basics.model.Waluty;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class NoweKonto {

    public static final List<Konto> ACCOUNTS_LIST = new ArrayList<Konto>();

    String waluta = "";


    public static Client findClient(long pesel) {
        for (Client klient : NowyKlient.CLIENTS_LIST) {
            if (klient.getPesel() == pesel) {
                System.out.println(klient);
                return klient;
            }else {
                System.out.println("Klient nie został znaleziony");

            }
        }
        return null;
    }

    private static final long LIMIT = 10000000000L;
    private static long accountNumber = 0;

    public static long nadajNumerKonta() {
        long id = System.currentTimeMillis() % LIMIT;
        if ( id <= accountNumber ) {
            id = (accountNumber + 1) % LIMIT;
        }
        return accountNumber = id;
    }

    public void wybierzWalute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wybierz jedną z walut: PLN, EUR, USD, CHF");

        String wybranaWaluta = scanner.next().toUpperCase();
        Waluty wybrana=Waluty.valueOf(wybranaWaluta);

        System.out.println(wybrana);

        waluta = wybrana.toString();
    }


    public void zalozKonto() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj numer pesel");
        long pesel = Long.parseLong(scanner.next());

        Client klient = findClient(pesel);


            wybierzWalute();

        Konto noweKonto = new Konto(klient.getName(), klient.getSurname(), klient.getId(), klient.getPesel(), waluta, nadajNumerKonta());
        System.out.println("Twój numer konta to: " + noweKonto.getNumerKonta());
        ACCOUNTS_LIST.add(noweKonto);
    }


    public void czyChceszZalozycKonto() {
        System.out.println("Czy chcesz założyć konto? T/N");

        Scanner scanner = new Scanner(System.in);
        boolean wantToAdd = false;
        if (scanner.next().equals("T")) {
            wantToAdd = true;
        }

        if (wantToAdd == true) {
            zalozKonto();
            czyChceszZalozycKonto();
        } else {
            System.out.println("Dziękujemy za wizytę");
            return;
        }
    }
}

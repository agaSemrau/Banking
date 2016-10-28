package banking.basics.controller;


import banking.basics.model.Client;
import banking.basics.model.CzasTrwaniaLokaty;
import banking.basics.model.Konto;
import banking.basics.model.Lokata;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NowaLokata {

    public static final List<Lokata> LOKATY_LIST = new ArrayList<Lokata>();

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

    public int wybierzCzasTrwaniaLokaty() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Na ile miesięcy chcesz założyć lokatę?: 1, 3 czy 6 ?");
        String wybranyCzasTrwania = scanner.next() ;
        int czas = Integer.parseInt(wybranyCzasTrwania);

        for (CzasTrwaniaLokaty c: CzasTrwaniaLokaty.values()){
            int d = c.getNumVal();
            if(d==czas){
                czasTrwania = d;
                System.out.println(czasTrwania);
            }
        }
        System.out.println(czasTrwania);
        return czasTrwania;

    }

    public static Konto znajdzKonto (long kontoNr) {
        for (Konto konto : NoweKonto.ACCOUNTS_LIST) {
            if (konto.getNumerKonta() ==kontoNr) {
                System.out.println(konto);
                return konto;
            }
        }
        System.out.println("Konto nie zostało znalezione");
        return null;
    }



    public void zalozLokate(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj numer pesel");
        long pesel = Long.parseLong(scanner.next());
        System.out.println("Podaj numer konta");
        long kontoNr = Long.parseLong(scanner.next());

        Client klient = NoweKonto.findClient(pesel);
        Konto konto = znajdzKonto(kontoNr);
        long numerKontaLokaty = NoweKonto.nadajNumerKonta();


        assert klient != null;
        assert konto != null;

        Lokata nowaLokata = new Lokata(klient.getName(), klient.getSurname(), klient.getId(), klient.getPesel(), konto.getWaluta(), konto.getNumerKonta(), konto.getWaluta(), numerKontaLokaty,  wybierzCzasTrwaniaLokaty() );
        System.out.println("Twój numer konta lokaty to: " + numerKontaLokaty);
        System.out.println(nowaLokata);
        LOKATY_LIST.add(nowaLokata);

    }
}

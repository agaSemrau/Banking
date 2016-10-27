package src;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static src.DodajKlienta.CLIENTS_LIST;
import static src.ZalozKonto.ACCOUNTS_LIST;

public class DodajLokate {

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
        CzasTrwaniaLokaty wybrany = CzasTrwaniaLokaty.valueOf(wybranyCzasTrwania);
        String wybranyString = wybrany.toString();
        int gotowy = Integer.parseInt(wybranyString);

        System.out.println(wybrany);

        czasTrwania = gotowy;

        return gotowy;
    }

    public static Konto znajdzKonto (long pesel) {
        for (Konto konto : ACCOUNTS_LIST) {
            if (konto.getPesel() == pesel) {
                System.out.println(konto);
                return konto;
            }
        }
        System.out.println("Klient nie został znaleziony");
        return null;
    }

    public void zalozLokate(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj numer pesel");
        long pesel = Long.parseLong(scanner.next());

        Client klient = ZalozKonto.findClient(pesel);
        Konto konto = znajdzKonto(pesel);
        long numerKontaLokaty = ZalozKonto.nadajNumerKonta();

        wybierzCzasTrwaniaLokaty();

        Lokata nowaLokata = new Lokata(klient.getName(), klient.getSurname(), klient.getId(), klient.getPesel(), konto.getWaluta(), konto.getNumerKonta(), konto.getWaluta(), numerKontaLokaty,  wybierzCzasTrwaniaLokaty() );
        System.out.println("Twój numer konta to: " + numerKontaLokaty);
        System.out.println(nowaLokata);
        LOKATY_LIST.add(nowaLokata);

    }
}

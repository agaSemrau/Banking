package banking.controller;


import banking.model.*;

import java.text.SimpleDateFormat;
import java.util.*;

public class CreateInvestment {

    public static final List<Investment> INVESTMENTS_LIST = new ArrayList<Investment>();

    private long kwotaLokaty;
    double wysokoscOprocentowania;
    Calendar dzisiaj = Calendar.getInstance();
    private int czasTrwania = 0;

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
        String wybranyCzasTrwania = scanner.next();
        int czas = Integer.parseInt(wybranyCzasTrwania);

        for (InvestmentPeriod c : InvestmentPeriod.values()) {
            int d = c.getNumVal();
            if (d == czas) {
                czasTrwania = d;
            }
        }
        return czasTrwania;

    }

    private static Account znajdzKonto(long kontoNr) {
        for (Account account : CreateAccount.ACCOUNTS_LIST) {
            if (account.getNumerKonta() == kontoNr) {
                System.out.println(account);
                return account;
            }
        }
        System.out.println("Account nie zostało znalezione");
        return null;
    }

    private long ustalKwoteLokaty() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Na jaką kwotę chcesz założyć lokatę?");
        kwotaLokaty = Long.parseLong(scanner.next());
        return kwotaLokaty;

    }

    private String ustaleDateZalozeniaLokaty() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return sdf.format(dzisiaj.getTime());
    }


    private Investment zalozLokate() {
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

        Calendar dataRozpoczeciaPromocji = Calendar.getInstance();
        dataRozpoczeciaPromocji.set(2016, 10, 28, 15, 40);

        Investment nowaInvestment = new InvestmentType1(account.getWaluta(), numerKontaLokaty, czasTrwania, kwotaLokaty, ustaleDateZalozeniaLokaty());

        if (dataRozpoczeciaPromocji.compareTo(dzisiaj) >= 0) {


            if (kwotaLokaty > 10000) {
                nowaInvestment = new InvestmentType2(account.getWaluta(), numerKontaLokaty, czasTrwania, kwotaLokaty, ustaleDateZalozeniaLokaty());
            }
            if (kwotaLokaty < 1000) {
                nowaInvestment = new InvestmentType3(account.getWaluta(), numerKontaLokaty, czasTrwania, kwotaLokaty, ustaleDateZalozeniaLokaty());
            }
            if (kwotaLokaty > 1000) {
                nowaInvestment = new InvestmentType4(account.getWaluta(), numerKontaLokaty, czasTrwania, kwotaLokaty, ustaleDateZalozeniaLokaty());
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

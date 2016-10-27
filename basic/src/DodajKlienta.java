package src;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

public class DodajKlienta {
    public static final List<Client> CLIENTS_LIST = new ArrayList<Client>();
    private static Scanner scanner = new Scanner(System.in);
    private static AtomicLong nextId = new AtomicLong();
    private static long idCounter() {
        return nextId.getAndIncrement();
    }

    public void dodajKlienta(){

        System.out.println("Czy chcesz dodać nowego klienta? Wciśnij T/N");

        Scanner n = new Scanner(System.in);
        boolean wantToAdd = false;
        if(n.next().equals("T")){
            wantToAdd = true;
        }

        String imie = "";
        String nazwisko = "";
        long id;
        long pesel;

        if (wantToAdd == true){

            System.out.println("Podaj imię");
            imie = scanner.next();
            System.out.println("Podaj nazwisko");
            nazwisko = scanner.next();
            System.out.println("Podaj numer pesel");
            pesel = Long.parseLong(scanner.next());

            Client klient = new Client(imie, nazwisko, idCounter(), pesel);
            CLIENTS_LIST.add(klient);

            System.out.println(klient.toString());
            System.out.println(CLIENTS_LIST);
            System.out.println("Nowy klient został dodany");


        }else {
            System.out.println("Dziękujemy za wizytę");
            return;
        }


        DodajKlienta nowyKlient = new DodajKlienta();
        nowyKlient.dodajKlienta();
    }
}

package src;

public class Main {

    public static void main(String[] args){
        DodajKlienta nowyKlient = new DodajKlienta();
        ZalozKonto noweKonto = new ZalozKonto();
        DodajLokate nowaLokata = new DodajLokate();
        nowyKlient.dodajKlienta();
        noweKonto.czyChceszZalozycKonto();
        nowaLokata.czyChceszZalozycLokate();

    }
}

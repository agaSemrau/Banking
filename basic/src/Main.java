package src;

public class Main {

    public static void main(String[] args){
        NowyKlient nowyKlient = new NowyKlient();
        NoweKonto noweKonto = new NoweKonto();
        NowaLokata nowaLokata = new NowaLokata();
        nowyKlient.dodajKlienta();
        noweKonto.czyChceszZalozycKonto();
        nowaLokata.czyChceszZalozycLokate();

    }
}

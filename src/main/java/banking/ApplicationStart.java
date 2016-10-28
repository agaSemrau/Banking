package banking.basics;

import banking.basics.controller.NowaLokata;
import banking.basics.controller.NoweKonto;
import banking.basics.controller.NowyKlient;

public class ApplicationStart {

    public static void main(String[] args){
        NowyKlient nowyKlient = new NowyKlient();
        NoweKonto noweKonto = new NoweKonto();
        NowaLokata nowaLokata = new NowaLokata();
        nowyKlient.dodajKlienta();
        noweKonto.czyChceszZalozycKonto();
        nowaLokata.czyChceszZalozycLokate();

    }
}

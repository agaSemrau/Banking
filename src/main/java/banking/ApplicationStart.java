package banking;

import banking.controller.CreateInvestment;
import banking.controller.CreateAccount;
import banking.controller.CreateClient;

public class ApplicationStart {

    public static void main(String[] args){
        CreateClient createClient = new CreateClient();
        CreateAccount createAccount = new CreateAccount();
        CreateInvestment createInvestment = new CreateInvestment();
        createClient.dodajKlienta();
        createAccount.czyChceszZalozycKonto();
        createInvestment.czyChceszZalozycLokate();

    }
}

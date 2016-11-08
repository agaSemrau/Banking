package banking.services;

import banking.model.Account;
import banking.model.Client;
import banking.model.Currency;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@RunWith(SpringRunner.class)
public class AccountsServiceTest {

    @Autowired
    AccountsService accountsService;

    @Autowired
    ClientService clientService;

    @Test
    public void testOpenAccount() {
        Client newClient = clientService.createClient("Aga", "Lamaga", 123);
        Account newAccount =  accountsService.openAccount(Currency.EUR, 123, 0);
        assertEquals(newAccount.getCurrency(),Currency.EUR);
        assertEquals(newAccount.getClientPesel(), 123);
        assertTrue(newAccount.getBalance()== 0);
    }

    @Test
    public void testFindAccount(){
        Client newClient = clientService.createClient("Pola", "Monola", 124);
        Account newAccount =  accountsService.openAccount(Currency.EUR, 124, 0);
        Account accResult = accountsService.findAccount(newAccount.getAccountNumber());
        assertEquals(newAccount, accResult);
    }

    @Test
    public void testFindAccountByPesel(){
        Client newClient = clientService.createClient("Fela", "Pomela", 333);
        Account newAccount =  accountsService.openAccount(Currency.EUR, 333, 22);
        Account accResult = accountsService.findAccountByPesel(333);
        assertEquals(newAccount, accResult);
    }

    @Test
    public void testDoNotFindAccountByPesel(){
        Account accResult = accountsService.findAccountByPesel(444);
        assertTrue(accResult==null);
    }

    @Test
    public void testDoNotFindAccountByAccNAme(){
        Account account = accountsService.findAccount(12345);
        assertTrue(account == null);
    }



}

package banking.services;

import banking.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@RunWith(SpringRunner.class)
public class InvestmentsServiceTest {
    @Autowired
    InvestmentsService investmentsService;

    @Autowired
    ClientService clientService;

    @Autowired
    AccountsService accountsService;

    @Test
    public void testOpenInvestment(){
        Client newClient = clientService.createClient("Aga", "Lamaga", 123);
        Account newAccount =  accountsService.openAccount(Currency.EUR, 123, 0);
        Investment newInvestment = investmentsService.openInvestment(newAccount.getAccountNumber(), InvestmentPeriod.ONE_MONTH, 3000);
        assertEquals(newInvestment.getClientPesel(), 123);
        assertEquals(newInvestment.getCurrency(), Currency.EUR );
        assertEquals(newInvestment.getInvestmentPeriod(), InvestmentPeriod.ONE_MONTH);
        assertTrue(newInvestment.getKwotaLokaty() == 3000);
    }

    @Test
    public void testFindInvestmentByPesel(){
        Client newClient = clientService.createClient("Aga", "Blebla", 333);
        Account newAccount =  accountsService.openAccount(Currency.EUR, 333, 0);
        Investment newInvestment = investmentsService.openInvestment(newAccount.getAccountNumber(), InvestmentPeriod.THREE_MONTHS, 1000);
        Investment invResult = investmentsService.findInvestmentByPesel(333);
        assertEquals(newInvestment, invResult);
    }

    @Test
    public void testNotFindInvestmentByPesel(){
        Investment invResult = investmentsService.findInvestmentByPesel(434);
        assertTrue(invResult == null);
    }
}

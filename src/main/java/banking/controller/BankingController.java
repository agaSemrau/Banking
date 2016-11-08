package banking.controller;

import banking.model.*;
import banking.services.AccountsService;
import banking.services.ClientService;
import banking.services.InvestmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static banking.services.AccountsService.*;



@RestController
@EnableSwagger2
public class BankingController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private AccountsService accountsService;

    @Autowired
    private InvestmentsService investmentsService;

    @RequestMapping(value = "/addClient", method = {RequestMethod.POST})
    public void restAddNewClient(@RequestParam() String name, @RequestParam() String surname, @RequestParam() int pesel) {
        clientService.createClient(name, surname, pesel);
    }

    @RequestMapping(value = "/createAccount", method = {RequestMethod.POST})
    public void restAddAccount(@RequestParam() Currency currency, @RequestParam() int pesel, @RequestParam() double balance) {
        accountsService.openAccount(currency, pesel, balance);
    }


    @RequestMapping(value = "/findClient", method = {RequestMethod.GET})
    public Client restFindClient(@RequestParam() int pesel) {
        return clientService.findClient(pesel);
    }

    @RequestMapping(value = "/findAccount", method = {RequestMethod.GET})
    public Account restFindClientsAccountList(@RequestParam() int pesel) {
        return accountsService.findAccountByPesel(pesel);
    }

    @RequestMapping(value = "/openInvestment", method = {RequestMethod.POST})
    public Investment restOpenInvestment(@RequestParam() long accountNumber, @RequestParam() InvestmentPeriod czasTrwania, @RequestParam() long kwotaLokaty) {
        Investment investment = investmentsService.openInvestment(accountNumber, czasTrwania, kwotaLokaty);
        return investment;
    }

    @RequestMapping(value = "/findInvestment", method = {RequestMethod.GET})
    public Investment restFindClientsInvestmentsList(@RequestParam() long pesel) {
        return investmentsService.findInvestmentByPesel(pesel);
    }
}

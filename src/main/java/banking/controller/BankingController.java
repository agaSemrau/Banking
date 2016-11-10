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

import java.util.List;

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
    public void restAddNewClient(@RequestParam() String name, @RequestParam() String surname, @RequestParam() long pesel) {
        clientService.createClient(name, surname, pesel);
    }

    @RequestMapping(value = "/createAccount", method = {RequestMethod.POST})
    public void restAddAccount(@RequestParam() Currency currency, @RequestParam() long pesel, @RequestParam() double balance) {
        accountsService.openAccount(currency, pesel, balance);
    }

    @RequestMapping(value = "/findClient", method = {RequestMethod.GET})
    public Client restFindClient(@RequestParam() long pesel) {
        return clientService.findClient(pesel);
    }


    @RequestMapping(value = "/getClientList", method = {RequestMethod.GET})
    public List<Client> getClientList() {
        return clientService.getClientList();
    }

    @RequestMapping(value = "/findAccountList", method = {RequestMethod.GET})
    public List<Account> restFindClientsAccountList(@RequestParam() long pesel) {
        return accountsService.findAccountListByPesel(pesel);
    }

    @RequestMapping(value = "/findAccount", method = {RequestMethod.GET})
    public Account restFindAccount(@RequestParam() long accNumber) {
        return accountsService.findAccount(accNumber);
    }

    @RequestMapping(value = "/openInvestment", method = {RequestMethod.POST})
    public Investment restOpenInvestment(@RequestParam() long accountNumber, @RequestParam() InvestmentPeriod czasTrwania, @RequestParam() long kwotaLokaty) {
        Investment investment = investmentsService.openInvestment(accountNumber, czasTrwania, kwotaLokaty);
        return investment;
    }

    @RequestMapping(value = "/findInvestment", method = {RequestMethod.GET})
    public List<Investment> restFindClientsInvestmentsList(@RequestParam() long pesel) {
        return investmentsService.findInvestmentListByPesel(pesel);
    }
}

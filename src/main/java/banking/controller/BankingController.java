package banking.controller;

import banking.model.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static banking.services.AccountsController.*;
import static banking.services.ClientController.createClient;
import static banking.services.ClientController.findClient;
import static banking.services.InvestmentsController.findInvestmentByPesel;
import static banking.services.InvestmentsController.openInvestment;

@RestController
@EnableSwagger2
public class BankingController {

    @RequestMapping(value = "/addClient", method = {RequestMethod.POST})
    public void restAddNewClient(@RequestParam() String name, @RequestParam() String surname, @RequestParam() int pesel) {
        createClient(name, surname, pesel);
    }

    @RequestMapping(value = "/createAccount", method = {RequestMethod.POST})
    public void restAddAccount(@RequestParam() Currency currency, @RequestParam() int pesel) {
       openAccount(currency, pesel);
    }

    @RequestMapping(value = "/findClient", method = {RequestMethod.GET})
    public Client restFindClient(@RequestParam() int pesel) {
        return findClient(pesel);
    }

    @RequestMapping(value = "/findAccount", method = {RequestMethod.GET})
    public Account restFindClientsAccountList(@RequestParam() int pesel) {
        return findAccountByPesel(pesel);
    }

    @RequestMapping(value = "/openInvestment", method = {RequestMethod.POST})
    public Investment restOpenInvestment(@RequestParam() long accountNumber, @RequestParam() InvestmentPeriod czasTrwania, @RequestParam() long kwotaLokaty) {
        Investment investment =  openInvestment(accountNumber, czasTrwania, kwotaLokaty);
        return investment;
    }

    @RequestMapping(value = "/findInvestment", method = {RequestMethod.GET})
    public Investment restFindClientsInvestmentsList(@RequestParam() long pesel) {
        return findInvestmentByPesel(pesel);
    }
}

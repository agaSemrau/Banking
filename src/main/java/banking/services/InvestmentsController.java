package banking.services;

import banking.exceptions.NoProductDefinitionFoundException;
import banking.model.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


import static banking.model.StandardInvestmentDefinition.setStartStadnardDepositDate;
import static banking.services.AccountsController.findAccount;


public class InvestmentsController {
    public static final List<Investment> INVESTMENTS_LIST = new ArrayList<Investment>();
    public static final List<InvestmentDefinition> PRODUCT_LIST = new ArrayList<InvestmentDefinition>();
    private static final long LIMIT = 10000000000L;
    private static long accountNumber = 0;


    static {
        java.util.List<Currency> rangedDepositCurrencies = new ArrayList<Currency>();
        rangedDepositCurrencies.add(Currency.EUR);
        rangedDepositCurrencies.add(Currency.USD);

        java.util.List<Currency> standardDepositCurrencies = new ArrayList<Currency>();
        standardDepositCurrencies.add(Currency.PLN);

        List<InvestmentPeriod> investmentPeriodList = new ArrayList<InvestmentPeriod>();
        investmentPeriodList.add(InvestmentPeriod.ONE_MONTH);
        investmentPeriodList.add(InvestmentPeriod.THREE_MONTHS);
        investmentPeriodList.add(InvestmentPeriod.SIX_MONTHS);

        List<Range> rangesList = new ArrayList<Range>();
        rangesList.add(new Range(1, 0.1));
        rangesList.add(new Range(1000, 0.2));
        rangesList.add(new Range(5000, 0.25));

        PRODUCT_LIST.add(new RangedInvestmentDefinition(rangedDepositCurrencies, setStartPromotionDate(), investmentPeriodList, rangesList));
        PRODUCT_LIST.add(new StandardInvestmentDefinition(standardDepositCurrencies, investmentPeriodList));
    }

    public static long nadajNumerKonta() {
        long id = System.currentTimeMillis() % LIMIT;
        if (id <= accountNumber) {
            id = (accountNumber + 1) % LIMIT;
        }
        return accountNumber = id;
    }

    public static Date setStartPromotionDate() {
        Calendar dataRozpoczeciaPromocji = Calendar.getInstance();
        dataRozpoczeciaPromocji.set(2016, 12, 28, 15, 40);
        return dataRozpoczeciaPromocji.getTime();
    }

    public static Investment findInvestmentByPesel(long pesel) {
        Investment theInvestment = null;
        for (Investment investment : INVESTMENTS_LIST) {
            if (investment.getClientPesel() == pesel) {
                theInvestment = investment;
            }
        }
        return theInvestment;
    }




    public static Investment openInvestment(long numerKonta, InvestmentPeriod investmentPeriod, double depositAmount) {
        Account konto = findAccount(numerKonta);
        Currency currency = konto.getWaluta();

        InvestmentDefinition defToUse = getMatchingDefinition(depositAmount, currency, investmentPeriod);
        Investment newInvestment = openInvestmentUsingDefinition(konto.getWaluta(), nadajNumerKonta(), investmentPeriod, depositAmount, new Date(), defToUse, konto.getClientPesel());


        return newInvestment;
    }


    private static InvestmentDefinition getMatchingDefinition(double depositAmmount, Currency currency, InvestmentPeriod period) {
        InvestmentDefinition defToUse = null;
        for (InvestmentDefinition def : PRODUCT_LIST) {
            if (def.isEligible(depositAmmount, currency, new Date(), period)) {
                defToUse = def;
                break;
            }
        }
        return defToUse;
    }

    public static Investment openInvestmentUsingDefinition(Currency walutaLokaty, long numerKontaLokaty, InvestmentPeriod czasTrwaniaLokaty, double kwotaLokaty, Date dataZalozeniaLokaty, InvestmentDefinition definition, long clientPesel) {
        if (definition == null){
            throw new NoProductDefinitionFoundException("Nie udało się");
        }
        Investment newInvestement = new Investment(walutaLokaty, numerKontaLokaty, czasTrwaniaLokaty, kwotaLokaty, dataZalozeniaLokaty, definition.getMatchingRate(kwotaLokaty), clientPesel);

        return newInvestement;
    }
}



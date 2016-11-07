package banking.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class StandardInvestmentDefinition implements InvestmentDefinition {
    private static double rate = 0.3;
    private final List<Currency> currencyList = new ArrayList<Currency>();
    private final List<InvestmentPeriod> investmentPeriodList = new ArrayList<InvestmentPeriod>();

    public StandardInvestmentDefinition(List<Currency> currencyList, List<InvestmentPeriod> investmentPeriodList) {
        this.currencyList.addAll(currencyList);
        this.investmentPeriodList.addAll(investmentPeriodList);
    }

    public boolean isEligible(double ammount, Currency currency, Date openingDate, InvestmentPeriod period) {
        boolean result = false;
        if (currencyList.contains(currency) & investmentPeriodList.contains(period)) {
            result = true;
        }

        return result;
    }


    public double getMatchingRate(double depositAmount){
        return rate;
    }

    public static Date setStartStadnardDepositDate() {
        Calendar dataRozpoczeciaPromocji = Calendar.getInstance();
        dataRozpoczeciaPromocji.set(2015, 9, 28, 15, 40);
        return dataRozpoczeciaPromocji.getTime();
    }


}


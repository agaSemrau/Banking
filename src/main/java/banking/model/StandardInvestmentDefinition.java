package banking.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
@Entity(name="StandardInvestmentDefinition")
@DiscriminatorValue("SID")
public class StandardInvestmentDefinition extends InvestmentDefinition {


    @Column(name = "rate")
    private double rate;
    

    public StandardInvestmentDefinition() {
    }

    public StandardInvestmentDefinition(String definitionName, List<InvestmentPeriod> investmentPeriodList, List<Currency> currencyList, Date startingDate, double rate) {
        super(definitionName, investmentPeriodList, currencyList, startingDate);
        this.rate = rate;
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

    public double getRate() {
        return rate;
    }
}


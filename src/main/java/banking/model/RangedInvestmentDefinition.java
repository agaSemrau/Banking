package banking.model;

import java.util.*;

public class RangedInvestmentDefinition implements InvestmentDefinition {

    private final List<Range> rangesList = new ArrayList<Range>();
    private final List<Currency> currencyList = new ArrayList<Currency>();
    private final List<InvestmentPeriod> investmentPeriodList = new ArrayList<InvestmentPeriod>();
    private final Date startingDate;



    public Range getRange(int i) {
        return rangesList.get(i);
    }

    public List<Range> getRangesList() {
        return rangesList;
    }

    public RangedInvestmentDefinition(List<Currency> currencyList, Date startingDate, List<InvestmentPeriod> investmentPeriodList, List<Range> rangesList) {
        this.currencyList.addAll(currencyList);
        this.startingDate = startingDate;
        this.investmentPeriodList.addAll(investmentPeriodList);
        this.rangesList.addAll(rangesList);
        rangesList.sort(new Comparator<Range>() {
            @Override
            public int compare(Range o1, Range o2) {
                return Double.compare(o1.getMin(), o2.getMin());
            }
        });
        Collections.reverse(rangesList);
    }

    public boolean isEligible(double ammount, Currency currency, Date openingDate, InvestmentPeriod period){
        boolean result = false;
        for (Range range : rangesList){
            if(ammount>=range.getMin() && currencyList.contains(currency) && (startingDate.compareTo(openingDate)>=0) && investmentPeriodList.contains(period) ){
                result = true;
            }
        }
       return result;
    }

    public double getMatchingRate(double depositAmount){
        double rate = 0;
        for (Range range : rangesList){
            if(range.getMin()>=depositAmount)
            rate = range.getRate();
        }
        return rate;
    }


}

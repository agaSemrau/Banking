package banking.model;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Table(name="deposits_definitions")
@DiscriminatorColumn(name="deposit_type",discriminatorType=DiscriminatorType.STRING)
public abstract class InvestmentDefinition {

    @Id
    @Column(name="name", unique = true)
    protected String definitionName;


    @ElementCollection(targetClass=InvestmentPeriod.class)
    @CollectionTable(name="periods", joinColumns = @JoinColumn(name="definition_name"))
    @Column (name="period")
    @Enumerated(EnumType.STRING)
    protected  List<InvestmentPeriod> investmentPeriodList = new ArrayList<InvestmentPeriod>();

    @ElementCollection(targetClass=Currency.class)
    @CollectionTable(name="currencies", joinColumns = @JoinColumn(name="definition_name") )
    @Column(name="currency")
    @Enumerated(EnumType.STRING)
    protected  List<Currency> currencyList = new ArrayList<Currency>();

    @Column(name= "starting_date")
    protected Date startingDate;

    public InvestmentDefinition() {
    }

    public InvestmentDefinition(String definitionName, List<InvestmentPeriod> investmentPeriodList, List<Currency> currencyList, Date startingDate) {
        this.definitionName = definitionName;
        this.investmentPeriodList = investmentPeriodList;
        this.currencyList = currencyList;
        this.startingDate = startingDate;
    }

    public String getDefinitionName() {
        return definitionName;
    }

    public List<InvestmentPeriod> getInvestmentPeriodList() {
        return investmentPeriodList;
    }

    public List<Currency> getCurrencyList() {
        return currencyList;
    }

    public Date getStartingDate() {
        return startingDate;
    }


    public abstract boolean isEligible(double ammount, Currency currency, Date openingDate, InvestmentPeriod period);

    public abstract double getMatchingRate(double depositAmount);

}

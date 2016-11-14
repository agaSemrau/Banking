insert into clients (pesel, name, surname) values ('4422', 'Aga', 'Sem');
insert into accounts(pesel, currency, number, balance) values ('4422', 'PLN', '1000200033', '1000');
insert into deposits_definitions(deposit_type, name, starting_date) values('RID', 'RangedInvestmentDefinition', parsedatetime('10-10-2016 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'));
insert into deposits_definitions(deposit_type, name, starting_date, rate) values('SID', 'StandardInvestmentDefinition', parsedatetime('17-09-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'), 0.3);

insert into currencies (definition_name, currency) values((select name from deposits_definitions where deposit_type='RID'), 'EUR');
insert into currencies (definition_name, currency) values((select name from deposits_definitions where deposit_type='RID'), 'USD');
insert into currencies (definition_name, currency) values((select name from deposits_definitions where deposit_type='SID'), 'PLN');

insert into ranges (definition_name, minimum, rate) values ((select name from deposits_definitions where deposit_type='RID'), 1, 0.1);
insert into ranges (definition_name, minimum, rate) values ((select name from deposits_definitions where deposit_type='RID'), 1000, 0.2);
insert into ranges (definition_name, minimum, rate) values ((select name from deposits_definitions where deposit_type='RID'), 5000, 0.3);


insert into periods (definition_name, period) values ((select name from deposits_definitions where deposit_type='RID'), 'ONE_MONTH');
insert into periods (definition_name, period) values ((select name from deposits_definitions where deposit_type='RID'), 'THREE_MONTHS');
insert into periods (definition_name, period) values ((select name from deposits_definitions where deposit_type='RID'), 'SIX_MONTHS');

insert into periods (definition_name, period) values ((select name from deposits_definitions where deposit_type='SID'), 'ONE_MONTH');
insert into periods (definition_name, period) values ((select name from deposits_definitions where deposit_type='SID'), 'THREE_MONTHS');
insert into periods (definition_name, period) values ((select name from deposits_definitions where deposit_type='SID'), 'SIX_MONTHS');

commit;

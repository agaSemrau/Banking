//package banking.view;
//
//import banking.model.Currency;
//import banking.model.InvestmentPeriod;
//
//import javax.swing.*;
//import javax.swing.event.ListSelectionEvent;
//import javax.swing.event.ListSelectionListener;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import static banking.services.AccountsController.findAccount;
//import static banking.services.ClientController.findClient;
//import static banking.services.InvestmentsController.openInvestment;
//
//
//public class OpenInvestmentForm implements ActionListener {
//
//    static InvestmentPeriod[] investmentPeriod = {InvestmentPeriod.ONE_MONTH, InvestmentPeriod.SIX_MONTHS, InvestmentPeriod.THREE_MONTHS};
//    static JList investmentPeriodList = new JList(investmentPeriod);
//    private static InvestmentPeriod selectedInvestmentPeriod;
//    private static long investmentAmount;
//
//    public static Currency getSelectedCurrency(Currency currency) {
//        System.out.println(currency);
//        return currency;
//    }
//
//
//    public static void createPanel() {
//
//        String[] labels = {"Podaj nr pesel", "Podaj nr konta", "Podaj kwotę lokaty"};
//        char[] mnemonics = {'P', 'A', 'I'};
//        int[] widths = {15, 15, 15};
//        String[] descs = {"Pesel", "Numer konta", "Kwota lokaty"};
//
//        final Form form = new Form(labels, mnemonics, widths, descs);
//
//        JButton submit = new JButton("Submit Form");
//
//        submit.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                int pesel = Integer.parseInt(form.getText(0));
//                long account = Long.parseLong(form.getText(1));
//                investmentAmount = Integer.parseInt(form.getText(2));
//                findClient(pesel);
//                findAccount(account);
//                getSelectedCurrency(findAccount(account).getWaluta());
//                openInvestment(findAccount(account).getWaluta(), selectedInvestmentPeriod, investmentAmount);
//
//            }
//        });
//
//        JScrollPane scroll = new JScrollPane(investmentPeriodList);
//        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
//
//        JFrame f = new JFrame("Text Form Example");
//        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        f.getContentPane().add(form, BorderLayout.NORTH);
//        JPanel p = new JPanel();
//        p.add(submit);
//        p.add(scroll);
//        investmentPeriodList.setVisibleRowCount(4);
//        investmentPeriodList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        investmentPeriodList.addListSelectionListener(new ListSelectionListener() {
//            public void valueChanged(ListSelectionEvent le) {
//                int idx = investmentPeriodList.getSelectedIndex();
//                if (idx != -1)
//                    selectedInvestmentPeriod = investmentPeriod[idx];
//                else
//                    System.out.println("Please choose a cuurency.");
//            }
//        });
//        f.getContentPane().add(p, BorderLayout.SOUTH);
//        f.pack();
//        f.setVisible(true);
//    }
//
//
//    public static void createOpenInvestmentForm() {
//
//        createPanel();
//    }
//
//    public void actionPerformed(ActionEvent e) {
//        createOpenInvestmentForm();
//    }
//
//}

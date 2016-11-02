package banking.view;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static banking.controller.ClientController.findClient;
import static banking.controller.ServicesController.findAccount;
import static banking.controller.ServicesController.openInvestment;

public class OpenInvestmentForm implements ActionListener {

    static String[] investmentPeriod = {"1", "3", "6"};
    static JList investmentPeriodList = new JList(investmentPeriod);
    static int selectedInvestmentPeriod;

    public static int getSelectedInvestmentPeriod() {
        return selectedInvestmentPeriod;
    }



    public static void createPanel() {

        String[] labels = {"Podaj nr pesel", "Podaj nr konta", "Podaj kwotę lokaty"};
        char[] mnemonics = { 'P', 'A', 'I'};
        int[] widths = { 15, 15, 15 };
        String[] descs = { "Pesel", "Numer konta", "Kwota lokaty"  };

        final Form form = new Form(labels, mnemonics, widths, descs);

        JButton submit = new JButton("Submit Form");

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int pesel = Integer.parseInt(form.getText(0));
                long account = Long.parseLong(form.getText(1));
                long investmentAmount = Integer.parseInt(form.getText(2));
                findClient(pesel);
                findAccount(account);
                openInvestment(pesel, findAccount(account).getWaluta(), selectedInvestmentPeriod, investmentAmount);

            }
        });

        JScrollPane scroll = new JScrollPane(investmentPeriodList);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        JFrame f = new JFrame("Text Form Example");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.getContentPane().add(form, BorderLayout.NORTH);
        JPanel p = new JPanel();
        p.add(submit);
        p.add(scroll);
        investmentPeriodList.setVisibleRowCount(4);
        investmentPeriodList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        investmentPeriodList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent le) {
                int idx = investmentPeriodList.getSelectedIndex();
                if (idx != -1)
                    selectedInvestmentPeriod =  Integer.parseInt(investmentPeriod[idx]);
                else
                    System.out.println("Please choose a cuurency.");
            }
        });
        f.getContentPane().add(p, BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);
    }



    public static void createOpenInvestmentForm(){
        String[] labels = {};
        char[] mnemonics = {};
        int[] widths = {};
        String[] tips = {};

        createPanel();
    }

    public void actionPerformed(ActionEvent e){
        createOpenInvestmentForm();
    }

}

package banking.view;

import banking.model.Currency;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static banking.services.AccountsController.openAccount;
import static banking.services.ClientController.findClient;


public class OpenAccountForm implements ActionListener {

    static Currency[] waluty = {Currency.USD, Currency.PLN, Currency.EUR};
    static JList listaWalut = new JList(waluty);
    static Currency selectedCurrency;

    public static Currency getSelectedCurrency() {
        return selectedCurrency;
    }


    public static  Currency[] getWaluty() {
        return waluty;
    }

    public static void createPanel() {

        String[] labels = {"Podaj nr pesel"};
        char[] mnemonics = {'P'};
        int[] widths = {15};
        String[] descs = {"Pesel"};

        final Form form = new Form(labels, mnemonics, widths, descs);

        JButton submit = new JButton("Submit Form");

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int pesel = Integer.parseInt(form.getText(0));
//                findClient(pesel);
//                openAccount(pesel);
            }
        });
        JScrollPane scroll = new JScrollPane(listaWalut);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        JFrame f = new JFrame("Text Form Example");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.getContentPane().add(form, BorderLayout.NORTH);
        JPanel p = new JPanel();
        p.add(submit);
        p.add(scroll);
        listaWalut.setVisibleRowCount(4);
        listaWalut.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaWalut.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent le) {
                int idx = listaWalut.getSelectedIndex();
                if (idx != -1)
                    selectedCurrency = waluty[idx];
                else
                    System.out.println("Please choose a cuurency.");
            }
        });
        f.getContentPane().add(p, BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);
    }


    public static void createOpenAccountForm() {
        createPanel();
    }

    public void actionPerformed(ActionEvent e) {
        createOpenAccountForm();
    }
}


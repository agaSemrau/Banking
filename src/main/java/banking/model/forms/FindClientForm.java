package banking.model.forms;

import banking.model.forms.Form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static banking.controller.ClientController.findClient;


public class FindClientForm implements ActionListener{

    public static void createPanel() {
        String[] labels = {"Podaj nr pesel" };
        char[] mnemonics = { 'P'};
        int[] widths = { 15 };
        String[] descs = { "Pesel" };

        final Form form = new Form(labels, mnemonics, widths, descs);

        JButton submit = new JButton("Submit Form");

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int pesel = Integer.parseInt(form.getText(0));
                findClient(pesel);
            }
        });

        JFrame f = new JFrame("Text Form Example");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.getContentPane().add(form, BorderLayout.NORTH);
        JPanel p = new JPanel();
        p.add(submit);
        f.getContentPane().add(p, BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);
    }

    public static void createFindClientForm(){
        String[] labels = {};
        char[] mnemonics = {};
        int[] widths = {};
        String[] tips = {};

        createPanel();
    }

    public void actionPerformed(ActionEvent e){
        createFindClientForm();
    }
}

package banking.model.forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static banking.controller.ClientController.createClient;


public class ClientForm implements ActionListener{

    public static void createPanel() {
        String[] labels = { "Imię", "Nazwisko", "Pesel" };
        char[] mnemonics = { 'N', 'S', 'P' };
        int[] widths = { 15, 15, 15 };
        String[] descs = { "First Name", "Last Name", "Age" };

        final Form form = new Form(labels, mnemonics, widths, descs);

        JButton submit = new JButton("Submit Form");

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int pesel = Integer.parseInt(form.getText(2));
                String name = form.getText(0);
                String surname = form.getText(1);

                createClient(name, surname, pesel);
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

    public static void createClientForm(){
        String[] labels = {};
        char[] mnemonics = {};
        int[] widths = {};
        String[] tips = {};


        createPanel();

    }

    public void actionPerformed(ActionEvent e){
       createClientForm();
    }
}

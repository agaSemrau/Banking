package banking;


import banking.model.forms.ClientForm;
import banking.model.forms.FindClientForm;


import javax.swing.*;
import java.awt.*;

public class ApplicationStart {

    JTextArea showText;

    public static void main(String[] args) {
        ApplicationStart apGUI = new ApplicationStart();
        apGUI.runGUI();
    }
        public void runGUI() {
            JFrame ramka = new JFrame();
            JPanel panelButtons = new JPanel();

            JButton addClient = new JButton("Dodaj klienta");
            JButton showClient = new JButton("Wyszukaj klienta");
            JButton createAccount = new JButton("Załóż konto");
            JButton createInvestment = new JButton("Otwórz lokatę");
            JButton findAccount = new JButton("Wyszukaj konto");
            addClient.addActionListener(new ClientForm());
            showClient.addActionListener(new FindClientForm());
            createAccount.addActionListener(new CreateAccountForm());

            panelButtons.setLayout(new BoxLayout(panelButtons, BoxLayout.Y_AXIS));
            panelButtons.setBackground(Color.black);

//            showText = new JTextArea(10, 40);
//            showText.setLineWrap(true);

//            panelButtons.add(showText);
            panelButtons.add(addClient);
            panelButtons.add(showClient);
            panelButtons.add(createAccount);
            panelButtons.add(createInvestment);
            panelButtons.add(findAccount);

            ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ramka.getContentPane().add(BorderLayout.WEST, panelButtons);
            ramka.setSize(500, 500);
            ramka.setVisible(true);
        }

}

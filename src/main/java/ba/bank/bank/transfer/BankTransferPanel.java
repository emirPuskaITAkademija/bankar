package ba.bank.bank.transfer;

import ba.bank.bank.BankAccount;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class BankTransferPanel extends JPanel {

    private final JComboBox<BankAccount> fromBankAccountComboBox = new JComboBox<>();
    private final JComboBox<BankAccount> toBankAccountComboBox = new JComboBox<>();
    private final JTextField amountTextField = new JTextField();
    private final JButton transferButton = new JButton("Transfer Money");

    public BankTransferPanel() {
        setupUIControls();
        appendUIControls();
    }

    private void setupUIControls() {
        List<BankAccount> bankAccounts = BankAccount.findAll();
        for (BankAccount bankAccount : bankAccounts) {
            fromBankAccountComboBox.addItem(bankAccount);
            toBankAccountComboBox.addItem(bankAccount);
        }
        amountTextField.setColumns(8);
        AbstractDocument document = (AbstractDocument) amountTextField.getDocument();
        NumericAndLengthFilter numericAndLengthFilter = new NumericAndLengthFilter(5);
        document.setDocumentFilter(numericAndLengthFilter);
        transferButton.addActionListener(this::transferButton);
    }

    private void transferButton(ActionEvent event){
        /**
         * Mirsad prebacuje Slađani povrat duga.
         * <li>Dug : 555 KM</li>
         * <li>from account</li>
         * <li>to account </li>
         */
        BankAccount fromBankAccount = (BankAccount) fromBankAccountComboBox.getSelectedItem();
        BankAccount toBankAccount = (BankAccount) toBankAccountComboBox.getSelectedItem();
        if(amountTextField.getText().isBlank()){
            JOptionPane.showMessageDialog(null, "Nije unesen iznos za transfer");
        }else{
            double transferAmount = Double.parseDouble(amountTextField.getText());
            ResponseModel responseModel = BankAccount.transferMoney(fromBankAccount, toBankAccount, transferAmount);
            if(responseModel.isSuccess()){
                refresh();
                JOptionPane.showMessageDialog(null, responseModel.getMessage());
            }else{
                JOptionPane.showMessageDialog(null, responseModel.getMessage());
            }
        }

    }
    private void refresh(){
        List<BankAccount> bankAccounts = BankAccount.findAll();
        for (BankAccount bankAccount : bankAccounts) {
            fromBankAccountComboBox.addItem(bankAccount);
            toBankAccountComboBox.addItem(bankAccount);
        }
        amountTextField.setText("");
    }

    private void appendUIControls() {
        add(fromBankAccountComboBox);
        add(toBankAccountComboBox);
        add(amountTextField);
        add(transferButton);
    }
}

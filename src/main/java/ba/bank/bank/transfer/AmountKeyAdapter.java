package ba.bank.bank.transfer;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AmountKeyAdapter extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {
       JTextField textField = (JTextField) e.getSource();
       textField.setText("");
    }
}

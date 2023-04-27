package ba.bank;

import ba.bank.bank.BankAccount;
import ba.bank.bank.transfer.BankTransferPanel;
import ba.bank.show.Show;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Prednosti:
 * <li>1. mi ne pišemo SQL nego on prilagodi upite za nas u specifičnom SQL dijalektu</li>
 * <li>2. mi pozivamo funkcije i fokusiramo na rezultate tih funkcija koje ostvaruju interakciju s bazom</li>
 *
 * <p>
 * Nedostaci:
 * <li>1. Proces konfiguracije</li>
 * <li>2. Proces mapiranja</li>
 * <li>3. Pravila mapiranja</li>
 * <li>4. Vrlo često su upiti spori</li>
 * </p>
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                createAndShowGUI();
            } catch (UnsupportedLookAndFeelException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private static void createAndShowGUI() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //Windows OS
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        JFrame frame = new JFrame("Bank Transfer");
        frame.setSize(new Dimension(800, 200));
        BankTransferPanel panel = new BankTransferPanel();
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}